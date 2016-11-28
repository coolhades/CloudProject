package com.hades.mylibrary.cloud.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.data.ACache;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.bean.User;
import com.hades.mylibrary.cloud.constant.ConstantSet;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;


public class SearchActivity extends NormalBaseActivity {
    RecyclerView hotCourseRecyclerView;
    RecyclerView historyRecyclerView;

    List<String> hotCourseList;
    List<String> historyList;
    FancyButton cancelBt;
    EditText editText;
    FancyButton clear;

    CommonAdapter historyAdapter;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        hotCourseRecyclerView = (RecyclerView) findViewById(R.id.search_grilview);
        historyRecyclerView = (RecyclerView) findViewById(R.id.search_listview);
        cancelBt = (FancyButton) findViewById(R.id.cancel_bt);
        editText = (EditText) findViewById(R.id.edittext_search);
        clear = (FancyButton) findViewById(R.id.clear);

    }

    @Override
    protected void initData() {
//      获取平台关联的key，以uid+baseurl为key 保存个人信息
        try {
            User user = GsonUtils.getInstance().fromJson(ACache.get(SearchActivity.this).getAsJSONObject("user").toString(), User.class);
            key = user.getUid() + ACache.get(SearchActivity.this).getAsString("user_tag");
            historyList = getHistory();
            initHistory();
        } catch (Exception e) {
            Log.d("TAG-Error", e.getMessage());
        }

        //加载热门课程

    }


    void initHistory(){
        //加载搜索历史
        historyRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        historyAdapter = new CommonAdapter<String>(this, R.layout.history_item, historyList) {

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, String s, final int position) {
                holder.setText(R.id.textcontent, mDatas.get(position));
                holder.getView(R.id.textcontent).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ConstantSet.keyWord = mDatas.get(position);
                        Intent i = new Intent(SearchActivity.this, SearchContentActivity.class);
                        startActivity(i);
                    }
                });
            }
        };
        historyRecyclerView.setAdapter(historyAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        historyAdapter.notifyDataSetChanged();

    }

    @Override
    protected void initEvent() {
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    String key = editText.getText().toString().trim();
                   if (key.equalsIgnoreCase("")) {
                       ToastUtils.showShortToast(SearchActivity.this, R.string.Empty_Error);
                        return false;
                    }
                    //保存搜索key，重复项不保存//取出持久化数据，进行比对
                    if (!isContain(key)) {
                        //保存
                        historyList.add(key);
                        //持久化 保存搜索信息
                        ACache.get(SearchActivity.this, SearchActivity.this.key).put("searchKey", GsonUtils.getInstance().toJson(historyList));
                    }

                    //搜索跳转
                    ConstantSet.keyWord = editText.getText().toString().trim();
                    Intent i = new Intent(SearchActivity.this, SearchContentActivity.class);
                    startActivity(i);

                    return false;
                }
                return false;
            }
        });


        //搜索历史
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyList.clear();
                ACache.get(SearchActivity.this, key).put("searchKey", GsonUtils.getInstance().toJson(historyList));
                historyAdapter.notifyDataSetChanged();
            }
        });
    }

    private Boolean isContain(String key) {
        if (historyList.size() != 0) {
            int size = historyList.size();
            for (int i = 0; i < size; i++) {
                if (key.equalsIgnoreCase(historyList.get(i)))
                    return true;//break if contain key
                //do nothing
            }
            // 历史中没有
            return false;
        }
        return false;
    }

    private List<String> getHistory() {
        List<String> list = new ArrayList<>();

        if (ACache.get(this, key).getAsJSONArray("searchKey") != null) {
            list = GsonUtils.getInstance().fromJson(ACache.get(this, key).getAsJSONArray("searchKey").toString(),
                    new TypeToken<List<String>>() {
                    }.getType());

        }
        return list;
    }
}

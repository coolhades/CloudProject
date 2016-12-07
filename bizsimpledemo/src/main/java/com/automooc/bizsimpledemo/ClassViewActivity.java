package com.automooc.bizsimpledemo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.automooc.bizsimpledemo.bizbase.BaseSortView;
import com.automooc.bizsimpledemo.bizroot.ILoadData;
import com.automooc.bizsimpledemo.bizroot.RootViewActivity;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.LoadImgUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassViewActivity extends RootViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_view);
        initView();
        initData();
        initEvent();
    }



    List<Map<String, String>> list = new ArrayList<>();//
    List<Map<String, String>> templist;//暂存数据
    List<String> sortKey;
    int currentPage;
    int pageSize;

    Map<String, String> map = new HashMap<>();

    private void initData() {
        map.clear();
        simpleOper.doAction("Query", map);//获取数据
        //设置回调接口
        simpleOper.setOnLoadDataLinstener(new ILoadData() {
            @Override
            public void loadData(String s) {
                KLog.json(s);
               list.clear();
                convertData(s);
                initRecycler(list);
            }

            //排序
            @Override
            public void dealReSort(String s) {
                list.clear();
                sortKey.clear();
                convertData(s);
                lRecyclerViewAdapter.notifyDataSetChanged();
            }


            @Override
            public void dealReload(String s) {
                list.clear();
                map.clear();
                sortKey.clear();
                convertData(s);
                lRecyclerView.refreshComplete();
                lRecyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void dealNext(String s) {
                convertData(s);
                lRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

    }

    private void convertData(String s){
        Map<String, Object> alldata = GsonUtils.getInstance().fromJson(s,
                new TypeToken<Map<String, Object>  >(){}.getType());

        KLog.json(GsonUtils.getInstance().toJson(alldata));
        currentPage = Float.valueOf(alldata.get("page").toString()).intValue();
        pageSize = Float.valueOf(alldata.get("pagesize").toString()).intValue();
        templist = GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(alldata.get(simpleOper.model.dataField)),
                new TypeToken< List<Map<String, String>> >(){}.getType());

        if (templist.isEmpty()){
            ToastUtils.showShortToast(ClassViewActivity.this, "已经到底");
            return;
        }
        list.addAll(templist);
        sortKey = new ArrayList<>(list.get(0).keySet());//获取排序key

    }




    private void initRecycler(final List<Map<String, String>> list) {
        adapter = new CommonAdapter<Map<String, String>>(ClassViewActivity.this, R.layout.item, list) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, Map<String, String> stringStringMap, final int position) {
                ImageView image = holder.getView(R.id.image);
                LoadImgUtils.loadBanner(ClassViewActivity.this, stringStringMap.get("valc"), image);
                image.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
//                        map.clear();
//                        map.put("uid", list.get(position).get("uid"));
//                        simpleOper.doAction("Delete", map);
                        return false;
                    }
                });

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        };
        lRecyclerView.setLayoutManager(new GridLayoutManager(ClassViewActivity.this, 1));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setAdapter(lRecyclerViewAdapter);



    }
    View sortView;
    BizSortView bizSortView;
    private void initView() {

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_course_view);
        List<String> title = new ArrayList<>();
        title.add("精华");
        title.add("人气");
        title.add("时间");
        title.add("时间");
        title.add("时间");
        title.add("时间");
        bizSortView = new BizSortView(this, R.layout.sortview_ly, title, linearLayout);
        sortView = bizSortView.getView();


        linearLayout.addView(sortView);
        lRecyclerView = new LRecyclerView(this);
        linearLayout.addView(lRecyclerView);


//        lRecyclerView = (LRecyclerView) findViewById(R.id.recyclerview);
        simpleOper = new ClassOper();
    }

    private void initEvent() {
        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                simpleOper.doAction("ReFresh", map);//获取数据
            }
        });

        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (currentPage<= pageSize) {
                    currentPage++;
                    map.clear();
                    map.put("page", String.valueOf(currentPage) );
                    simpleOper.doAction("LoadMore", map);
                }
            }
        });

        bizSortView.setOnSortListener(new BaseSortView.OnSortListener() {
            @Override
            public void OnClickSort(View view, String s, int position) {
                map.clear();
                simpleOper.doAction(s, map);
            }
        });

    }




}

package com.hades.mylibrary.cloud.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.bean.SearchLesson;
import com.hades.mylibrary.cloud.bean.SearchLessonCenter;
import com.hades.mylibrary.cloud.bean.TypeBean;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.ui.mvp.activity.SearchActivity;
import com.hades.mylibrary.cloud.ui.views.TypeDialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hades.mylibrary.R.id.recyclerview;

public class SearchContentActivity extends NormalBaseActivity {

    LRecyclerView listView;
    List<SearchLesson> lists;
    List<TypeBean> dialogList;

    TextView titleText;
    ImageView titleImg;
    ImageView backBt;
    TextView renqiTextView;
    TextView timeBtn;
    TextView priceBtn;
    ImageView renqiImg;
    ImageView shijianImg;
    ImageView jiageImg;
    boolean flag1=true;
    boolean flag2=true;
    boolean flag3=true;

    String order_type="visit";
    String order_sort="desc";

    ImageView mSearch;
    TypeDialog typeDialog;
    private CommonAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        listView = (LRecyclerView) findViewById(recyclerview);

        titleText = (TextView) findViewById(R.id.title_text);
        titleImg = (ImageView) findViewById(R.id.title_img);
        backBt = (ImageView) findViewById(R.id.back);


        renqiTextView= (TextView) findViewById(R.id.renqi_text);
        timeBtn = (TextView) findViewById(R.id.shijian_text);
        priceBtn = (TextView) findViewById(R.id.jiage_text);

        renqiImg= (ImageView) findViewById(R.id.renqi_img);
        shijianImg= (ImageView) findViewById(R.id.shijian_img);
        jiageImg= (ImageView) findViewById(R.id.jiage_img);

        mSearch= (ImageView) findViewById(R.id.search_bt);
    }

    @Override
    protected void initData() {
        titleText.setText("测试");
        getData(ConstantSet.keyWord, "1", "visit", "asc", "tag");
    }

    @Override
    protected void initEvent() {
        titleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出Dialog
                typeDialog = new TypeDialog(SearchContentActivity.this);
                typeDialog.show();
            }
        });

        titleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchContentActivity.this.finish();
            }
        });


        renqiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1==true)
                {
                    flag1=false;
                    order_sort="asc";
                    renqiImg.setImageResource(R.mipmap.up_img);
                }
                else
                {
                    flag1=true;
                    order_sort="desc";
                    renqiImg.setImageResource(R.mipmap.down_img);
                }

                order_type="visit";
                renqiTextView.setTextColor(Color.parseColor("#333333"));
                timeBtn.setTextColor(Color.parseColor("#AEAEAE"));
                priceBtn.setTextColor(Color.parseColor("#AEAEAE"));

//                getData(ConstantSet.keyWord,"1", order_type, order_sort,ConstantSet.tag);

            }
        });


        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag2==true)
                {
                    flag2=false;
                    order_sort="asc";
                    shijianImg.setImageResource(R.mipmap.up_img);
                }
                else
                {
                    flag2=true;
                    order_sort="desc";
                    shijianImg.setImageResource(R.mipmap.down_img);
                }

                order_type="time";

                renqiTextView.setTextColor(Color.parseColor("#AEAEAE"));
                timeBtn.setTextColor(Color.parseColor("#333333"));
                priceBtn.setTextColor(Color.parseColor("#AEAEAE"));

//                getData(ConstantSet.keyWord,"1", order_type, order_sort,ConstantSet.tag);
            }
        });


        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag3==true)
                {
                    flag3=false;
                    order_sort="asc";
                    jiageImg.setImageResource(R.mipmap.up_img);
                }
                else
                {
                    flag3=true;
                    order_sort="desc";
                    jiageImg.setImageResource(R.mipmap.down_img);
                }

                order_type= "price";

                priceBtn.setTextColor(Color.parseColor("#333333"));
                renqiTextView.setTextColor(Color.parseColor("#AEAEAE"));
                timeBtn.setTextColor(Color.parseColor("#AEAEAE"));

//                getData(ConstantSet.keyWord,"1", order_type, order_sort,ConstantSet.tag);
            }
        });


        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchContentActivity.this,SearchActivity.class));

                SearchContentActivity.this.finish();
            }
        });
    }

    public void getData(final String keyword, final String page, final String order_type, final String order_sort, final String tag) {
        Call<RootDataBean<SearchLessonCenter>> s = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.searchCourse.class).getSearch(keyword, tag, page, "100", order_type, order_sort);

        s.enqueue(new Callback<RootDataBean<SearchLessonCenter>>() {
            @Override
            public void onResponse(Call<RootDataBean<SearchLessonCenter>> call, Response<RootDataBean<SearchLessonCenter>> response) {
                lists = response.body().data.getList();
                initRecycler(lists);
            }

            @Override
            public void onFailure(Call<RootDataBean<SearchLessonCenter>> call, Throwable t) {

            }
        });
    }

    private void initRecycler(List<SearchLesson> lists) {
        adapter = new CommonAdapter<SearchLesson>(SearchContentActivity.this, R.layout. , lists){

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, SearchLesson searchLesson, int position) {

            }
        };
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(mLRecyclerViewAdapter);
    }


    private void setDialogData() {

    }

}

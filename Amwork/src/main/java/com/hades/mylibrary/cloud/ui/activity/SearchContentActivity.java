package com.hades.mylibrary.cloud.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.LoadImgUtils;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.bean.SearchContentBean;
import com.hades.mylibrary.cloud.bean.TypeBean;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.ui.views.TypeDialog;
import com.socks.library.KLog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hades.mylibrary.R.id.recyclerview;


public class SearchContentActivity extends NormalBaseActivity {

    List<SearchContentBean.ListBean> lists;
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
    LRecyclerView lRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchcontent_ly);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        lRecyclerView = (LRecyclerView) findViewById(recyclerview);

        titleText = (TextView) findViewById(R.id.title_text);
        titleImg = (ImageView) findViewById(R.id.title_img);
        backBt = (ImageView) findViewById(R.id.btn_back);


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
                    renqiImg.setImageResource(R.mipmap.btn_sort_up);
                }
                else
                {
                    flag1=true;
                    order_sort="desc";
                    renqiImg.setImageResource(R.mipmap.btn_sort_down);
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
                    shijianImg.setImageResource(R.mipmap.btn_sort_up);
                }
                else
                {
                    flag2=true;
                    order_sort="desc";
                    shijianImg.setImageResource(R.mipmap.btn_sort_down);
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
                    jiageImg.setImageResource(R.mipmap.btn_sort_up);
                }
                else
                {
                    flag3=true;
                    order_sort="desc";
                    jiageImg.setImageResource(R.mipmap.btn_sort_down);
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
        Call<RootDataBean<SearchContentBean>> s = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.searchCourse.class).getSearch(keyword, tag, page, "100", order_type, order_sort);

        s.enqueue(new Callback<RootDataBean<SearchContentBean>>() {
            @Override
            public void onResponse(Call<RootDataBean<SearchContentBean>> call, Response<RootDataBean<SearchContentBean>> response) {
                if (response.body().status == 1) {
                    KLog.json(GsonUtils.getInstance().toJson(response.body().data) );
                    lists = response.body().data.getList();
                    initRecycler(lists);
                }else {
                    ToastUtils.showShortToast(SearchContentActivity.this, response.body().message);
                }
            }

            @Override
            public void onFailure(Call<RootDataBean<SearchContentBean>> call, Throwable t) {

            }
        });
    }

    ImageView img;
    TextView title_text;//title
    TextView renqi_text;
    TextView keshi_text;
    TextView price_text;

    private void initRecycler(List<SearchContentBean.ListBean> lists) {
        adapter = new CommonAdapter<SearchContentBean.ListBean>(SearchContentActivity.this, R.layout.item_recycler_sortcontent_conten, lists){

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, SearchContentBean.ListBean searchLesson, int position) {
                Log.d("TAG-Pos", "convert"+position);
                img = holder.getView(R.id.img);
                title_text = holder.getView(R.id.title_text);
                renqi_text = holder.getView(R.id.renqi_text);
                keshi_text = holder.getView(R.id.keshi_text);
                price_text = holder.getView(R.id.price_text);

                LoadImgUtils.loadBanner(mContext, searchLesson.getCourse_album(), img);
                title_text.setText(searchLesson.getCourse_name());
                renqi_text.setText(searchLesson.getNum_user());
                keshi_text.setText(searchLesson.getNum_class());
                price_text.setText(searchLesson.getPrice());
            }
        };

        GridLayoutManager manager = new GridLayoutManager(SearchContentActivity.this, 1);
        lRecyclerView.setLayoutManager(manager);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setAdapter(mLRecyclerViewAdapter);
    }


    private void setDialogData() {

    }

}

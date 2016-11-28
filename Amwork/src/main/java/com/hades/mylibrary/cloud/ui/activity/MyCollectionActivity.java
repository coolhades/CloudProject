package com.hades.mylibrary.cloud.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;

public class MyCollectionActivity extends NormalBaseActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        recyclerView = (LRecyclerView) findViewById(R.id.normal_recycler);
    }

    @Override
    protected void initData() {
//        Call<ResponseBody> getdata = RetrofitManager.getInstance().getDefaultRetrofit()
//                .create(ApiCollection.GetMyCollection.class).getCollection()

    }

    @Override
    protected void initEvent() {

    }
}

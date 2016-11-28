package com.hades.mylibrary.cloud.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.cloud.bean.MyClass;
import com.hades.mylibrary.cloud.constant.ApiCollection;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hades on 2016/11/21.
 * 通用列表
 * 根据 启动时获取到的showcode 请求不同的数据
 *
 */
public class PersonalCourseActivity extends NormalBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcourselist);
        init(savedInstanceState);

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        Call<RootDataBean<List<MyClass>>> getData = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.GetMyClass.class).getMyClass("user_id");
        getData.enqueue(new Callback<RootDataBean<List<MyClass>>>() {
            @Override
            public void onResponse(Call<RootDataBean<List<MyClass>>> call, Response<RootDataBean<List<MyClass>>> response) {

            }

            @Override
            public void onFailure(Call<RootDataBean<List<MyClass>>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initEvent() {

    }


}

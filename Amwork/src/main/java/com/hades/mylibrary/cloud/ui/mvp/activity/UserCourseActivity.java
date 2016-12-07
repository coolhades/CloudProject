package com.hades.mylibrary.cloud.ui.mvp.activity;

import android.os.Bundle;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.mvp.activity.BaseActivity;
import com.hades.mylibrary.cloud.ui.mvp.presenter.UserCoursePresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

public class UserCourseActivity extends BaseActivity<UserCoursePresenter> implements ILoadData{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcourse_ly);
    }

    @Override
    protected UserCoursePresenter onLoadPresenter() {
        return new UserCoursePresenter(this);
    }


    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onInitData(String data) {

    }
}

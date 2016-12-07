package com.automooc.bizsimpledemo;

import android.os.Bundle;

import com.hades.mylibrary.base.ui.mvp.activity.BaseActivity;
import com.hades.mylibrary.base.ui.mvp.presenter.IRootPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

public class MainActivity extends BaseActivity implements ILoadData{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected IRootPresenter onLoadPresenter() {
        return new SimplePresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    //通过Presenter加载数据
    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    //Presenter返回数据
    @Override
    public void onInitData(String data) {

    }
}

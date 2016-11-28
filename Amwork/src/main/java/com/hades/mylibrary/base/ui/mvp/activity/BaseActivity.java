package com.hades.mylibrary.base.ui.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hades.mylibrary.base.ui.mvp.interf.IRootView;
import com.hades.mylibrary.base.ui.mvp.presenter.IRootPresenter;


/**
 * Created by Hades on 16/10/8.
 */

public abstract class BaseActivity<P extends IRootPresenter> extends AppCompatActivity implements IRootView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void init(Bundle savedInstanceState){
        initView(savedInstanceState);
        mPresenter = onLoadPresenter();
        getPresenter().attachView(this);
        initData();
        initEvent();
        getPresenter().start();
    }


    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        super.onDestroy();
    }

    protected abstract P onLoadPresenter();
    protected abstract void initView(Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initEvent();
}

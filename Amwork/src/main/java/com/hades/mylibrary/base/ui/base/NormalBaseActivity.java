package com.hades.mylibrary.base.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Hades on 2016/11/21.
 */

public abstract class NormalBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void init(Bundle savedInstanceState){
        initView(savedInstanceState);
        initData();
        initEvent();
    }

    protected abstract void initView(Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initEvent();

}

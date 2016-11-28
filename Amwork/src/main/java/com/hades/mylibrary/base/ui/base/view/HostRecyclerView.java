package com.hades.mylibrary.base.ui.base.view;

import android.content.Context;
import android.view.View;




/**
* 创建时间 2016/11/10
* auther Hades
* 描述  简单封装 viewPager内部使用
**/
public abstract class HostRecyclerView {
    View mView;

    public View getView() {
        mView = View.inflate(getContext(), getLayoutId(), null);
        initView(mView);
        initData();
        initEvent();
        return mView;
    }

    protected abstract int getLayoutId();
    protected abstract Context getContext();
    protected abstract void initView(View view);
    protected abstract void initData();
    protected abstract void initEvent();
}

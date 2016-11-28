package com.hades.mylibrary.cloud.ui.mvp.view;

import com.hades.mylibrary.base.ui.mvp.interf.IRootView;

/**
* 创建时间 2016/11/15
* auther Hades
* 描述  加载数据接口
**/
public interface ILoadData extends IRootView {
    void onInitData(String data);
}

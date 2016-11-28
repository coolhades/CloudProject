package com.hades.mylibrary.cloud.ui.mvp.model;

/**
* 创建时间 2016/11/15
* auther Hades
* 描述  Presenter从model获取数据的回调
 *     传入该接口，直接返回数据给Presenter
**/
public interface CallBackMToP {
    void onSuccess(String data);
}

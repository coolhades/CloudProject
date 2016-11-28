package com.hades.mylibrary.cloud.ui.mvp.model;


import com.hades.mylibrary.base.ui.mvp.interf.IRootModel;

public class Test implements IRootModel {

    public void getData(CallBackMToP callBack) {
        // 从服务器获取数据


        //成功后回调, 回传数据 回传数据为Json
        callBack.onSuccess("success");
    }

}

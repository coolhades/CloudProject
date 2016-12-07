package com.hades.mylibrary.cloud.ui.mvp.presenter;

import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.cloud.ui.mvp.model.VPlayModel;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

/**
* 创建时间 2016/11/18
* auther Hades
* 描述
**/
public class VideoPresenter extends BasePresenter<ILoadData, VPlayModel> {

    @Override
    public void attachView(ILoadData view) {
        super.attachView(view);
    }

    @Override
    public void start() {
        //ic_startup_logo
    }

    /**
    * 创建时间 2016/11/18
    * auther Hades
    * 描述   加载数据
    **/
    public void fetchData(){
        //加载成功
        mView.onInitData("success");
    }



    @Override
    public void detachView() {
        super.detachView();
    }
}

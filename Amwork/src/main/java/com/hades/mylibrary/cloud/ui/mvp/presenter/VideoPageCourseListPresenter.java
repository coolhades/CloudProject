package com.hades.mylibrary.cloud.ui.mvp.presenter;

import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.cloud.ui.mvp.model.Test;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
* 创建时间 2016/11/18
* auther Hades
* 描述  加载视频列表，提供了一些操作控制视频播放
 *      点击列表播放相应视频
 *      自动播放下一段
**/
public class VideoPageCourseListPresenter extends BasePresenter<ILoadData, Test> {


    @Subscribe()
    public void Sos(String s){

    }


    @Override
    public void start() {

    }

    @Override
    public void attachView(ILoadData view) {
        super.attachView(view);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachView() {
        super.detachView();
        EventBus.getDefault().unregister(this);
    }
}

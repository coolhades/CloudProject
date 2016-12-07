package com.hades.mylibrary.cloud.ui.mvp.presenter;


import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.cloud.ui.mvp.model.CallBackMToP;
import com.hades.mylibrary.cloud.ui.mvp.model.BaseModel;
import com.hades.mylibrary.cloud.ui.mvp.view.ICollectionStatus;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

/**
* 创建时间 2016/11/15
* auther Hades
* 描述  View可以直接使用 model需要初始化
**/

public class CourseDetailPresenter extends BasePresenter<ILoadData, BaseModel> {

    public CourseDetailPresenter() {
       setmModel(new BaseModel());
    }

    @Override
    public void start() {
    }

    //从服务器获取数据
    public void onFetchData(){
        getModel().getData(new CallBackMToP(){
            @Override
            public void onSuccess(String data) {
                mView.onInitData(data);
            }
        });

    }

    /**
    * 创建时间 2016/11/15
    * auther Hades
    * 描述    收藏事件处理
    **/
    public void setCollect(ICollectionStatus changeCollectionStatus){
        //收藏事件

        //收藏成功 回调
        changeCollectionStatus.onCollectionStatusChanged(true);

    }
}

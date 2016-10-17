package com.hades.libamtest;

import com.hades.libam.ui.presenter.BasePresenter;

/**
 * Created by Hades on 16/10/17.
 * 依赖View的接口 而不是实现  此处MainActivity实现了testView接口
 * model负责提供数据
 */

public class testPresenter extends BasePresenter<testView,BaseModel> {

    //直接使用基类
    // mView   已绑定
    // mModel  需要初始化


    public testPresenter() {
        setmModel(new testModel());//初始化model  实际依赖的接口
    }

    @Override
    public void start() {

    }

    public void initData(){

        mModel.fetchData(new IDataCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (data != null) {
                    mView.loadData(data);
                }
            }

            @Override
            public void onFailed(String s) {

            }
        });


    }
}

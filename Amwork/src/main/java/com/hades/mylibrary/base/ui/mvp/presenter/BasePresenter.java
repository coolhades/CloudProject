package com.hades.mylibrary.base.ui.mvp.presenter;

import android.util.Log;

import com.hades.mylibrary.base.projectutils.DebugTAG;
import com.hades.mylibrary.base.ui.mvp.interf.IRootModel;
import com.hades.mylibrary.base.ui.mvp.interf.IRootView;


/**
 * Created by Hades on 16/10/8.
 * Presenter基类
 * 子类需要初始化model
 */
public abstract class BasePresenter<T extends IRootView, M extends IRootModel> implements IRootPresenter<T> {

    protected static final String TAG = "BasePresenter";
    protected T mView;
    private M mModel;

    @Override
    public void attachView(T view) {
        Log.d(DebugTAG.TAG_INFO, "attachView");
        mView = view;

    }
//
    public void setOnMViewListener(T view){
        if (view != null) {
            mView = view;
        }
    }

    @Override
    public void detachView() {
        Log.d(DebugTAG.TAG_INFO, "detachView");
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }

    protected M getModel() {
        return mModel;
    }

    protected void setmModel(M model){
        mModel = model;
    }
}

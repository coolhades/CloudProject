package com.hades.libam.ui.presenter;


import com.hades.libam.ui.interf.IRootView;

/**
 * Created by Hades on 16/10/8.
 */

public interface IRootPresenter<T extends IRootView>  {
    void attachView(T view);
    void start();
    void detachView();
}

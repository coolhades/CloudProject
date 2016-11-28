package com.hades.mylibrary.base.ui.mvp.interf;

/**
 * Created by Hades on 16/10/17.
 * model层返回数据使用的回调
 */
public interface IDataCallBack<T> {
    void onSuccess(T data);
    void onFailed(String s);

}

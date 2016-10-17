package com.hades.libamtest;

/**
 * Created by Hades on 16/10/17.
 * model层返回数据使用的回调
 */
public interface IDataCallBack<T> {
    void onSuccess(T data);
    void onFailed(String s);

}

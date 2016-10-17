package com.hades.libamtest;

/**
 * Created by Hades on 16/10/17.
 */

public class testModel implements BaseModel {

    testBean bean;
    public testModel() {
        bean = new testBean();
        bean.setName("Hello");
        bean.setPwd("Android");

    }

    @Override
    public void fetchData(IDataCallBack callBack) {
        if (callBack == null){
            return;
        }
        if (true) {
            //返回数据给Presenter
            //网络请求、缓存加载、数据库数据加载

            callBack.onSuccess(bean);
        }else {
            callBack.onFailed("失败");
        }
    }

    @Override
    public void cacheData(IDataCacheCallBack cacheCallBack) {
        cacheCallBack.onDataSavedSuccess("success");
        cacheCallBack.onDataSavedFailed("Failed");
    }

    //操作 model数据


}

package com.hades.libamtest;

import android.app.Application;

import com.hades.libam.net.HttpClientManager;

/**
 * Created by Hades on 2016/10/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        HttpClientManager.getInstance().initClient();//初始化默认client
//        HttpClientManager.getInstance().initClient(new OkHttpClient());//初始化自定义Client
//        RootRequest.mBaseUrl = ""; //初始化基准域名  两步完成网络框架初始化 可以继承RootRequest进行API编写了
//        BaseRetData<T> 封装了response格式 统一约定 status为int 返回data为Object对象，具体Javabean




    }
}

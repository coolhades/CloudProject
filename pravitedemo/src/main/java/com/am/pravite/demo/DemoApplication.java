package com.am.pravite.demo;

import android.app.Application;

import com.hades.mylibrary.base.net.HttpClientManager;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.cloud.utils.VolleyRequestManager;

/**
 * Created by Hades on 2016/12/5.
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //1、初始化操作
        KLog.init(BuildConfig.LOG_DEBUG, "Hades");
        //OkHttp
        HttpClientManager.getInstance().initClient(getApplicationContext());
        //Retrofit绑定OkHttp
        RetrofitManager.getInstance().bindHttpClient(HttpClientManager.getInstance().getmOkHttpClient());
        //Volley
        VolleyRequestManager.getInstance().initReuestQueue(getApplicationContext());
        //其他
    }
}

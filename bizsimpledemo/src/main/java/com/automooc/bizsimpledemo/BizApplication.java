package com.automooc.bizsimpledemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.hades.mylibrary.base.net.HttpClientManager;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.socks.library.KLog;

/**
 * Created by Hades on 2016/12/1.
 */

public class BizApplication extends Application {
    private static RequestQueue rq;
    public static String baseUrl = "http://clouds.ab-auto-mooc.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG, "Hades");

        HttpClientManager.getInstance().initClient(getApplicationContext());
        RetrofitManager.getInstance().bindHttpClient(HttpClientManager.getInstance().getmOkHttpClient());

        //Volley 请求队列的初始化
        rq = Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue getRq() {
        return rq;
    }

}

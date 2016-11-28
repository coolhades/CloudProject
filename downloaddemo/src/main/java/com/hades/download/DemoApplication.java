package com.hades.download;

import android.app.Application;

import com.hades.mylibrary.base.net.HttpClientManager;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.log.KLog;

/**
 * Created by Hades on 2016/11/23.
 */

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true, "Hades");
        HttpClientManager.getInstance().initClient();
        RetrofitManager.getInstance().bindHttpClient(HttpClientManager.getInstance().getmOkHttpClient());
    }
}

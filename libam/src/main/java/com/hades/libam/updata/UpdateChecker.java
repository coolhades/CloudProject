package com.hades.libam.updata;

import android.content.Context;
import android.util.Log;
/**
* 创建时间 16/10/18
* auther Hades
* 描述  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 *     <uses-permission android:name="android.permission.INTERNET" />
 *     必须先设置接口地址
 **/
public class UpdateChecker {

    public static void setBaseUrl(String url){
        Constants.UPDATE_URL = url;
    }

    public static void checkForDialog(Context context) {
        if (Constants.UPDATE_URL.isEmpty()){
            Log.e(Constants.TAG, "The Url is null");
            return;
        }
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_DIALOG, true).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }
    }


    public static void checkForNotification(Context context) {
        if (Constants.UPDATE_URL.isEmpty()){
            Log.e(Constants.TAG, "The Url is null");
            return;
        }
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_NOTIFICATION, false).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }

    }


}

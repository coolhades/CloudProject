package com.hades.mylibrary.cloud.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Hades on 2016/12/5.
 */
public class VolleyRequestManager {

    public RequestQueue getRq() {
        return rq;
    }

    private  RequestQueue rq;

    public void initReuestQueue(Context context){
        //Volley 请求队列的初始化
        rq = Volley.newRequestQueue(context);
    }



    private static class ourInstance {
        private static VolleyRequestManager instance = new VolleyRequestManager();
    }

    public static VolleyRequestManager getInstance() {
        return ourInstance.instance;
    }

    private VolleyRequestManager() {
    }


}

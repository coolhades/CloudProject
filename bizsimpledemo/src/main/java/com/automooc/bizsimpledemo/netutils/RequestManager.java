/*
package com.automooc.bizsimpledemo.netutils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.automooc.bizsimpledemo.BizApplication;
import com.automooc.bizsimpledemo.bizbase.BizActionItem;
import com.automooc.bizsimpledemo.bizroot.BizRootDataBean;
import com.hades.mylibrary.base.projectutils.GsonUtils;

import java.util.Map;

import static android.R.attr.action;
import static android.R.attr.path;

*/
/**
 * Created by Hades on 2016/12/2.
 *//*


public class RequestManager {


    public void newStringRequest(Request.Method method, String path, Response.Listener listener, Response.ErrorListener errorListener){

    }
//ErrorListener

    protected void deleteOne(BizActionItem item, final Map<String, String> map) {
        final String adress = BizApplication.baseUrl + action.getBaseUrl() + item.getOpAction();
        StringRequest sq = new StringRequest(Request.Method.POST, adress, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                BizRootDataBean data = GsonUtils.getInstance().fromJson(s, BizRootDataBean.class);
                if (data.status == 1) {
                    Log.d("TAG", data.message);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        BizApplication.getRq().add(sq);
    }
}
*/

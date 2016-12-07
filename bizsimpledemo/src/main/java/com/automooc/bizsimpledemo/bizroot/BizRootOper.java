package com.automooc.bizsimpledemo.bizroot;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.automooc.bizsimpledemo.BizApplication;
import com.automooc.bizsimpledemo.bizbase.BizActionItem;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.socks.library.KLog;

import java.util.Map;


/**
 * Created by Hades on 2016/12/1.
 * Presenter基类
 */

public abstract class BizRootOper {

    public ModelRoot model;
    public ActionRoot action;

    protected ILoadData iLoadData;

    public void setOnLoadDataLinstener(ILoadData loadData) {
        this.iLoadData = loadData;
    }

    //执行某些操作
    public void doAction(String key, Map<String, String> map) {
        if (action.getAction(key) == null) {
            Log.d("TAG", "Null");
            return;
        }
        BizActionItem item = action.getAction(key);
        Log.d("TAG", "item = " + GsonUtils.getInstance().toJson(item));
        switch (item.getOpModel()) {
            case "OP_QUERY":
                dealQuery(item, map);
                break;
            case "OP_SINGLE":
                deleteOne(item, map);
                break;
            case "OP_RELOAD":
                dealRefresh(item, map);
                break;
            case "OP_LOADMORE":
                dealQuery(item, map);
                break;
            case "OP_SORT":
                dealSort(item, map);
                break;
        }
    }

    protected  void dealRefresh(BizActionItem item, final Map<String, String> map){
        final String adress = BizApplication.baseUrl + action.getBaseUrl() + item.getOpAction();

        StringRequest sq = new StringRequest(Request.Method.POST, adress, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                BizRootDataBean data = GsonUtils.getInstance().fromJson(s, BizRootDataBean.class);
                if (data.status == 1) {
                    //success
                    KLog.json(s);
                    dealReload(GsonUtils.getInstance().toJson(data.data));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        BizApplication.getRq().add(sq);
    }

///**
//* 创建时间 2016/12/5
//* auther Hades
//* 描述  key:排序title
//**/
//    public void doSort(String key, Map<String, String> map){
//        if (action.getCondition(key) == null) return;
//        BizConditionItem item = action.getCondition(key);
//        dealSort(item, map);
//    }

    protected void dealSort(final BizActionItem item, final Map<String, String> map){
        final String adress = BizApplication.baseUrl + action.getBaseUrl() + item.getOpAction()+"?order="+item.getOpFlag()+item.getOpSort();
        if (item.getOpFlag().equalsIgnoreCase("-")){
            item.setOpFlag("+");
        }else {
            item.setOpFlag("-");
        }
        StringRequest sq = new StringRequest(Request.Method.POST, adress, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("TAG-Data", s);
                BizRootDataBean data = GsonUtils.getInstance().fromJson(s, BizRootDataBean.class);
                if (data.status == 1) {
                    //success
                    KLog.json(s);
                    dealReSort(GsonUtils.getInstance().toJson(data.data));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        BizApplication.getRq().add(sq);
    }




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

    private void dealQuery(BizActionItem item, final Map<String, String> map) {
        final String adress = BizApplication.baseUrl + action.getBaseUrl() + item.getOpAction();

        StringRequest sq = new StringRequest(Request.Method.POST, adress, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                BizRootDataBean data = GsonUtils.getInstance().fromJson(s, BizRootDataBean.class);
                if (data.status == 1) {
                    //success
                    KLog.json(s);
                    if (map.isEmpty()){
                        loadData(GsonUtils.getInstance().toJson(data.data));
                    }else {
                        dealNext(GsonUtils.getInstance().toJson(data.data));
                    }
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


    protected abstract void loadData(String alldata);
    protected abstract void dealReSort(String s);
    protected abstract void dealReload(String s);
    protected abstract void dealNext(String s);


}

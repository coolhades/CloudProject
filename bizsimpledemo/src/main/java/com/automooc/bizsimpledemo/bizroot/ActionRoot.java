package com.automooc.bizsimpledemo.bizroot;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.automooc.bizsimpledemo.bizbase.BizActionItem;
import com.automooc.bizsimpledemo.bizbase.BizConditionItem;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.socks.library.KLog;

import java.util.Map;

/**
 * Created by Hades on 2016/12/1.
 */

public class ActionRoot {
    protected String baseUrl;
    private Map<String, BizActionItem>  actionItemMap = new ArrayMap<>();

    public void addAction(String key, BizActionItem bizActionItem){
        actionItemMap.put(key, bizActionItem);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public BizActionItem getAction(String key) {
        Log.d("TAG", GsonUtils.getInstance().toJson(actionItemMap));

        if (actionItemMap.containsKey(key)){
            return actionItemMap.get(key);
        }
        return null;
    }

    //key title, value
    private Map<String, BizConditionItem>  conditionItemMap = new ArrayMap<>();
    public void addCondition(String key, BizConditionItem bizConditionItem){
        conditionItemMap.put(key, bizConditionItem);
        Log.d("TAG", "condition "+ conditionItemMap.size());
    }

    public BizConditionItem getCondition(String key){
        KLog.json(GsonUtils.getInstance().toJson(conditionItemMap));
        if (conditionItemMap.containsKey(key)){
            return conditionItemMap.get(key);
        }
        return null;
    }

}

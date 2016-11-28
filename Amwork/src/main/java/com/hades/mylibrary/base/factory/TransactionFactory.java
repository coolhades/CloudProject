package com.hades.mylibrary.base.factory;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Hades on 2016/11/3.
 * 根据布局创建view
 */

public class TransactionFactory {

    Map<String, String> map;

    public static TransactionFactory getInstance(){
        return SignalInstance.instance;
    }
    private TransactionFactory() {
        map = new HashMap<>();

    }

    private static class SignalInstance{
        private static TransactionFactory instance = new TransactionFactory();
    }

    public TransactionFactory registTransactionCode(String trancode, String target){
        map.put(trancode, target);
        return this;
    }

    public String setTargetName(String code){
        if (map.containsKey(code)) {
            Log.d("TAG-Target", map.get(code));
            return map.get(code);
        }else return "Not Found";

    }

}

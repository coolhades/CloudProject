package com.hades.mylibrary.base.ui.base.transaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hades.mylibrary.base.factory.TransactionFactory;
import com.hades.mylibrary.base.ui.base.pojo.CodeInfoBean;

/**
 * Created by Hades on 2016/11/3.
 * Recyclerview中的adapter，data 绑定 view
 */
public class HandleTransaction {

    private static HandleTransaction ourInstance = new HandleTransaction();

    public static HandleTransaction getInstance() {
        return ourInstance;
    }

    private HandleTransaction() {
    }

    /**
    * @TransactionBean 封装了事件的code
     * @TransactionFactory 根据code设置跳转目标
     * 注意manifest中设置的action是否正确
    **/
    public void handleTransaction(CodeInfoBean codeInfoBean, Context context, Bundle bundle) {

//        String s = TransactionFactory.getInstance().setTargetName(transactionBean.getActioncode());
        String s = TransactionFactory.getInstance().setTargetName(codeInfoBean.getPushCode());
        Log.d("TAG-RootView", "事件处理="+s);
        Intent intent = new Intent();
        intent.setAction(s);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}

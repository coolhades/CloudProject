package com.hades.mylibrary.base.data;

import android.content.Context;

import com.litesuits.orm.LiteOrm;

/**
 * Created by Hades on 2016/11/25.
 * 全局单例，因此在切换平台时需要释放数据库调用releaseReference()
 * 退出登录，删除对应表或数据库
 */
public class DbController {

    public static LiteOrm liteOrm;

    //首先初始化
    public static void initDB(Context context, String dbname){
        if (liteOrm == null){
            liteOrm = LiteOrm.newSingleInstance(context, dbname);
            liteOrm.setDebugged(true);
        }
    }

}

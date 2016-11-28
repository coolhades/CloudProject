package com.hades.mylibrary.base.data;

import android.content.Context;


/**
 * Created by Hades on 2016/11/25.
 */

public class CacheController {

    private CacheController() {

    }

    private static class Instance {
        private static CacheController instance = new CacheController();
    }

    public static CacheController getInstance(){
        return Instance.instance;
    }

    public ACache cache;

    /**
    * 创建时间 2016/11/25
    * auther Hades
    * 描述 选定平台后初始化缓存框架
     *      切换平台需要切换缓存文件
    **/
    public ACache initCache(Context context,String key){
        cache = ACache.get(context, key);
        return cache;
    }

}

package com.hades.mylibrary.base.projectutils;

import java.util.Map;


/**
 * Created by Hades on 2016/11/22.
 */
public class ConfigManager<T> {

    public static ConfigManager getInstance() {
        return Instance.instance;
    }

    private static class Instance{
        private static ConfigManager instance = new ConfigManager();
    }

    private ConfigManager() {
    }

    public T getContain(String key, Map<String, T> map){
        if (map.containsKey(key) ) return map.get(key);
        return null;
    }


}

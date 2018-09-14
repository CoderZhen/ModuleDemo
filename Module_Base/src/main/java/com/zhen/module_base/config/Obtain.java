package com.zhen.module_base.config;

import android.content.Context;

public class Obtain {

    public static void init(Context context) {
        Configs.getHashMap().put(ConfigKey.APP, context.getApplicationContext());
    }

    private static Configs getConfigs(){
        return Configs.getInstance();
    }

    public static Context getApplicationContext(){
        return getConfig(ConfigKey.APP);
    }

    public static <T> T getConfig(String key){
        return getConfigs().getConfig(key);
    }
}

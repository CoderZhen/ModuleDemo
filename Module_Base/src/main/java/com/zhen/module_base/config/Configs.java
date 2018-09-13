package com.zhen.module_base.config;

import java.util.HashMap;
import java.util.Map;

public class Configs {

    public static final class Holder {
        private static final Configs INSTANCE = new Configs();
    }

    public static Configs getInstance() {
        return Holder.INSTANCE;
    }

    private static final Map<String, Object> HASH_MAP = new HashMap<>();

    public static Map<String, Object> getHashMap() {
        return HASH_MAP;
    }


    public <T> T getConfig(String key) {
        Object value = getHashMap().get(key);
        if (value == null) {
            throw new NullPointerException("value == null");
        } else {
            return (T) value;
        }
    }

}

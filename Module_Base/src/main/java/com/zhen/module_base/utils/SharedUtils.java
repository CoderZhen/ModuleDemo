package com.zhen.module_base.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zhen.module_base.config.ConfigKey;
import com.zhen.module_base.config.Obtain;

public class SharedUtils {

    private static final SharedPreferences SP =
            PreferenceManager.getDefaultSharedPreferences(Obtain.getApplicationContext());

    private static final class Holder {
        private static final SharedUtils INSTANCE = new SharedUtils();

    }

    public static SharedUtils getInstance() {
        return Holder.INSTANCE;
    }

    public void setLoginStatus(boolean value) {
        SP.edit().putBoolean(SharedKey.Login, value).apply();
    }

    public boolean getLoginStatus() {
        return SP.getBoolean(SharedKey.Login, false);
    }

}

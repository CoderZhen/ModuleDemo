package com.zhen.module_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhen.module_base.config.Obtain;

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Obtain.init(this);

        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}

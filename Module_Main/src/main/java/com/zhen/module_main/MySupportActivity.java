package com.zhen.module_main;

import com.zhen.module_base.base.BaseDelegate;
import com.zhen.module_base.base.ProxyActivity;
import com.zhen.module_base.splash.SplashDelegate;

public class MySupportActivity extends ProxyActivity{

    @Override
    protected BaseDelegate setRootDelegate() {
        return new SplashDelegate();
    }
}

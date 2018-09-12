package com.zhen.module_home;

import com.zhen.module_base.base.BaseDelegate;
import com.zhen.module_base.base.ProxyActivity;

public class DebugActivity extends ProxyActivity {

    @Override
    protected BaseDelegate setRootDelegate() {
        return new HomeDelegate();
    }
}

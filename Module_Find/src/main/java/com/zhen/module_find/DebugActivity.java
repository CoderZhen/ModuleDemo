package com.zhen.module_find;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhen.module_base.base.BaseDelegate;
import com.zhen.module_base.base.ProxyActivity;

public class DebugActivity extends ProxyActivity {

    @Override
    protected BaseDelegate setRootDelegate() {
        return new FindDelegate();
    }
}

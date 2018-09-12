package com.zhen.module_base.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhen.module_base.R;
import com.zhen.module_base.base.Delegate;

public class SplashDelegate extends Delegate {

    @Override
    protected Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void onEvent() {

    }
}

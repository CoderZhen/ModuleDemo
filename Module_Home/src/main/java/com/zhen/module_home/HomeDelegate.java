package com.zhen.module_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhen.module_base.bottom.BottomItemDelegate;

public class HomeDelegate extends BottomItemDelegate {

    @Override
    protected Object setLayout() {
        return R.layout.delegate_home;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void onEvent() {

    }
}

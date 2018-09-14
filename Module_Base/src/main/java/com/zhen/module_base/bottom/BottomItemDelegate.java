package com.zhen.module_base.bottom;

import android.widget.Toast;

import com.zhen.module_base.R;
import com.zhen.module_base.base.Delegate;

public abstract class BottomItemDelegate extends Delegate {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            getActivity().finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(getContext(), "双击退出" + getString(R.string.home_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

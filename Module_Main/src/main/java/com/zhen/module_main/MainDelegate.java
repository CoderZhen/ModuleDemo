package com.zhen.module_main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.module_base.bean.BottomTabBean;
import com.zhen.module_base.bottom.BottomItemDelegate;
import com.zhen.module_base.bottom.BottomMainDelegate;
import com.zhen.module_base.utils.RouterUtils;
import com.zhen.module_find.FindDelegate;
import com.zhen.module_home.HomeDelegate;
import com.zhen.module_user.UserDelegate;

import java.util.LinkedHashMap;

@Route(path = RouterUtils.MAIN)
public class MainDelegate extends BottomMainDelegate {

    @Override
    protected LinkedHashMap<BottomTabBean, BottomItemDelegate> setItem() {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEM = new LinkedHashMap<>();
        ITEM.put(new BottomTabBean("首页", "Index"), new HomeDelegate());
        ITEM.put(new BottomTabBean("发现", "Find"), new FindDelegate());
        ITEM.put(new BottomTabBean("我", "Me"), new UserDelegate());
        return ITEM;
    }

    @Override
    protected int setClickedTitleColor() {
        return 0;
    }

    @Override
    protected int setClickedItemColor() {
        return 0;
    }

    @Override
    protected int setCurrentDelegate() {
        return 0;
    }

}

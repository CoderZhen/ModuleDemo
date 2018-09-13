package com.zhen.module_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.module_base.base.Delegate;
import com.zhen.module_base.utils.RouterUtils;
import com.zhen.module_find.FindDelegate;
import com.zhen.module_home.HomeDelegate;
import com.zhen.module_main.adapter.MainAdapter;
import com.zhen.module_user.UserDelegate;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportHelper;

@Route(path = RouterUtils.MAIN)
public class MainDelegate extends Delegate {

    private ViewPager vp_main;
    private TabLayout tl_main;
    private String[] names = {"首页\nIndex", "发现\nFind", "我\nMe"};

    @Override
    protected Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        vp_main = rootView.findViewById(R.id.vp_main);
        tl_main = rootView.findViewById(R.id.tl_main);
    }

    @Override
    protected void onEvent() {
        //发射粘性事件
        EventBus.getDefault().postSticky(SupportHelper.findFragment(getFragmentManager(), MainDelegate.class));

        List<Fragment> list = new ArrayList<>();
        list.add(new HomeDelegate());
        list.add(new FindDelegate());
        list.add(new UserDelegate());
        vp_main.setAdapter(new MainAdapter(getFragmentManager(), list, names));
        tl_main.setupWithViewPager(vp_main);
    }
}

package com.zhen.module_user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import com.zhen.module_base.base.Delegate;
import com.zhen.module_base.bottom.BottomItemDelegate;
import com.zhen.module_base.utils.RouterUtils;
import com.zhen.module_base.utils.SharedUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDelegate extends BottomItemDelegate implements View.OnClickListener {
    private static final String TAG = "UserDelegate-vv";

    private CircleImageView img_head;
    private AppCompatTextView tv_username;
    private AppCompatButton btn_logout;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_user;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        img_head = rootView.findViewById(R.id.img_head);
        tv_username = rootView.findViewById(R.id.tv_user_name);
        btn_logout = rootView.findViewById(R.id.btn_logout);
    }

    @Override
    protected void onEvent() {
        btn_logout.setOnClickListener(this);
        img_head.setImageResource(R.mipmap.ic_launcher);
        tv_username.setText("APP");
    }

    @Override
    public void onClick(View v) {
        //退出登录
        if (v.getId() == R.id.btn_logout) {
            SharedUtils.getInstance().setLoginStatus(false);
            getParentDelegate().startWithPop(RouterUtils.getLoginDelegate());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

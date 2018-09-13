package com.zhen.module_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.module_base.base.Delegate;
import com.zhen.module_base.utils.RouterUtils;
import com.zhen.module_base.utils.SharedUtils;

@Route(path = RouterUtils.LOGIN)
public class LoginDelegate extends Delegate implements View.OnClickListener {

    private AppCompatButton btn_login;
    private TextInputLayout til_account, til_password;
    private AppCompatEditText et_account, et_password;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_login;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        btn_login = rootView.findViewById(R.id.btn_login);
        et_account = rootView.findViewById(R.id.et_account);
        et_password = rootView.findViewById(R.id.et_password);
        til_account = rootView.findViewById(R.id.til_account);
        til_password = rootView.findViewById(R.id.til_password);
    }

    @Override
    protected void onEvent() {
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            String account = et_account.getText().toString();
            String password = et_password.getText().toString();

            til_account.setErrorEnabled(false);
            til_password.setErrorEnabled(false);

            if (checkAccount(account) && checkPassWord(password)) {
                Toast.makeText(_mActivity, "登录成功", Toast.LENGTH_SHORT).show();
                SharedUtils.getInstance().setLoginStatus(true);
                startWithPop(RouterUtils.getMainDelegate());
            }

        }
    }

    private void showError(TextInputLayout til, String error) {
        til.setError(error);
        til.getEditText().setFocusable(true);
        til.getEditText().setFocusableInTouchMode(true);
        til.getEditText().requestFocus();
    }

    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            showError(til_account, "账号不能为空");
            return false;
        }
        return true;
    }

    private boolean checkPassWord(String password) {
        if (TextUtils.isEmpty(password)) {
            showError(til_password, "密码不能为空");
            return false;
        } else if (password.length() < 6 | password.length() > 18) {
            showError(til_password, "密码长度6~18");
            return false;
        }
        return true;
    }
}

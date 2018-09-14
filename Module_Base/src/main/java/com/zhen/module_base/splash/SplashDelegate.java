package com.zhen.module_base.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhen.module_base.R;
import com.zhen.module_base.base.Delegate;
import com.zhen.module_base.config.Obtain;
import com.zhen.module_base.utils.RouterUtils;
import com.zhen.module_base.utils.SharedUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SplashDelegate extends Delegate implements View.OnClickListener {
    private static final String TAG = "SplashDelegate-vv";

    private CompositeDisposable mDisposable = new CompositeDisposable();

    private AppCompatButton btn_jump;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        btn_jump = rootView.findViewById(R.id.btn_jump);
    }

    @Override
    protected void onEvent() {
        CountDown();
        btn_jump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_jump) {
            CheckLogin();
            mDisposable.clear();
        }
    }

    private void CountDown() {
        final int time = 5;
        Observable.intervalRange(0, 6, 800, 1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time - aLong;
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(Long aLong) {
                btn_jump.setText(aLong + "秒");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                CheckLogin();
            }
        });
    }

    private void CheckLogin() {
        if (SharedUtils.getInstance().getLoginStatus()) {
            getSupportDelegate().startWithPop(RouterUtils.getMainDelegate());
        } else {
            getSupportDelegate().startWithPop(RouterUtils.getLoginDelegate());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
        mDisposable = null;
    }
}

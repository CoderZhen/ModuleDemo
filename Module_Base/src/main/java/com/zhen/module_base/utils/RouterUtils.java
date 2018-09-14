package com.zhen.module_base.utils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhen.module_base.base.BaseDelegate;

public class RouterUtils {

    public static final String LOGIN = "/user/login";

    public static final String MAIN = "/main/main";

    public static BaseDelegate getMainDelegate(){
        return (BaseDelegate) ARouter.getInstance().build(MAIN).navigation();
    }

    public static BaseDelegate getLoginDelegate(){
        return (BaseDelegate) ARouter.getInstance().build(LOGIN).navigation();
    }

}

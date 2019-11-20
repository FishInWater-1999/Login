package com.fishinwater.loginmodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author fishinwater-1999
 * @version 2019-11-19
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}

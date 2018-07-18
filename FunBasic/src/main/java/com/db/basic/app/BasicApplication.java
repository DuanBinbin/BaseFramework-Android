package com.db.basic.app;

import android.app.Application;

import com.db.basic.BuildConfig;

/**
 * @描述：     @Application 基类
 * @作者：     @Bin
 * @创建时间： @2018/7/18 19:55
 */
public abstract class BasicApplication extends Application {

    private static BasicApplication sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        initComplete();
    }

    public static BasicApplication getAppContext(){
        return sContext;
    }

    private void init(){
        if (BuildConfig.DEBUG){

        }
    }

    public abstract void initComplete();
}

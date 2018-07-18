package com.db.basic.debug;

import android.app.Application;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;

/**
 * @描述：     @Debug管理器
 * @作者：     @Bin
 * @创建时间： @2018/7/18 20:00
 */
public final class DebugManager {

    /**
     * 初始化
     * @param application
     */
    public static void initialize(Application application){
//        initLeakCanary(application);
//        initStrictMode();
    }

    /**
     * 初始化内存检查
     * @param application
     */
    public static void initLeakCanary(Application application){
        if (LeakCanary.isInAnalyzerProcess(application)){
            return;
        }
        LeakCanary.install(application);
    }

    private static void initStrictMode(){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}

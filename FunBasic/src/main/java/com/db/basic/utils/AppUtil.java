package com.db.basic.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.db.basic.app.BasicApplication;

/**
 * @描述：     @Application相关工具
 * @作者：     @Bin
 * @创建时间： @2018/11/12 10:27
 */
public final class AppUtil {

    /**
     * 获取Application Context
     * @return app context
     */
    public static Context getContect(){
        return BasicApplication.getAppContext();
    }

    /**
     * 打开APP
     * @param context
     * @param appName
     * @param packageName
     */
    public static void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断APP是否安装
     * @param context
     * @param packageName
     * @return
     */
    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return false;
    }

    /**
     * 判断APP是否激活
     * @param context
     * @param packageName
     * @return
     */
    private static boolean isAppEnabled(Context context, String packageName) {
        boolean appStatus = false;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(packageName, 0);
            if (ai != null) {
                appStatus = ai.enabled;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appStatus;
    }
}

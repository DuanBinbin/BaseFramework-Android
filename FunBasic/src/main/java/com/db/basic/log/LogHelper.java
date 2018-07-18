package com.db.basic.log;

import android.util.Log;

import com.db.basic.BuildConfig;

/**
 * @描述：     @Log工具类
 * @作者：     @Bin
 * @创建时间： @2018/7/18 20:14
 */
public final class LogHelper {
    public final static void i(String tag,String arg){
        if(BuildConfig.DEBUG){
            Log.v(tag,arg);
        }
    }

    public final static void d(String tag,String arg){
        if(BuildConfig.DEBUG){
            Log.d(tag,arg);
        }
    }

    public final static void v(String tag,String arg){
        if(BuildConfig.DEBUG){
            Log.v(tag,arg);
        }
    }

    public final static void e(String tag,String arg){
        if(BuildConfig.DEBUG){
            Log.e(tag,arg);
        }
    }

    public final static void e(String tag,String arg,Throwable e){
        if(BuildConfig.DEBUG){
            Log.e(tag,arg,e);
        }
    }

    public final static void w(String tag,String arg){
        if(BuildConfig.DEBUG){
            Log.w(tag,arg);
        }
    }

    public final static void s(String message){
        if(BuildConfig.DEBUG){
            System.out.println(message);
        }
    }

}

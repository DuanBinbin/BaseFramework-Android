package com.db.basic.singleton;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * @作者：     @Bin
 * @创建时间： @2018/7/18 16:44
 * @调用方法   @EasySingleton.INSTANCE
 * @说明：     @出自《Effective Java》第二版第三条: 用私有构造器或枚举类型强化Singleton属性。
 * @参考网址： @https://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java
 * @好处：    @ 1.利用枚举的特性实现单例；2.有JVM保证线程安全；3.序列化和反射攻击已被枚举解决
 */
public enum EasySingleton {
    INSTANCE;
    public void whateverMethod(){
        Log.d(TAG, "whateverMethod() called");
    }
}

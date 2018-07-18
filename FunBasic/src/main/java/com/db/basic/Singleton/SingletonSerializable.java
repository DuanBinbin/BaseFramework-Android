package com.db.basic.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @描述：     @饿汉式
 * @作者：     @Bin
 * @创建时间： @2018/7/18 16:50
 */
public class SingletonSerializable implements Serializable {
    private static SingletonSerializable INSTACE = new SingletonSerializable();

    // 私有化构造函数
    private SingletonSerializable(){

    }

    public static SingletonSerializable getInstance(){
        return INSTACE;
    }

    /**
     * 如果实现了Serializable,必须重写这个方法
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolver() throws ObjectStreamException{
        return INSTACE;
    }
}

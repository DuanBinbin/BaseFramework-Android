package com.db.basic.Singleton;

/**
 * @描述：     @
 * @作者：     @Bin
 * @创建时间： @2018/7/18 17:09
 */
public class Singleton {
    private static Singleton INSTANCE;
//    private volatile static Singleton INSTANCE; // 声明成volatile

    private Singleton(){

    }

    /**
     * 懒汉式，线程不安全
     *
     * 优点：使用了懒加载模式
     * 缺点：当多个线程并行调用getInstance()的时候，就会创建过个实例，也就是说多线程下不能正常工作
     * @return
     */
/*    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    /**
     * 懒汉式，线程安全
     *
     * synchronized将 getInstance() 方法设为同步
     * 优点：懒汉式、线程安全，解决多个实例
     * 缺点：不高效，因为在任何时候只能有一个线程调用 getInstance() 方法，
     *      但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时
     * @return
     */
/*    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    /**
     * 双重检验锁模式
     */
//    private static Singleton getInstance(){
//        if (null == INSTANCE){                      // 第一次检查,同步块外
//            synchronized (Singleton.class){         //
//                if (null == INSTANCE){
//                    INSTANCE = new Singleton();     // 第二次检查，同步块内
//                }
//            }
//
//        }
//        return INSTANCE;
//    }

    /**
     * 静态内部类
     */
/*    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }*/
}

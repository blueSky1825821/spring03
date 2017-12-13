package com.design.pattern.singleton;

/**
 * Created by wm on 17-8-13.
 */
public class DoubleSingleton {
    //volatile 对被修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确处理该变量
    private volatile static DoubleSingleton instance = null;

    private DoubleSingleton() {
    }

    public static DoubleSingleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (DoubleSingleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建
                if (instance == null) {
                    instance = new DoubleSingleton();
                }
            }
        }
        return instance;
    }
}

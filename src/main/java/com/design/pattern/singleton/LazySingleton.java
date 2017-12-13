package com.design.pattern.singleton;

/**
 * Created by wm on 17-8-13.
 * 懒汉单例
 */
public class LazySingleton {
    //4、定义一个变量来存储创建好的类实例
    //5、因为这个变量要在静态方法中使用，所以加上static修饰
    private static LazySingleton instance = null;

    //1、私有化构造方法，好在内部控制创建实例的数目
    private LazySingleton() {
    }
    //2、定义一个方法来为客户端提供类实例
    //3、这个方法需要定义成类方法，也就是要加上static
    public static LazySingleton getInstance() {
        //判断存储实例的变量是否有值(多线程时可能会创建多个对象，线程不安全)
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

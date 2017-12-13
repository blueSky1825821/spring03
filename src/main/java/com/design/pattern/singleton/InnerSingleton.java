package com.design.pattern.singleton;

/**
 * Created by wm on 17-8-13.
 */
public class InnerSingleton {
    /**
     * 类级内部类，也就是静态的成员式内部类，
     * 该内部类的实例与外部类的实例没有绑定关系，
     * 而且只有被调用到时才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
    /**
     * 静态初始化器，由JVM来保证线程安全
     */
        private static InnerSingleton instance = new InnerSingleton();
    }

    /**
     * 私有化构方法
     */
    private InnerSingleton() {
    }

    public static InnerSingleton getInstance() {
        return SingletonHolder.instance;
    }

}

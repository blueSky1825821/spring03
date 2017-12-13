package com.design.pattern.singleton;

/**
 * Created by wm on 17-8-13.
 */
public class HungerSingleton {
    //4、定义一个静态变量来存储创建好的类实例
    private static HungerSingleton instance = new HungerSingleton();

    //1、私有化构造方法，可以在内部控制创建实例的数目
    private HungerSingleton() {
    }

    //2、定义一个方法来为客户端提供类实例
    //3、这个方法需要定义成类方法，也就是加上static
    public static HungerSingleton getInstance() {
        //5、直接使用已经创建好的实例
        return instance;
    }
}

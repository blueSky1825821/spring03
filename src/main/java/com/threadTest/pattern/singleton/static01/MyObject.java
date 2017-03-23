package com.threadTest.pattern.singleton.static01;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject {
    private static MyObject instance = null;
    private MyObject() {}
    //静态代码块中的代码在使用类的时候已经执行了
    static {
        instance = new MyObject();
    }
    public static MyObject getInstance() {
        return instance;
    }
}

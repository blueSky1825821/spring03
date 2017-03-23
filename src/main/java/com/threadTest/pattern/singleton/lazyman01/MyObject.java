package com.threadTest.pattern.singleton.lazyman01;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject {
    private static MyObject myObject;

    private MyObject() {
    }

    public static MyObject getInstance() {
        //延迟加载
        if (null != myObject) {
        } else {
            myObject = new MyObject();
        }
        return myObject;
    }
}

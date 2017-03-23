package com.threadTest.pattern.singleton.test01;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject {
    //内部类方式
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }
    private MyObject(){}
    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }
}

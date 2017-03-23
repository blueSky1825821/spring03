package com.threadTest.pattern.singleton.lazyman03;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject {
    private static MyObject myObject;

    private MyObject() {
    }

    //效率低下
    synchronized public static MyObject getInstance() {
        //延迟加载
        if (null != myObject) {
        } else {
            try {
                //模拟在创建对象之前做一些准备性工作 导致阻塞
                Thread.sleep(3000);
                myObject = new MyObject();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return myObject;
    }
}

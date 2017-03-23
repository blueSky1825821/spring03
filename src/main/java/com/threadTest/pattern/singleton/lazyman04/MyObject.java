package com.threadTest.pattern.singleton.lazyman04;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject {
    private static MyObject myObject;

    private MyObject() {
    }

    //效率低下
    public static MyObject getInstance() {
        try {
            //延迟加载 等同于synchronized public static MyObject getInstance()
            synchronized (MyObject.class) {
                if (null != myObject) {
                } else {
                    //模拟在创建对象之前做一些准备性工作 导致阻塞
                    Thread.sleep(3000);
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

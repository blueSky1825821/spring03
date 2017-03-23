package com.threadTest.pattern.singleton.lazyman05;

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
            //使用双检测机制来解决， 既保证了不需要同步代码的异步执行性，又保证了单例的效果
            if (null != myObject) {
            } else {
                //模拟在创建对象之前做一些准备性工作 导致阻塞
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (null == myObject) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

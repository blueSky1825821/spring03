package com.threadTest.pattern.singleton.static01;

/**
 * Created by sky on 2017/3/22.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}

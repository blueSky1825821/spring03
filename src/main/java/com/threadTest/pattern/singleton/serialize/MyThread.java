package com.threadTest.pattern.singleton.serialize;

/**
 * Created by sky on 2017/3/22.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
package com.ThreadTest.test04;

/**
 * Created by sky on 2017/3/9.
 */
public class Test3 {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread1 t1 = new MyThread1(lock);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread2 t2 = new MyThread2(lock);
        t2.start();
    }
}
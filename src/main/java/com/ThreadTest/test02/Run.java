package com.ThreadTest.test02;

/**
 * Created by sky on 2017/3/8.
 */
public class Run {
    public static void main(String[] args) {
        DealThread t1 = new DealThread();
        t1.setFlag("a");
        Thread thread1 = new Thread(t1);
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setFlag("b");
        Thread thread2 = new Thread();
        thread2.start();
    }
}

package com.threadTest.thread.test11;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA[] a1 = new MyThreadA[10];
        MyThreadB[] b1 = new MyThreadB[10];
        for (int i = 0; i < 10; i++) {
            a1[i] = new MyThreadA(myService);
            b1[i] = new MyThreadB(myService);
            a1[i].start();
            b1[i].start();
        }
    }
}

package com.threadTest.thread.test09;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA a1 = new MyThreadA(myService);

        a1.start();
        Thread.sleep(3000);
        myService.signal();
    }
}

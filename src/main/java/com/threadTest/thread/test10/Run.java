package com.threadTest.thread.test10;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA a1 = new MyThreadA(myService);
        a1.setName("A");
        a1.start();
        MyThreadB b1 = new MyThreadB(myService);
        b1.setName("B");
        b1.start();
        Thread.sleep(3000);
        myService.signalAll_A();
    }
}

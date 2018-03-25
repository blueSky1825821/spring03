package com.test.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wm on 18-3-18.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();//减1
        }).start();
        c.await();//阻塞当前线程，直到变为0
        System.out.println(3);
    }
}

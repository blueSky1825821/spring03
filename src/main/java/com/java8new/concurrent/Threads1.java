package com.java8new.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by wm on 17-8-22.
 */
public class Threads1 {
    private static void test1() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void test2() {
        Runnable runnable = () -> {
            try {
                System.out.println("Foo " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}

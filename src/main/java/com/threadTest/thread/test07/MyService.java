package com.threadTest.thread.test07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sky on 2017/3/21.
 * ReentrantLock
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public void testMethod() {
        //获取锁
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName " + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        //解锁
        lock.unlock();
    }
}

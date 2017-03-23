package com.threadTest.thread.test12;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sky on 2017/3/21.
 * 读锁允许多个线程同时执行lock后的代码
 */
public class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁 " + Thread.currentThread().getName() +
                    " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

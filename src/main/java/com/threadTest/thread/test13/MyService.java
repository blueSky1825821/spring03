package com.threadTest.thread.test13;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sky on 2017/3/21.
 * 写锁同一个时间只允许一个线程执行lock()方法后的代码
 */
public class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁 " + Thread.currentThread().getName() +
                    " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

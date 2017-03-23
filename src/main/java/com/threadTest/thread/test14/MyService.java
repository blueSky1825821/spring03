package com.threadTest.thread.test14;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sky on 2017/3/21.
 * 读写互斥
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

package com.threadTest.thread.test11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sky on 2017/3/21.
 * 唤醒制定种类的线程
 */
public class  MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    //进程等待
    public void set() {
        try {
            lock.lock();
            while (true == hasValue) {
                System.out.println("有可能。。。。。。连续");
                condition.await();
            }
            System.out.println("打印。。。");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (true == hasValue) {
                System.out.println("有可能......连续");
                condition.await();
            }
            System.out.println("打印...");
            hasValue = false;
            condition.signalAll();
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll() {
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为 " + System.currentTimeMillis());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

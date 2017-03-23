package com.threadTest.thread.test09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sky on 2017/3/21.
 * 1、一个Lock里面可以创建多个Condition实例，实现多路通知
 * 2、notify()方法进行通知时，被通知的线程时Java虚拟机随机选择的，但是ReentrantLock结合Condition可以实现有选择性地通知，这是非常重要的
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进程等待
    public void await() {
        try {
            lock.lock();
            System.out.println("await 时间为 " + System.currentTimeMillis());
            condition.await ();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //唤醒等待的进程
    public void signal() {
        try {
            lock.lock();
            System.out.println("signal 时间为 " + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

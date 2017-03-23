package com.threadTest.thread.test08;

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

    public void await() {
        try {
            lock.lock();
            System.out.println("A");
            condition.await ();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("锁释放了！");
        }

    }
}

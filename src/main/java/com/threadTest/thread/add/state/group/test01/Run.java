package com.threadTest.thread.add.state.group.test01;

/**
 * Created by sky on 2017/3/23.
 */
public class Run {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadGroup group = new ThreadGroup("线程组");
        Thread athread = new Thread(group, threadA);
        Thread bthread = new Thread(group, threadB);
        athread.start();
        bthread.start();
        System.out.println("interrupt前活动的线程组： " + group.activeCount());
        System.out.println("线程组的名称为： " + group.getName());
        //线程中断
        group.interrupt();
        System.out.println("interrupt后活动的线程组： " + group.activeCount());
        group.list();
    }
}

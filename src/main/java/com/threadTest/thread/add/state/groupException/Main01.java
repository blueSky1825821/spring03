package com.threadTest.thread.add.state.groupException;

/**
 * Created by sky on 2017/3/24.
 */
public class Main01 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("我的线程组");
        MyThread newT = new MyThread(group, "报错线程", "a");
        newT.start();
//        MyThread[] myThread = new MyThread[1];
//        for (int i = 0; i < myThread.length; i++) {
//            myThread[i] = new MyThread(group, "线程" + (i + 1), "1");
//            myThread[i].start();
//        }
    }
}

package com.threadTest.thread.add.state.groupException;

/**
 * Created by sky on 2017/3/24.
 */
public class MyThread extends Thread {
    private String num;

    public MyThread(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (false == this.isInterrupted()) {
            System.out.println("死循环中：" + Thread.currentThread().getName());
        }
    }
}

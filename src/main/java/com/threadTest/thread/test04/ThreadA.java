package com.threadTest.thread.test04;

/**
 * Created by sky on 2017/3/9.
 */
public class ThreadA extends Thread{
    private MyList list;
    public ThreadA (MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            list.add();
            System.out.println("添加了 " + (i+1) + "个元素");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

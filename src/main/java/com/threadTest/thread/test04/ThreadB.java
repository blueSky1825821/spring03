package com.threadTest.thread.test04;

/**
 * Created by sky on 2017/3/9.
 */
public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("B " + list.size());
            if (5 == list.size()) {
                System.out.println("== 5 了，线程b要退出");
                try {
                    throw new InterruptedException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.ThreadTest;

import org.junit.Test;

/**
 * Created by sky on 2016/11/20.
 */
public class SyncThread implements Runnable {
    private static int count;

    //构造器初始化
    public SyncThread() {
        count = 0;
    }

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                System.out.println(Thread.currentThread().getName() + ":" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("######");
            }

        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread01 = new Thread(syncThread, "syncThread01");
        Thread thread02 = new Thread(syncThread, "syncThread02");
        thread01.start();
        thread02.start();
    }

    @Test
    public void test01() {
        SyncThread syncThread = new SyncThread();
        Thread thread01 = new Thread(syncThread, "syncThread01");
        thread01.start();
        Thread thread02 = new Thread(syncThread, "syncThread02");
        thread02.start();
    }
}

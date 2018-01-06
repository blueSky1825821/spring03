package com.threadTest.deamon;

/**
 * Created by wm on 17-12-13.
 */
public class DeamonRunner implements Runnable {
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i < 10; i++) {
                System.out.println("deamon thread:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

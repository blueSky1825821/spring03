package com.threadTest.thread.add.state.group.test02;

/**
 * Created by sky on 2017/3/23.
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        try
        {
            while (!Thread.currentThread().isInterrupted())
            {
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

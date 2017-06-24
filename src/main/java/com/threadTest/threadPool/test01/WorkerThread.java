package com.threadTest.threadPool.test01;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2017/6/16.
 */
public class WorkerThread implements Runnable{
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start.Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End.Command = " + command);
    }

    private void processCommand() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE, true, true);
    }
}

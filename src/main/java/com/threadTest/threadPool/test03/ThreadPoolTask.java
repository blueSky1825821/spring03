package com.threadTest.threadPool.test03;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2017/6/20.
 */
public class ThreadPoolTask implements Callable<String>, Serializable{
    private static final long serialVersionUID = 0;

    private Object threadPoolTaskData;
    private static int consumeTaskSleepTime = 2000;

    public ThreadPoolTask(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    @Override
    public String call() throws Exception {
        //处理任务
        System.out.println("开始执行任务： " + threadPoolTaskData);
        String result = "";
        try {
            TimeUnit.SECONDS.sleep(10);
            result = "OK";
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = "ERROR";
        }
        return result;
    }
}

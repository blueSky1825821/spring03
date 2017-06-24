package com.threadTest.threadPool.test03;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by sky on 2017/6/20.
 */
public class StartTaskThread implements Runnable {
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private int i;

    public StartTaskThread(ThreadPoolTaskExecutor threadPoolTaskExecutor, int i) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.i = i;
    }

    @Override
    public void run() {
        String task = "task@ " + i;
        System.out.println("创建任务并提交到线程池中： " + task);
        FutureTask<String> futureTask = new FutureTask<String>(new ThreadPoolTask(task));
        threadPoolTaskExecutor.execute(futureTask);
        //在这里可以做别的事
        String result = null;
        //取得结果，同时设置超时时间为1秒。同样可以用future.get()，不设置超时时间取得结果
        try {
//            result = futureTask.get(1000, TimeUnit.MILLISECONDS);
            while (true) {
                if (futureTask.isDone()) {
                    result = futureTask.get();
                    break;
                }
            }
        } catch (InterruptedException e) {
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            futureTask.cancel(true);
        } catch (Exception e) {
            futureTask.cancel(true);
        } finally {
            System.out.println("task@ " + i + ":result=" + result);
        }
    }
}

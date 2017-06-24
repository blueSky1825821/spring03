package com.threadTest.threadPool.test01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2017/6/16.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        try {
            //在单元测试的最后加上sleep(),目的是不让主线程在子线程前结束。
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}

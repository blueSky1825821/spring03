package com.threadTest.threadPool.test05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wm on 18-1-8.
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                r -> {
                   Thread thread = new Thread(r);
                   thread.setName(r.getClass().getName());
                   return thread;
                }, new ThreadPoolExecutor.AbortPolicy()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("beforeExecute");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("afterExecute");
            }

            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("terminated");
            }
        };
        for (int i = 0; i < 10; i++) {
            int index = i;
//            executorService.submit(() -> System.out.println("submit i: " + index/0));
            executorService.execute(() -> System.out.println("execute i: " + index/0));
        }
        executorService.shutdown();
    }
}

package com.threadTest.threadPool.test05;

import java.util.concurrent.*;

/**
 * Created by wm on 18-1-8.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        test01();
        test02();
    }

    private static void test01() {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> {
                System.out.println("i: " + index + " executorService");
            });
        }
        executorService.shutdown();
    }

    private static void test02() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            int index = i;
            pool.submit(() -> {
                System.out.println("i: " + index + " executorService");
            });
        }
        pool.shutdown();
    }
}

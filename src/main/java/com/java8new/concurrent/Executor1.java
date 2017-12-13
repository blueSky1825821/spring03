package com.java8new.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wm on 17-8-22.
 */
public class Executor1 {
    public static void main(String[] args) {
        test1(3);
    }

    private static void test1(long seconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("tash finished: " + name);
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });
        stop(executor);
    }

    static void stop(ExecutorService executor) {
        System.out.println("attempt to shutdown executor");
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}

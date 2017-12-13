package com.java8new.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wm on 17-8-22.
 */
public class Executors3 {
    public static void main(String[] args) {

    }

    private static void test1() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Sheduling: " + System.nanoTime());
        int delay = 3;
        ScheduledFuture<?> future = executor.schedule(task, delay, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1337);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms\n", remainingDelay);
    }

    private static void test2() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            System.out.println("Scheduling: " + System.nanoTime());
        };
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, 1, TimeUnit.SECONDS);
    }

    private static void test3() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    private static void test4() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task3",
                () -> "task2",
                () -> "task1"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        executor.shutdown();
    }
}

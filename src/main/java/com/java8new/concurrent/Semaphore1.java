package com.java8new.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by wm on 17-8-24.
 */
public class Semaphore1 {
    private static final int NUM_INCREMENTS =1000000;

    private static Semaphore semaphore = new Semaphore(1);

    private static int count = 0;

    public static void main(String[] args) {
        testIncrement();
    }

    private static void testIncrement() {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> {
                    executor.submit(Semaphore1::increment);
                    System.out.println(i);
                });

        ConcurrentUtils.stop(executor);

        System.out.println("Increment: " + count);
    }

    private static void increment() {
        boolean permit = false;

        try {
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            count++;
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not increment");
        } finally {
            if (permit) {
                semaphore.release();
            }
        }
    }
}

package com.threadTest.communication;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wm on 18-1-4.
 */
public class TowThread {
    public static void main(String[] args) throws InterruptedException {
//        demo1();
//        demo2();
//        demo3();
//        runDAfterABC();
//        runABCWhenAllReady();
        doTaskWithResultWorker();
        Thread.sleep(1000);
    }

    /**
     * A print 1
     * B print 1
     * A print 2
     * B print 2
     * A print 3
     * B print 3
     */
    private static void demo1() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });
        a.start();
        b.start();
    }

    /**
     * B 开始等待 A
     * A print 1
     * A print 2
     * A print 3
     * B print 1
     * B print 2
     * B print 3
     */
    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        A.start();
        B.start();
    }

    /**
     * object.wait()
     * object.notify()
     * 两个线程顺序执行
     * A 1
     * B 1
     * B 2
     * B 3
     * A 2
     * A 3
     */
    private static void demo3() {
        Object lock = new Object();
        Thread A = new Thread(() -> {
            synchronized (lock) {
                System.out.println("A 1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A 2");
                System.out.println("A 3");
            }
        });

        Thread B = new Thread(() -> {
            synchronized (lock) {
                System.out.println("B 1");
                System.out.println("B 2");
                System.out.println("B 3");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }

    /**
     * D is waiting for other three threads
     * Ais working
     * Bis working
     * Cis working
     * Afinished
     * Bfinished
     * Cfinished
     * All done, D starts working
     */
    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(() -> {
            System.out.println("D is waiting for other three threads");
            try {
                countDownLatch.await();
                System.out.println("All done, D starts working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + "is working");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + "finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    /**
     * A is preparing for time: 3751
     * B is preparing for time: 2196
     * C is preparing for time: 4434
     * B is prepared, waitinga for others
     * A is prepared, waitinga for others
     * C is prepared, waitinga for others
     * C starts running
     * B starts running
     * A starts running
     */
    private static void runABCWhenAllReady() {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(() -> {
                long prepareTime = random.nextInt(10000) + 100;
                System.out.println(rN + " is preparing for time: " + prepareTime);
                try {
                    Thread.sleep(prepareTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(rN + " is prepared, waitinga for others");
                try {
                    cyclicBarrier.await();//当前运动员准备完，等待别人准备好
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(rN + " starts running");//所有运动员都准备好了，一起开始跑
            }).start();
        }
    }

    /**
     Before futureTask.get()
     Task starts
     Task finished and return result
     Result: 101
     After futureTask.get()
     */
    private static void doTaskWithResultWorker() {
        Callable<Integer> callable = () -> {
            System.out.println("Task starts");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += 1;
            }
            System.out.println("Task finished and return result");
            return result;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print " + i);
        }
    }
}

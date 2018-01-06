package com.threadTest.thread;

/**
 * Created by wm on 18-1-4.
 */
public class HelloThreadLocal {
    static int innitialValue = 0;
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 10);

    private static void testOutsideVariable() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                innitialValue += 10;
                threadLocalValue.set(threadLocalValue.get() + 10);
                System.out.println("innitialValue: " + innitialValue + ", threadLocalValue: " + threadLocalValue.get() + ", in " + Thread.currentThread().getName());
            }).start();
        }
    }

    static class CommonRunnable implements Runnable {
        int localInt = 0;

        ThreadLocal<Integer> threadLocalInt = ThreadLocal.withInitial(() -> 0);

        @Override
        public void run() {
            localInt += 10;
            threadLocalInt.set(threadLocalInt.get() + 10);
            System.out.println("localInt: " + localInt + ", threadLocalCount: " + threadLocalInt.get() + ", in" + Thread.currentThread().getName());
        }
    }

    private static void testThreadLocalVariable() {
        CommonRunnable runnable = new CommonRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
//        testOutsideVariable();
        testThreadLocalVariable();
    }
}

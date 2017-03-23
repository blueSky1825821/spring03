package com.threadTest;

import org.junit.Test;

/**
 * Created by sky on 2016/11/20.
 */
public class Counter implements Runnable {
    private static int count;

    //构造器初始化
    public Counter() {
        count = 0;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }

    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
//                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
//                    thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("######");
            }

        }
    }

    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
        for (int i = 0; i < 5; i++) {
//            try {
                System.out.println(Thread.currentThread().getName() + ":" + count);
//                thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("######");
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

//        Counter syncThreadA = new Counter();
//        thread threadA01 = new thread(syncThreadA, "syncThread01");
//        thread threadA02 = new thread(syncThreadA, "syncThread02");
//        threadA01.start();
//        threadA02.start();

        Counter syncThreadB = new Counter();
        Thread threadB01 = new Thread(syncThreadB, "A");
        Thread threadB02 = new Thread(syncThreadB, "B");
        threadB01.start();
        threadB02.start();
    }

    @Test
    public void test01() {
        Counter syncThreadA = new Counter();
        Thread thread01 = new Thread(syncThreadA, "syncThread01");
        thread01.start();
        Thread thread02 = new Thread(syncThreadA, "syncThread02");
        thread02.start();
    }
}

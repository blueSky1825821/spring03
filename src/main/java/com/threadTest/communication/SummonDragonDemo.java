package com.threadTest.communication;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wm on 18-1-8.
 招集第0个法师
 招集第2个法师
 招集第1个法师
 招集第3个法师
 招集第4个法师
 招集第5个法师
 招集第6个法师
 7个法师召集完毕，同时出发，去往不同的地方寻找龙珠！
 招集第7个法师
 第0颗龙珠已收集到！
 第1颗龙珠已收集到！
 第2颗龙珠已收集到！
 第3颗龙珠已收集到！
 第4颗龙珠已收集到！
 第5颗龙珠已收集到！
 第6颗龙珠已收集到！
 集齐七颗龙珠！召唤神龙！
 第7颗龙珠已收集到！
 */
public class SummonDragonDemo {
    private static final int THREAD_COUNT_SUM = 7;

    public static void main(String[] args) {
        //设置第一个屏障点，等待召集7位法师
        CyclicBarrier callMasterBarrier = new CyclicBarrier(THREAD_COUNT_SUM, () -> {
            System.out.println("7个法师召集完毕，同时出发，去往不同的地方寻找龙珠！");
            summonDragon();
        });
        //召集齐7位法师
        for (int i = 0; i <= THREAD_COUNT_SUM; i++) {
            int index = i;
            new Thread(() -> {
                System.out.println("招集第" + index +"个法师");
                try {
                    callMasterBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void summonDragon() {
        //设置第二个屏障点，等待7位法师收集完7颗龙珠，召唤神龙
        CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_SUM, () -> {
            System.out.println("集齐七颗龙珠！召唤神龙！");
        });
        //收集7颗龙珠
        for (int i = 0; i <= THREAD_COUNT_SUM; i++) {
            int index = i;
            new Thread(() -> {
                System.out.println("第" + index + "颗龙珠已收集到！");
                try {
                    summonDragonBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

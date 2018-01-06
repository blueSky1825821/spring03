package com.threadTest.deamon;

import java.util.Scanner;

/**
 * Created by wm on 17-12-13.
 */
public class TestDeamon {
    public static void main(String[] args) {

        Thread deamonThread = new Thread(new DeamonRunner());
        deamonThread.setDaemon(true);
        deamonThread.start();
        System.out.println("isDeamon? =" + deamonThread.isDaemon());
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM Exit!")));//没有其他现成执行时停止守护进程
    }
}

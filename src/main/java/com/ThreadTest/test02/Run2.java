package com.ThreadTest.test02;

/**
 * Created by sky on 2017/3/8.
 */
public class Run2 {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止它！ stopThread=" +
                Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}

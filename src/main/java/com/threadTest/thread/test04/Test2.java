package com.threadTest.thread.test04;

/**
 * Created by sky on 2017/3/9.
 */
public class Test2 {
    public static void main(String[] args) {
        String lock = new String();
        System.out.println("syn 上面 ");
        try {
            //对象监视器
            synchronized (lock) {
                System.out.println("syn 第一行");
                lock.wait();
                System.out.println("wait 下的代码");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syn 下面的代码 ");
    }
}

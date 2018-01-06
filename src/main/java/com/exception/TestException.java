package com.exception;

/**
 * Created by wm on 17-12-27.
 */
public class TestException {
    public static int noExcepiton(){
        int i = 10;
        try{
            System.out.println("i in try block is:" + i);
            return --i;
        } catch (Exception e) {
            --i;
            System.out.println("i in catch - from try block is: " + i);
            return --i;
        } finally {
            System.out.println("i in finally - from try or catch block is: " + i);
            return --i;
        }
    }

    public static void main(String[] args) {
        System.out.println("=============NoException==================");
        System.out.println(noExcepiton());
        System.out.println("===============================");
    }
}

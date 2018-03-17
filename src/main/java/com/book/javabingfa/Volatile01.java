package com.book.javabingfa;

import com.spring.tutorialspoint.po.Student;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wm on 18-2-4.
 */
public class Volatile01 {
    private static volatile Student s = null;

    public static Object getS() {
        return new Student();
    }

    public static void main(String[] args) {
        System.out.println(getS());
    }


}


package com.test.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by wm on 18-3-18.
 */
public class AtomicIntegerArrayTest {
    private static int[] value = new int[] { 1, 2 };
    private static AtomicIntegerArray ai = new AtomicIntegerArray(value);
    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}

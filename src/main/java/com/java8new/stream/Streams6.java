package com.java8new.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wm on 17-8-20.
 */
public class Streams6 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        int[] ints = {1, 3, 5, 7, 9};
        Arrays
                .stream(ints)
                .average()
                .ifPresent(System.out::println);
    }

    private static void test2() {
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(9)
                .add(11)
                .build()
                .average()
                .ifPresent(System.out::println);
    }

    private static void test3() {
        IntStream
                .range(0, 10)
                .average()
                .ifPresent(System.out::println);
    }

    private static void test4() {
        Stream
                .of(new BigDecimal("1.2"), new BigDecimal("3.7"))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::println);
    }
}

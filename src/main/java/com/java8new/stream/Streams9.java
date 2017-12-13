package com.java8new.stream;

import java.util.Arrays;

/**
 * Created by wm on 17-8-20.
 */
public class Streams9 {
    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}

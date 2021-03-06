package com.java8new.lambda;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Created by wm on 17-8-20.
 */
public class Lambda5 {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printKeyAndValue
                = (key, value) -> System.out.println(key + "-" + value);
        printKeyAndValue.accept("one", 1);
        printKeyAndValue.accept("two", 2);

        System.out.println("#########");

        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("one", 1);
        dummyValues.put("two", 2);
        dummyValues.put("three", 3);

        dummyValues.forEach((key, value) -> System.out.println(key + "-" + value));
    }
}

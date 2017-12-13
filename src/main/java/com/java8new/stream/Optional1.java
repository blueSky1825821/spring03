package com.java8new.stream;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Created by wm on 17-8-20.
 */
public class Optional1 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("fallback");
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}

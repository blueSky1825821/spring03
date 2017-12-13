package com.java8new.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wm on 17-8-22.
 */
public class String1 {
    public static void main(String[] args) {

    }

    private static void testChars() {
        String string = "foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(string);
    }

    private static void testPatternSplit() {
        String string = Pattern.compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s -> s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":"));
        System.out.println(string);
    }

    private static void testPatternPredicate() {
        long count = Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(Pattern.compile(".*@gmail\\.com").asPredicate())
                .count();
        System.out.println(count);
    }

    private static void testJoin() {
        String string = String.join(":", "foobar", "foo", "bar");
        System.out.println(string);
    }

    private static void testFile() {
        Path path = Paths.get(".");
        try {
            Files.newBufferedReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

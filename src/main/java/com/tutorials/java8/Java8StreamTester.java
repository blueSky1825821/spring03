package com.tutorials.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by wm on 17-9-24.
 */
public class Java8StreamTester {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("Use Java 8:");
        System.out.println("List: " + strings);

        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println("Empty strings: " + count);

        count = strings.stream().filter(s -> s.length() == 3).count();
        System.out.println("strings of length 3: " + count);

        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String merdedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + merdedString);

        List<Integer> squaresList = numbers.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("List: " + integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
        System.out.println("Random Numbers: ");

        //print ten random numbers
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}

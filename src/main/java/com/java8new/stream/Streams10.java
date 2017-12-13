package com.java8new.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wm on 17-8-20.
 */
public class Streams10 {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        test6(persons);

        StringJoiner();
    }

    private static void test1(List<Person> persons) {
        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void test2(List<Person> persons) {
        Map<Integer, List<Person>> personsByAge =
                persons
                        .stream()
                        .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    }

    private static void test3(List<Person> persons) {
        Double averageAge =
                persons
                        .stream()
                        .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);
    }

    private static void test4(List<Person> persons) {
        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummary);
    }

    private static void test5(List<Person> persons) {
        String names = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(names);
    }

    private static void test6(List<Person> persons) {
        Map<Integer, String> map =
                persons.stream()
                        .collect(Collectors.toMap(p -> p.age,
                                p -> p.name,
                                (name1, name2) -> name1 + ";" + name2));
        System.out.println(map);

        Stream<Integer> stream = Stream.of(1, 2, 3, 4).filter(p -> p > 2);
        List<Integer> result = stream.collect(() -> {
            return new ArrayList<>();
        }, (list, item) -> {
            list.add(item);
        }, (one, two) -> one.addAll(two));
        /* 或者使用方法引用 */
//        result = stream.collect(ArrayList::new, List::add, List::addAll);
    }

    private static void test7(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),     //supplier
                        (j, p) -> j.add(p.name.toUpperCase()),         //accumulator
                        (j1, j2) -> j1.merge(j2),                      //combiner
                        StringJoiner::toString);                      //finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }

    private static void test8(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> {
                            System.out.println("supplier");
                            return new StringJoiner(" | ");
                        },
                        (j, p) -> {
                            System.out.format("accumulator: p=%s; j=%s\n", p, j);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finisher");
                            return j.toString();
                        }
                );

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }

    private static void test9(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> {
                            System.out.println("supplier");
                            return new StringJoiner(" | ");
                        },
                        (j, p) -> {
                            System.out.format("accumulator: p=%s; j=%s\n", p, j);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finisher");
                            return j.toString();
                        }
                );

        String names = persons
                .parallelStream()
                .collect(personNameCollector);

        System.out.println(names);
    }

    static void StringJoiner() {
        StringJoiner s = new StringJoiner(",");
        s.add("name").add("sex").add("age");
        System.out.println(s.toString());
    }
}

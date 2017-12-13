package com.java8new.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 17-6-30.
 */
public class Lambda {
    public static void main(String[] args) {
        Set<Seller> strings = new HashSet<>();
        Seller s1 = new Seller();
        s1.setAge(17);
        s1.setName("a");
        Seller s2 = new Seller();
        s2.setAge(19);
        s2.setName("a");
        Set<Seller> txns = new HashSet<>();
        txns.add(s1);
        txns.add(s2);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(txns.stream()
                .filter(t -> t.getAge() > 16)
                .count());

        System.out.println(set.stream().filter(t -> t > 1).count());
    }


    @Test
    public void test01(){
        Arrays.asList("a", "b", "c").forEach(System.out::print);
        System.out.println();
        Arrays.asList("a", "b", "c").forEach(e -> System.out.print(e + ", "));

        Arrays.asList("a1", "b0", "c0").sort((e1, e2) -> e1.compareTo(e2));


    }
}

class Seller {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



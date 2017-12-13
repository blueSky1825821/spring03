package com.java8new.lambda;

/**
 * Created by wm on 17-8-18.
 * 函数式接口
 */
public class Lambda2 {
    //任意一个只包含一个抽象方法的接口，都可以用lambda表达式，用FunctionalInterface注解，如果包含第二个抽象方法，编译器就会报错
    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F form);
    }

    static class Something {
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactorty<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (form) -> Integer.valueOf(form);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);

        //method reference
        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);

        Something something = new Something();
        Converter<String, String> stringConverter = something::startWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);

       //constructor reference
        PersonFactorty<Person> personFactorty = Person::new;
        Person person = personFactorty.create("Peter", "Parker");
    }
}

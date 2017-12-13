package com.tutorials.java8;

/**
 * Lambda
 * 1、Optional type declaration
 * 2、Optional parenthesis around parameter
 * 3、Optional curly braces
 * 4、Optional return keyword
 */
public class Java8LambdaTester {
    public static void main(String[] args) {
        Java8LambdaTester tester = new Java8LambdaTester();
        //with type declaration
        MathOperation addtion = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        //with return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5" + tester.operation(10, 5, addtion));
        System.out.println("10 - 5" + tester.operation(10, 5, subtraction));
        System.out.println("10 x 5" + tester.operation(10, 5, multiplication));
        System.out.println("10 / 5" + tester.operation(10, 5, division));

        //without paraenthesis
        GreetingService greetingService = message -> System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetingService1 = (message) -> System.out.println("Hello " + message);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operation(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}

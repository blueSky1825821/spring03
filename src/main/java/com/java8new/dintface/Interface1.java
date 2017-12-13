package com.java8new.dintface;

/**
 * Created by wm on 17-8-17.
 * add extension/default method to class
 */
public class Interface1 {
    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a * 100;
            }
        };

        formula.calculate(100);
        formula.sqrt(-23);
        Formula.positive(-4);
    }
}

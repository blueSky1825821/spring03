package com.enum0;

/**
 * Created by sky on 2017/6/16.
 */
public class Enum01 {
    public enum weekday {
        mon(), tue(2), wes(3), thus(4), fri;
        private weekday() {
            System.out.println("no args");
        }
        private weekday(int i) {
            System.out.println("have args " + i);
        }
    }

    public static void main(String[] args) {
        weekday mon = weekday.mon;
        weekday tue = weekday.tue;
        weekday fri = weekday.fri;
    }
}

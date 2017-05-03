package com.audition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sky on 2017/4/27.
 */
public class Recursion {
    public static void main(String[] args) {
        String[] array  = new String[] {"1", "2"};
        listAll(Arrays.asList(array), "");
    }

    public static void listAll (List candidate, String prefix) {
//        if (candidate.isEmpty()) {
            System.out.println(prefix);
//        }

        for (int i = 0; i < candidate.size(); i++) {
            List temp = new LinkedList<>(candidate);
            listAll(temp, prefix + temp.remove(i));
        }
    }


    public void test() {
        for (int i = 0; i < 3; i++) {
            String[] array  = new String[] {"1", "2", "3"};
            List list = new LinkedList<>(Arrays.asList(array));
            String prefix = "";
            for (int j = 0; j < 2; j++) {
                String[] array1  = new String[] {"2", "3"};
                List list1 = new LinkedList<>(Arrays.asList(array1));
                prefix = prefix + "1";
                for (int m = 0; m < 1; m++) {
                    String[] array2  = new String[] {"3"};
                    List list2 = new LinkedList<>(Arrays.asList(array2));
                    prefix = prefix + "12";
                }
            }
        }
    }
}

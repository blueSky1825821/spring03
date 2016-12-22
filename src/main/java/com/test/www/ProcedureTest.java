package com.test.www;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2016/11/20.
 */
public class ProcedureTest {
    public static void main(String[] args) {

    }

    @Test
    public void testReturn() {

        this.equals(ProcedureTest.class);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String i : list) {
            if (i == "2") {
            }
            System.out.println(i);
        }
        System.out.println();

    }

    @Test
    public void testGC() throws InterruptedException {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i=0; i<100000; i++) {
            map.put(String.valueOf(i), new Integer(i));
            Thread.currentThread().sleep(10);
        }
    }
}

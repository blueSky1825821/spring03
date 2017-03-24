package com.core.program;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sky on 2017/3/23.
 */
public class DateTest {
    public static void main(String[] args) {
        GregorianCalendar now = new GregorianCalendar();
        int month = now.get(Calendar.MONTH);
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        System.out.println();

    }
}

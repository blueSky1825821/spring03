package com.combat1200.string;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by sky on 2017/5/3.
 */
public class FormatDate {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat formater = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println("中国时间： "+formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
        System.out.println("英国时间： "+formater.format(date));
        formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
        System.out.println("日本时间： "+formater.format(date));
    }
}

package com.threadTest.thread.add.state.simpleDateFormat.test02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sky on 2017/3/24.
 * 实际创建了多个SimpleDateFormat
 */
public class DateTools {
    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }
    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date).toString();
    }
}

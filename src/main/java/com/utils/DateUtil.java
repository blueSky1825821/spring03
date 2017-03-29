/*
 * 文 件 名: DateUtil.java 版 权: Dream Co., Ltd. Copyright YYYY-YYYY, All rights reserved 描 述: <描述> 修 改
 * 人: Owen 修改时间: -- 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.utils;

import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author Owen
 * @version [版本号, --]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DateUtil {
  /**
   * 注释内容
   */
  private static final Logger log = Logger.getLogger(DateUtil.class);

  /**
   * 默认日期格式
   */
  public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";


  public static final String DEFAULT_FORMAT_YMDHMS = "yyyyMMddHHmmss";


  /**
   * 默认日期格式
   */
  public static final String DEFAULT_FORMAT_SIMPLE = "yyyy-MM-dd";

  /**
   * 默认日期格式
   */
  public static final String DEFAULT_FORMAT_HMS = "HH:mm:ss";

  /**
   * <默认构造函数>
   */
  public DateUtil() {}

  /**
   * <字符串转换成日期> <如果转换格式为空，则利用默认格式进行转换操作>
   * 
   * @param str 字符串
   * @param format 日期格式
   * @return 日期
   * @see [类、类#方法、类#成员]
   */
  public static Date strDate(String str, String format) {
    if (null == str || "".equals(str)) {
      return null;
    }
    // 如果没有指定字符串转换的格式，则用默认格式进行转换
    if (null == format || "".equals(format)) {
      format = DEFAULT_FORMAT;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    Date date = null;
    try {
      date = sdf.parse(str);
      return date;
    } catch (ParseException e) {
      log.error("Parse string to date error!String : " + str);
    }

    return null;
  }

  /**
   * <一句话功能简述> <功能详细描述>
   * 
   * @param date 日期
   * @param format 日期格式
   * @return 字符串
   * @see [类、类#方法、类#成员]
   */
  public static String dateStr(Date date, String format) {
    if (null == date) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }

  public static String dateStr(Date time) {
    return DateUtil.dateStr(time, DEFAULT_FORMAT);
  }


  /**
   * <时间戳转换为字符串> <功能详细描述>
   * 
   * @param time
   * @return
   * @see [类、类#方法、类#成员]
   */
  public static String timestampStr(Timestamp time) {
    Date date = new Date(time.getTime());
    return dateStr(date, DEFAULT_FORMAT);
  }

  public static void main(String args[]) {
    strDate("2017-02-25",DEFAULT_FORMAT);
  }

  /**
   * <一句话功能简述> <功能详细描述>
   * 
   * @param str
   * @return
   * @see [类、类#方法、类#成员]
   */
  public static Timestamp strTimestamp(String str) {
    Date date = strDate(str, DEFAULT_FORMAT);
    return new Timestamp(date.getTime());
  }

  /**
   * 获取两个日期之间相差天数,包含两个日期当天
   * 
   * @param beginDate
   * @param endDate
   * @return
   */
  public static long dateDifDays(Date beginDate, Date endDate) {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();

    calendar1.clear();
    calendar1.setTime(beginDate);

    calendar2.clear();
    calendar2.setTime(endDate);

    long diffMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
    // long diffSeconds = diffMillis / 1000;
    // long diffMinutes = diffMillis / (60 * 1000);
    // long diffHours = diffMillis / (60 * 60 * 1000);
    long diffDays = diffMillis / (24L * 60 * 60 * 1000);

    return diffDays + 1;
  }
}

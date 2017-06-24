package com.test.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.MoreObjects;
import com.result.bo.PersonDo;
import com.utils.DateUtil;
import com.utils.StringUtilsUp;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.*;
import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * Created by sky on 2017/1/5.
 */
public class Test01 {


    public static void main(String[] args) {
        String s = String.valueOf(Double.parseDouble("10") / 100);
        System.out.println(s);
        try {
            Class<?> clazz = Class.forName("com.gc.action.Student");
            String name = clazz.getName();
            Class clazzSuper = clazz.getSuperclass();
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test01() {
        Vector v = new Vector();
        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
    }


    private static String toDotName(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i >= 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0)
                        sb.append(".");
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    @Test
    public void test02() {
        String s = "QueryZYPreOutHosSelf";
        s = toDotName(s);
        System.out.println(s);
    }

    @Test
    public void test03() {
        String REGEX = "(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])";
        String REGEX1 = "^\\d{4}";
        String startDate = "02013-06-04 13:25:13.0";
        Pattern p = Pattern.compile(REGEX);
        String s = null;
        Matcher m = p.matcher(startDate);
        if (m.find()) {
            s = m.group();
        }
        System.out.println(s);
    }

    @Test
    public void test04() {
        String s = "{\"idNo\":\"231\",\"name\":\"231\"}";
        PersonDo personDo = JSON.parseObject(s, PersonDo.class);
        System.out.println(personDo);
        byte[] b = new byte[]{89, 10, 111};
        List<byte[]> a = Arrays.asList(b);
        new LinkedList<>(a);
        System.out.println(StringUtilsUp.parseByte2HexStr(b));
        System.out.println(DateTime.now().toString(DateUtil.DEFAULT_FORMAT_SIMPLE) + " 23:59:59");
        try {
            JSONObject jsonObject = JSON.parseObject(null);
            if(jsonObject == null) {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test05() {
        String s = "11222";
        boolean b = StringUtilsUp.checkDigit(s);
        Assert.assertTrue(b);
        s.intern();
    }

    @Test
    public void test06() throws InterruptedException {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("disCountFee", "12");
        map1.put("disCountFlag", "21223");
        JSONObject s = new JSONObject(map1);
        System.out.println(s.toJSONString());
        boolean b;
        System.out.println(boolean.class);
        String s1 = (String) MoreObjects.firstNonNull(JSON.parseObject("{\"sa\":\"das\"}").get("gfFeeFlag"), "");
        System.out.println(s1);
        System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));

        System.out.println(TimeUnit.DAYS.convert(10, TimeUnit.DAYS));
        System.out.println(TimeUnit.DAYS.convert(10, TimeUnit.HOURS));
        TimeUnit.SECONDS.sleep(12);
        System.out.println(TimeUnit.DAYS.convert(10, TimeUnit.MINUTES));

    }



}

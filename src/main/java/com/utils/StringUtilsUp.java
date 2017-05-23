package com.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by sky on 2017/2/24.
 */
public class StringUtilsUp {
    private static StringUtilsUp _instance = new StringUtilsUp();

    public static Boolean isBlank(String... args) {
        for (String arg : args) {
            if (StringUtils.isBlank(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是数字
     *
     * @param arrayStr
     * @return
     */
    public static boolean checkDigit(String arrayStr) {
        arrayStr = arrayStr.trim();
        if (StringUtilsUp.isBlank(arrayStr)) {
            return false;
        }
        for (int i = 0; i < arrayStr.length(); i++) {
            char charAt = arrayStr.charAt(i);
            if (Character.isDigit(charAt)) {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是数字
     *
     * @param arrayStr
     * @return
     */
    public static boolean isDigit(String arrayStr) {
        System.out.println(NumberUtils.isDigits(arrayStr));
        System.out.println(NumberUtils.isNumber(arrayStr));
        return NumberUtils.isDigits(arrayStr);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 反射
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String toString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        StringBuffer sb = new StringBuffer();
        Package packageName = clazz.getPackage();
        sb.append("包名：" + packageName.getName() + "\t");
        String clazzName = clazz.getSimpleName();
        sb.append("类命：" + clazzName + "\n");
        sb.append("公共构造方法： \n");
        //获得所有代表构造方法的constructor数组
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());
            if (modifier.contains("public")) {
                sb.append(constructor.toGenericString() + "\n");
            }
        }
        sb.append("公共域： \n");
        Field[] fields = clazz.getDeclaredFields(); //所有域public、protect、
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.contains("public")) {
                sb.append(field.toGenericString() + "\n");
            }
        }
        sb.append("公共方法：");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.contains("public")) {
                sb.append(method.toGenericString() + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * 获取最小值
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T getMin(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];   //假设最小的元素
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i])>0) {
                min =array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "1233441121a";
        isDigit(s);
        System.out.println(new StringUtilsUp().toString(new Object()));
    }
}

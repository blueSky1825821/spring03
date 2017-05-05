package com.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by sky on 2017/2/24.
 */
public class StringUtilsUp {
    private static StringUtilsUp _instance = new StringUtilsUp();

    public static Boolean isBlank(String ... args) {
        for (String arg : args) {
            if (StringUtils.isBlank(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是数字
     * @param arrayStr
     * @return
     */
    public static boolean checkDigit (String arrayStr) {
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
     * @param arrayStr
     * @return
     */
    public static boolean isDigit (String arrayStr) {
        System.out.println(NumberUtils.isDigits(arrayStr));
        System.out.println(NumberUtils.isNumber(arrayStr));
        return NumberUtils.isDigits(arrayStr);
    }

    /**将二进制转换成16进制
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

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1233441121a";
        isDigit(s);
    }
}

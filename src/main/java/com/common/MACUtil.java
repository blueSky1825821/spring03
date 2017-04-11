package com.common;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by colar on 16-5-12.
 */
public class MACUtil {

    /**
     * 16进制字符转byte
     *
     * @param c
     * @return
     */
    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 16进制字符转byte[]
     *
     * @param
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * des加密过程
     *
     * @param key
     * @param
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeySpecException
     */
    public static byte[] des(String content, String key, int mode) {

        try {
            byte[] tKey = hexStringToBytes(key);
            byte[] tBuf = hexStringToBytes(content);
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(tKey);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
//        Cipher cipher = Cipher.getInstance("DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(mode, securekey, random);
            return cipher.doFinal(tBuf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * byte 转换成16进制字符串
     *
     * @param b
     * @return
     */
    public static String byte2HexStr(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static String xOrString(String pan, String pin) {
        //TODO
        //System.out.println("参与异或的因子分别为：" + pan + "和" + pin);
        if (pan.length() != pin.length()) {
            new Exception("异或因子长度不一致").printStackTrace();
            return null;
        }

//        byte [] bytepan = ByteUtil.getHexByte(pan);
        byte[] bytepan = hexStringToBytes(pan);
//        byte [] bytepin = ByteUtil.getHexByte(pin);
        byte[] bytepin = hexStringToBytes(pin);

        byte[] result = new byte[bytepan.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (bytepan[i] ^ bytepin[i]);
        }

        //TODO
        //System.out.println("异或后的结果为：" + ByteUtil.getHexStr(result));
        return byte2HexStr(result);
    }


    /**
     * 生成ANSI-X9.9-MAC校验码
     * 所有的输入输出数据必须是16进制字符串
     * 密钥只能为16位长度的16进制字符串,否则将返回null
     * 初始向量为16为长度的16进制字符串,如果不符合条件,自动设置为"0000000000000000"
     * 原始数据,16进制表示的字符串
     *
     * @param key    密钥
     * @param vector 初始向量
     * @param data   加密数据
     * @return 加密后的数据
     */
    public static String MAC(String key, String vector, String data) {
        if (key.length() != 16) {
            new Exception("key's length must be 16!").printStackTrace();
            return null;
        }

        if (vector == null || vector.length() != 16)
            vector = "0000000000000000";

        StringBuffer sb = new StringBuffer(data);
        int mod = data.length() % 16;
        if (mod != 0) {
            for (int i = 0; i < 16 - mod; i++) {
                sb.append("0");
            }
        }

        String operator = sb.toString();
        //TODO
//        System.out.println("补位后的操作数为：" + operator);

        int count = operator.length() / 16;
        String[] blocks = new String[count];

        for (int i = 0; i < count; i++) {
            blocks[i] = operator.substring(i * 16, i * 16 + 16);
        }

        //循环进行异或,DES加密
        for (int i = 0; i < count; i++) {
            String xor = xOrString(vector, blocks[i]);
            vector = byte2HexStr(des(xor, key, Cipher.ENCRYPT_MODE));
//            System.out.println("第"+i+"次des加密结果:"+vector+"|||加密字符串:"+xor+"||key :"+key);
        }
        return vector;
    }


    /**
     * 生成 mac 方法
     *
     * @param key
     * @param vector
     * @param xml
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String mac919(String key, String vector, String xml) throws UnsupportedEncodingException {
        return Mac_919(key, vector, byte2HexStr(xml.getBytes("GBK")));

    }

    /**
     * 按照ANSIX9.19算法标准，生成MAC
     *
     * @param key    加密密钥32位16进制字符串
     * @param vector 初始向量16位16进制字符串
     * @param data   生成mac的原始数据的16进制表示
     * @return 最终生成mac的字符串
     */
    public static String Mac_919(String key, String vector, String data) {
        if (key.length() != 32) {
            new Exception("key of ansix9.19 must be 32").printStackTrace();
            return null;
        }

        String left = key.substring(0, 16);
        String right = key.substring(16);
        System.out.println("left Key:"+left);
        System.out.println("right Key:"+right);
        String mac = MAC(left, null, data);
        System.out.println("mac x99 后:"+mac);
        String result1 = byte2HexStr(des(mac, right, Cipher.DECRYPT_MODE));
        System.out.println("des解密结果:"+result1+"|||解密字符串:"+mac+"||key :"+result1);
        String result2 = byte2HexStr(des(result1, left, Cipher.ENCRYPT_MODE));

//		String ret = result2.substring(0,8);
        return result2;
    }

    /**
     * des加密 包括输入字符串处理，用于深圳银医平台包括对加密因子的处理
     *
     * @return
     */
    public static String DESencry(String content, String password, String key) {
        String s1 = content.substring(3, content.length() - 1);
        String s2 = "0000" + s1;
        System.out.println(s2);
        String s3 = "06" + password + "FFFFFFFF";
        System.out.println(s3);
        String s4 = MACUtil.xOrString(s3, s2);
        System.out.println(s4);
        String des = Mac_919(key, null, s4);
        return des;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        //String mac = MAC("A1D610A2D9E00B5D","0000000000000000","123456781234512345678123451234567812345");
        //System.out.println("生成mac为：" + mac);


//        String content ="<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT type=\"response\"><TR_CODE>1010</TR_CODE><HIS_DT>20160512</HIS_DT><HIS_TM>154511</HIS_TM><HIS_LIST>1010011103000005108</HIS_LIST><CHN_NO>S</CHN_NO><MERC_NO>0111030000051</MERC_NO><TERM_ID>0103YT0001</TERM_ID><CYC_CNT>0</CYC_CNT><CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>6226900301154296</CARD_NO><PWD_FLAG>1</PWD_FLAG><PWD>ab32c4f82b3787b1</PWD><ID_TYPE>101</ID_TYPE><ID_NO>110108196104010174</ID_NO><SICK_NAME>中信测试二</SICK_NAME><NEW_ID_TYPE>101</NEW_ID_TYPE><NEW_ID_NO>110108196104010174</NEW_ID_NO><NEW_NAME>中信测试二</NEW_NAME><SICK_TEL>13800138137</SICK_TEL><SICK_ADDR>深圳市罗湖区南湖路兴隆大厦裙楼1楼</SICK_ADDR><HOSP_NO>0111030000051</HOSP_NO><TERMDEVID>0103YT0001</TERMDEVID><PRI_AC_NO>6226900301154296</PRI_AC_NO></ROOT>";
        String content ="<?xml version=\\\"1.0\\\" encoding=\\\"GBK\\\"?><ROOT type=\\\"response\\\"><TR_CODE>1001</TR_CODE><HIS_DT>20160510</HIS_DT><HIS_TM>162015</HIS_TM><HIS_LIST>1001011103000005202</HIS_LIST><CHN_NO>S</CHN_NO><MERC_NO>0111030000051</MERC_NO><TERM_ID>0103YT0001</TERM_ID><CYC_CNT>0</CYC_CNT><HOSP_NO>0111030000051</HOSP_NO><CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>6226900301154201</CARD_NO><PWD></PWD><ID_TYPE>101</ID_TYPE><ID_NO>110108196104010201</ID_NO><SICK_NAME>远图测试二</SICK_NAME><SICK_TEL>13800138201</SICK_TEL><SICK_ADDR>深圳市罗湖区南湖路兴隆大厦裙楼2楼</SICK_ADDR><BANK_CARD_NO></BANK_CARD_NO><BANK_CARD_PWD></BANK_CARD_PWD><PRI_AC_NO>6226900301154296</PRI_AC_NO><TERMDEVID>0103YT0001</TERMDEVID></ROOT>";
        String veckor = "0000000000000000";
        String key = "12121212121212121212121212121212";
        System.out.println(Mac_919(key,veckor,byte2HexStr(content.getBytes("GBK"))));


        String content1 ="0000000000000000";
        String veckor1 = "0000000000000000";
        String key1 = "12121212121212121212121212121212";
        System.out.println(Mac_919(key1,veckor1,byte2HexStr(content1.getBytes("GBK"))));


//        String ps = "D6D0D0C5B2E2";
//        String str = "中";
//        System.out.println(byte2HexStr(str.getBytes("GBK")));
//        System.out.println(new String(hexStringToBytes(ps),"GBK"));
//        System.out.println(new String(hexStringToBytes(ps),"UTF-8"));
//        System.out.println(new String(hexStringToBytes(ps),"US-ASCII"));


        System.out.println("中国".length());
        System.out.println("中国".getBytes("GBK").length);
        System.out.println("AB".getBytes("GBK").length);


        System.out.println("DES加密");
        System.out.println("########################");
        System.out.println("DES加密");

        String content2 = "1111111111111111";
        String content3 = "2635198708184662";
        key = "2222222222222222";
        String password = "184662";
        key = "C7F864E6B36B51E3238952F829BADCD5";
//        hexStringToBytes(content1);
        byte[] des = des(content1, key, Cipher.ENCRYPT_MODE);
        String s = new String(des);
        System.out.println(s);
        System.out.println("########################");

        String desencry = DESencry(content3, password, key);
        System.out.println("desencry:" + desencry);

        String t = "acdv";
        System.out.println(t.getBytes("GBK").length);

        t = Mac_919(key, null, content3);

    }
}

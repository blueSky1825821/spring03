package com.utils;

import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sky on 2017/5/24.
 * 解析域名
 */
public class InetAddressUtil {
    public static void parseDomain(String domain) {
        try {
            if (StringUtils.isNotBlank(domain)) {
                String host = domain;
                //为给定的主机名 返回对应的因特尔地址的数组
                InetAddress[] address = InetAddress.getAllByName(host);
                for (InetAddress a : address) {
                    System.out.println(a);
                }
            } else {
                InetAddress localHostAddress = InetAddress.getLocalHost();
                System.out.println(localHostAddress);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InetAddressUtil.parseDomain("www.baidu.com");
    }
}

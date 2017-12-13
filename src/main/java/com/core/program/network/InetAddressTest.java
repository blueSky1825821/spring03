package com.core.program.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sky on 2017/4/10.
 * 解析域名/获取本机IP
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                String host = args[0];
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
}

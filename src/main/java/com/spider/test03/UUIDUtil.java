package com.spider.test03;

import java.util.UUID;

/**
 * Created by k on 2016/8/24.
 */
public class UUIDUtil {
    /**
     * 产生一个32位的GUID
     *
     * @return
     */
    public static String newGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(newGUID().length());
    }
}

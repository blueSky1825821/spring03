package com.utils;

import org.apache.commons.lang.StringUtils;

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
}

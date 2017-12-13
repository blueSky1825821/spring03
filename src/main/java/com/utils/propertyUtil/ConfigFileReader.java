package com.utils.propertyUtil;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ConfigFileReader {

    protected final static Logger logger = LoggerFactory.getLogger("webparams");

    /**
     * 服务地址cache
     */
    private static LoadingCache<String, String> propertiesCache = CacheBuilder.newBuilder()
            .maximumSize(1000).expireAfterWrite(10, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                public String load(String key) throws Exception {
                    return getProperty(key);
                }
            });

    public static String getCacheKey(String urlKey) {
        try {
            return propertiesCache.get(urlKey);
        } catch (Exception e) {
            logger.error("his.url=" + urlKey, e);
            return "";
        }
    }

    public static String getProperty(String key) {
        logger.error("key=" + key);
        String value = getVarByKey("properties/messages.properties", key);
        logger.error("value=" + value);
        return value;
    }

    private static Properties reader(String path) {
        InputStream in = ConfigFileReader.class.getResourceAsStream(path);
        Properties p = new Properties();
        try {
            if (in != null) {
                p.load(in);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return p;
    }

    public static String getVarByKey(String path, String key) {
        Properties p = reader(path);
        if (p == null) {
            return "";
        }
        String var = p.getProperty(key);
        if (StringUtils.isBlank(var)) {
            var = "";
        }
        return var;
    }
}

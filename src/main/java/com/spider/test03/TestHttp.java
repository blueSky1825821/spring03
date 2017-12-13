package com.spider.test03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wm on 17-8-30.
 */
public class TestHttp {
    private final static String url = "http://mobile.yangkeduo.com/goods.html";
    private final static String str = "goods_id=7298818&is_spike=0&refer_page_name=search_result&refer_page_id=search_result_1504099004543_DVV6HveP89";

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() ->
                HttpInvokeUtil.get(url, str, HttpProtocolHandler.HTML), 2, 10, TimeUnit.SECONDS);
    }
}

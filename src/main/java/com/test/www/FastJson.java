package com.test.www;

/**
 * Created by sky on 2016/10/19.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJson {


    /**
     * 简单序列化
     */
    private static void simpleTest() {
        UserInfo userInfo = new UserInfo("owen", 24);
        String jsonStr = JSON.toJSONString(userInfo);
        System.out.println(jsonStr);
    }

    /**
     * 复杂序列化
     */
    public static void complexTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "owen");
        map.put("age", 25);
        map.put("sex", "男");

        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("name", "jack");
        temp.put("age", 18);
        map.put("girinfo", temp);

        List<String> list = new ArrayList<String>();
        list.add("爬山");
        list.add("电影");
        list.add("旅游");
        map.put("hobby", list);

        String jsonStr = JSON.toJSONString(map);
        System.out.println(jsonStr);
    }

    /**
     * 日期序列化
     */
    public static void DateTest() {
        Date date = new Date();
        // 默认输出
        System.out.println("时间戳=" + JSON.toJSONString(date));
        // 默认的日期格式
        System.out.println("当前日期=" + JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));
        // 使用指定的日期格式
        System.out.println("当前日期=" + JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat));
    }

    /**
     * 简单反序列化
     */
    public static void simpleDeserializeTest() {
        String userInfoJSONStr = "{\"name\":\"owen\", \"age\":24}";
        UserInfo userInfo = JSON.parseObject(userInfoJSONStr, UserInfo.class);
        System.out.println("name = " + userInfo.getName() + ", age = " + userInfo.getAge());
    }

    /**
     * 泛型反序列化
     */
    public static void genericTypeDeserializeTest() {
        String jsonStr = "{\"user\":{\"name\":\"owen\", \"age\":24}}";
        Map<String, UserInfo> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, UserInfo>>() {
        });
        System.out.println(map.get("user").getAge() + "\n");

        String jsonStr2 = "{\"user\":[{\"name\":\"owen\", \"age\":24}, {\"name\":\"jack\", \"age\":18}]}";
        Map<String, List<UserInfo>> users = JSON.parseObject(jsonStr2, new TypeReference<Map<String, List<UserInfo>>>() {
        });
        for (UserInfo info : users.get("user")) {
            System.out.println("name=" + info.getName());
            System.out.println("age=" + info.getAge());
            System.out.println("------------------");
        }
    }

    /**
     * test
     */
    public static void main(String[] args) {
        genericTypeDeserializeTest();
    }

}

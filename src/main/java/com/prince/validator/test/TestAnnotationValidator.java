package com.prince.validator.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.prince.validator.AnnotationValidator;
import com.prince.validator.annotation.parser.DateFormatParser;
import com.prince.validator.annotation.parser.ExistParser;
import com.prince.validator.annotation.parser.ValidateResult;
import com.utils.MapUtil;

import java.util.Map;


public class TestAnnotationValidator {
    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        map.put("name", "wang");
        map.put("age", "28");
        map.put("sex", "1");
        map.put("birthday", "2017-11-111");
        User user = new User();
        User user1;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            user1 = JSON.parseObject(JSON.toJSONString(map), User.class);
        }
        System.out.println(System.currentTimeMillis() - s);
        System.out.println("###############");

        s = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            try {
                user = (User) MapUtil.convertMap(user.getClass(), map);
//			user = (User) MapUtil.mapToBean(map, user.getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - s);
        System.out.println(user.toString());

        AnnotationValidator.register(new DateFormatParser());
        AnnotationValidator.register(new ExistParser());
        ValidateResult result = AnnotationValidator.validate(user);
        if (result.isValid()) {
            System.out.println("校验通过");
        } else {
            System.out.println(result.getMessage());
        }
    }

}

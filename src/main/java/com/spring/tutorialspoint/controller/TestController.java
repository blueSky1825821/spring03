package com.spring.tutorialspoint.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.spring.tutorialspoint.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sky on 2017/6/8.
 */
@Controller
public class TestController {
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/cache.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String setCache(ModelMap model) {
        List<Object> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            cacheService.put(i, cacheService.preQueryHisCard + i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(cacheService.get(i));
        }
        model.addAttribute("list", list);
        return "cache";
    }

    @RequestMapping(value = "/viewCache.do1", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object viewCache() {
        return JSON.toJSONString(cacheService.getCache());
    }
}

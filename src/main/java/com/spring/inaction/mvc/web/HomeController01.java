package com.spring.inaction.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by sky on 2017/1/18.
 */
//声明为一个控制器
@Controller
public class HomeController01 {
    //处理对"/"的GET请求
    @RequestMapping(value = "/", method = {GET, POST})
    public String home() {
        return "home";
    }
}

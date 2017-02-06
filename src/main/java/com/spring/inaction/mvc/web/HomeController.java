package com.spring.inaction.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sky on 2017/1/19.
 */
@Controller
@RequestMapping("/")    //将控制器映射到"/"
//@RequestMapping({"/", "/homepage"})    //将控制器将"/"映射到"/homepage"
public class HomeController {
    @RequestMapping(method = GET)   //处理GET请求
    public String home() {
        return "home";  //视图名为home
    }
}

package com.spring.tutorialspoint.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sky on 2016/12/16.
 */
@Controller
@RequestMapping("/hello.do1")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework");
        //返回hello.jsp
        return "hello";
    }
}

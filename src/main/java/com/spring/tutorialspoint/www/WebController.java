package com.spring.tutorialspoint.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sky on 2016/12/23.
 */
@Controller
public class WebController {

    @RequestMapping(value = "/index.do1", method = RequestMethod.GET)
    public String index() {
        return "index2";
    }

    @RequestMapping(value = "/redirect.do1", method = RequestMethod.GET)
    public String redirect() {

        return "redirect:finalPage.do1";
    }

    @RequestMapping(value = "/finalPage.do1", method = RequestMethod.GET)
    public String finalPage() {

        return "final";
    }
}

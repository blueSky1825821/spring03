package com.baidu.jsr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


/**
 * Created by sky on 17-7-6.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String test1(Model model){
        model.addAttribute("testVo", new TestVo());
        return "index";
    }
    @RequestMapping("/add.do1")
    public String test2(@Valid @ModelAttribute("testVo") TestVo	testVo, BindingResult result){
        if(result.hasErrors()) {
            return "error";
        } else {
            return "index";
        }
    }
}

package com.baidu.jsr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


/**
 * Created by sky on 17-7-6.
 */

@Controller
public class UserController {
    @Autowired
    private ReloadableResourceBundleMessageSource validatorFactoryBean;

    private Set<String> s;


    @RequestMapping(value = "/save.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String save(@Valid User user, BindingResult result) {
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                System.out.println("errors --"+fieldError.getField()+fieldError.getDefaultMessage());
            }
        }
        System.out.println("s.name="+user.getName());
        System.out.println("s.age="+user.getId());
        if (result.hasErrors()) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/save1.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String addCustomer(@Valid TestVo customer, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        } else {
            return "Done";
        }
    }

}

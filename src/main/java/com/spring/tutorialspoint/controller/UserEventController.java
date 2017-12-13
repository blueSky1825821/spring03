package com.spring.tutorialspoint.controller;

import com.spring.tutorialspoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wm on 17-10-9.
 */
@Controller
public class UserEventController {
    private final UserService userService;

    @Autowired
    public UserEventController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public void register() {
        userService.register("test");
    }
}

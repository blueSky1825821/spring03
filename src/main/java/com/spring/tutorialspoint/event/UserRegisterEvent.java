package com.spring.tutorialspoint.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wm on 17-10-9.
 */
public class UserRegisterEvent extends ApplicationEvent{
    public UserRegisterEvent(String name) {
        super(name);
    }
}

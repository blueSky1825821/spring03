package com.spring.tutorialspoint.service;

import com.spring.tutorialspoint.event.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Created by wm on 17-10-9.
 */
@Service
public class UserService implements ApplicationEventPublisherAware{
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String name) {
        System.out.println("用户： " + name + " 注册！");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
        System.out.println("用户： " + name + " 已注册！");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

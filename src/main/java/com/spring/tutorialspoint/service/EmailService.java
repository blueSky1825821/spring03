package com.spring.tutorialspoint.service;

import com.spring.tutorialspoint.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by wm on 17-10-9.
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("邮件服务接到通知，给： " + userRegisterEvent.getSource() + "发送邮件...");
    }
}

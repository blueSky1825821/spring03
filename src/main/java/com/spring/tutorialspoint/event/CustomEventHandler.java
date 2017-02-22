package com.spring.tutorialspoint.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by sky on 2016/12/15.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}

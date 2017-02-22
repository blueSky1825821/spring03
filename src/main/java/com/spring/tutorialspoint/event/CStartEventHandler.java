package com.spring.tutorialspoint.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by sky on 2016/12/15.
 */
//Listening to Context Events
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent Received");
    }
}

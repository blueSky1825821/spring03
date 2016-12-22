package com.spring.tutorialspoint.www;

import org.springframework.context.ApplicationEvent;

/**
 * Created by sky on 2016/12/15.
 */
public class CustomEvent extends ApplicationEvent{
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Custom Event";
    }
}

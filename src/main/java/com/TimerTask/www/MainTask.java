package com.TimerTask.www;

import org.junit.Test;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import  org.apache.log4j.Logger;

/**
 * Created by sky on 2016/12/25.
 */
@Component
@EnableScheduling
public class MainTask {
    static Logger log = Logger.getLogger(MainTask.class.getName());

    @Scheduled(cron = "*/2 * * * * *")
    public void excute() {
        log.error("#######");
        System.out.println("########");
    }
}

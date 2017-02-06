package com.spring.inaction.aop.test01;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * Created by sky on 2017/1/11.
 */
public class TrackCounterConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setArticle("article");
        cd.setTitle("tile");
        ArrayList<Object> tracks = new ArrayList<>();
        tracks.add("Sgt");
        tracks.add("With");
        tracks.add("Lucy");
        tracks.add("Get");
        return null;
    }
}

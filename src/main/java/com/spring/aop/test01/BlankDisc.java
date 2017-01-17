package com.spring.aop.test01;

/**
 * Created by sky on 2017/1/11.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String article;

    public BlankDisc(String title, String article) {
        this.title = title;
        this.article = article;
    }

    public BlankDisc() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " +article);
    }
}

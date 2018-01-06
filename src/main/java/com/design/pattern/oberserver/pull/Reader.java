package com.design.pattern.oberserver.pull;

/**
 * Created by wm on 18-1-5.
 * 真正的读者，为了简单就描述下姓名
 */
public class Reader implements Observer {
    /**
     * 读者姓名
     */
    private String name;

    @Override
    public void update(Subject subject) {
        //这里采用拉的方式
        System.out.println(name + " 收到报纸了，阅读它。内容是===" + ((NewsPaper) subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

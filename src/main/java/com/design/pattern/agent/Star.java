package com.design.pattern.agent;

/**
 * Created by wm on 18-1-4.
 * 被代理角色
 */
public class Star implements Subject{

    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + ": 经济人接了一部电影，我负责拍就好了。");
    }
}

package com.design.pattern.agent;

/**
 * Created by wm on 18-1-4.
 * 代理角色
 */
public class Agent implements Subject{
    private Subject star;

    public Agent(Subject star){
        this.star = star;
    }

    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + ": 剧本很好，这部电影接下了。");
        star.movie();
    }
}

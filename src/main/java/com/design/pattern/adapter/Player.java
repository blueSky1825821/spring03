package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 */
public abstract class Player {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();
    public abstract void defense();
}

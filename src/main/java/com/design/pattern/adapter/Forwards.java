package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 */
public class Forwards extends Player {

    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("前锋 {0} 进攻" + name);
    }

    @Override
    public void defense() {
        System.out.println("前锋 {0} 防御" + name);
    }
}

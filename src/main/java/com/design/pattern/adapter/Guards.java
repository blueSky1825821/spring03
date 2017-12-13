package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 */
public class Guards extends Player {

    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("后卫 {0} 进攻" + name);
    }

    @Override
    public void defense() {
        System.out.println("后卫 {0} 防御" + name);
    }
}

package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 */
public class ForeignCenter {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void 进攻(){
        System.out.println("外籍中锋 {0} 进攻" + name);
    }

    public void 防御(){
        System.out.println("外籍中锋 {0} 防御" + name);
    }
}

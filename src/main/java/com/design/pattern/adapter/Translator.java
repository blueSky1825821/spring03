package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 * 适配器模式：将一个类的接口转换成客户希望的另一个接口
 */
public class Translator extends Player {
    /**
     * 注意---------
     */
    private ForeignCenter wjzf = new ForeignCenter();

    public Translator(String name) {
        super(name);
        wjzf.setName(name);
    }

    @Override
    public void attack() {
        wjzf.进攻();
    }

    @Override
    public void defense() {
        wjzf.防御();
    }
}

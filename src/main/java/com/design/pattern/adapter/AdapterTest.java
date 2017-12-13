package com.design.pattern.adapter;

/**
 * Created by wm on 17-8-13.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attack();
        Player m = new Guards("麦克格雷迪");
        m.attack();
        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();
    }
}

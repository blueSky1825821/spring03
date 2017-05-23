package com.combat1200.reflect;

/**
 * Created by sky on 2017/5/19.
 */
public class HouseSeller implements Seller{
    @Override
    public void sell() {
        System.out.println("销售人员在卖房子");
    }
}

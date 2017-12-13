package com.design.pattern.facede;

/**
 * Created by wm on 17-8-12.
 * 外观模式：数据访问层、业务逻辑层、表示层
 * 让新系统与facede对接
 */
public class Facede {
    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThr subSystemThr;

    public Facede() {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThr = new SubSystemThr();
    }

    public void methodA() {
        System.out.println("方法组A()----");
        subSystemOne.methodOne();
        subSystemThr.methodThr();
    }

    public void methodB() {
        System.out.println("方法组B()----");
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
    }
}

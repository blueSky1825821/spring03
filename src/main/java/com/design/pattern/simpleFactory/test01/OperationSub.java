package com.design.pattern.simpleFactory.test01;

/**
 * Created by wm on 17-8-12.
 */
public class OperationSub extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}

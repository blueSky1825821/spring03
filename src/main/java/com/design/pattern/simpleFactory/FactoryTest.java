package com.design.pattern.simpleFactory;

/**
 * Created by wm on 17-8-12.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Operation operation;
        operation = OperationFactory.createOperate("+");
        operation.setNumberA(1);
        operation.setNumberB(10);
        System.out.println(operation.getResult());
    }
}

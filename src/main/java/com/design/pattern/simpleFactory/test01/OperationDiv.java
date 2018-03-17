package com.design.pattern.simpleFactory.test01;

/**
 * Created by wm on 17-8-12.
 */
public class OperationDiv extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        try {
            if (getNumberB() == 0) {
                throw new Exception("除数不能为0.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = getNumberA() / getNumberB();
        return result;
    }
}

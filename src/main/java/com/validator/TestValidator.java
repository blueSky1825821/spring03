package com.validator;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * Created by sky on 17-7-3.
 */
public class TestValidator {
    public static void main(String[] args) {
        Car car = new Car();
        Result ret = FluentValidator.checkAll()
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate()
                .result(toSimple());
        ret.getErrorNumber();
        System.out.println(ret);
    }
}

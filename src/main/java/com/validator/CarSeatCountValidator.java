package com.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.common.Result;

/**
 * Created by sky on 17-7-3.
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    @Override
    public boolean validate(ValidatorContext context, Integer t) {
        if (t < 2) {
            context.addError(ValidationError.create(String.format("Something is wrong about the car seat count!, invalid value=%s", t)).setErrorCode(Result.ARGS_ERROR).setField("seatCount").setInvalidValue(t));
            return false;
        }
        return true;
    }
}

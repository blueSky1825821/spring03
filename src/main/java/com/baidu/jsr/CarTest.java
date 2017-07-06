package com.baidu.jsr;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by sky on 17-7-6.
 */
public class CarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufactureIsNull() {
        Car car = new Car(null, "DD-AB-123", 4);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());
    }
}

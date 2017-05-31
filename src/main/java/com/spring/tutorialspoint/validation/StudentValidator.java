package com.spring.tutorialspoint.validation;

import com.spring.tutorialspoint.po.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by sky on 2017/5/29.
 * 错误处理
 */
@Component("studentValidator")
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "name", "required.name", "Field name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "age", "required.age", "Field age is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "sex", "required.sex", "Field sex is required.");
    }
}

package com.prince.validator.annotation.parser;

import com.prince.validator.annotation.RegexFormat;

import java.lang.reflect.Field;

/**
 * Created by sky on 17-7-10.
 */
public class RegexFormatParser implements IAnnotationParser {
    @Override
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if (f.isAnnotationPresent(RegexFormat.class)) {
            RegexFormat regexFormat = f.getAnnotation(RegexFormat.class);
            String regex = regexFormat.regex();
            if (null != value) {
                if (value.toString().matches(regex)) {
                    return result;
                }
            }
            result.setMessage(new StringBuilder().append("您输入的").append(value).append("不符合").append(regex).append("要求").toString());
        }
        return result;
    }
}

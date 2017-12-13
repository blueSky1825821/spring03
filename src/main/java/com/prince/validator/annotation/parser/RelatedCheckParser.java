package com.prince.validator.annotation.parser;

import com.prince.validator.annotation.RelatedCheck;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * 判断值是否存在注解解析器
 *
 * @author wm
 */
public class RelatedCheckParser implements IAnnotationParser {

    /**
     * 校验f字段的值是否存在value中，value值以 ","分隔  男,女
     *
     * @see RelatedCheckParser
     */
    @Override
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if (f.isAnnotationPresent(RelatedCheck.class)) {
            RelatedCheck relatedCheck = f.getAnnotation(RelatedCheck.class);
            if (value != null) {
                String[] arr = relatedCheck.paramsName().split(",");
                for (int i = 0; i < arr.length; i++) {
                    if (StringUtils.equals(value.toString(), arr[i])) {
                        return result;
                    }
                }
                result.setMessage("您输入的" + relatedCheck.fieldName()  + "不属于：" + relatedCheck.paramsName() + "任何一项");
            }
        }
        return result;
    }
}

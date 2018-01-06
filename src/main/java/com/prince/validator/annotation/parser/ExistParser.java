package com.prince.validator.annotation.parser;

import com.prince.validator.annotation.ExistFormat;
import org.apache.commons.lang.StringUtils;
import java.lang.reflect.Field;

/**
 * 判断值是否存在注解解析器
 *
 * @author wm
 */
public class ExistParser implements IAnnotationParser {

    /**
     * 校验f字段的值是否存在value中，value值以 ","分隔  男,女
     *
     * @see ExistParser
     */
    @Override
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if (f.isAnnotationPresent(ExistFormat.class)) {
            ExistFormat existFormat = f.getAnnotation(ExistFormat.class);
            if (value != null) {
                String[] arr = existFormat.exist().split(",");
                for (String anArr : arr) {
                    if (StringUtils.equals(value.toString(), anArr)) {
                        return result;
                    }
                }
                result.setMessage("您输入的" + existFormat.fieldName()  + "不属于：" + existFormat.exist() + "任何一项");
            }
        }
        return result;
    }
}

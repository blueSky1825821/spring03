package com.baidu.annotation;

import java.lang.annotation.*;

/**
 * 水果名称注解
 * Created by sky on 17-7-5.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

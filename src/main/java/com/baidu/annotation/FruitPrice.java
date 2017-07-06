package com.baidu.annotation;

import java.lang.annotation.*;

/**
 * Created by sky on 17-7-6.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitPrice {
    int price() default 0;
}

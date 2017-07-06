package com.baidu.annotation;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 * Created by sky on 17-7-5.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BLUE, RED, GREEN}

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}

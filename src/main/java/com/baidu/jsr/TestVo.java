package com.baidu.jsr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sky on 17-7-6.
 */
public class TestVo {
    @Size(min=3,max=5,message="{testvo.name}")
    private String name;
    @NotNull(message="{testvo.age}")
    private Integer age;
	/* 省略setter和getter */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

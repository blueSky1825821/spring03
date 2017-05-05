package com.combat1200.oo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by sky on 2017/5/4.
 * toString 简化
 */
public class ToString {
    private String name;
    private String age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ToString(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE).append(name).append(age).append(sex).toString();
    }

    public static void main(String[] args) {
        ToString s = new ToString("w", "22", "1");
        System.out.println(s.toString());
    }
}

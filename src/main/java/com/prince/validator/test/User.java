package com.prince.validator.test;

import com.prince.validator.annotation.DateFormat;
import com.prince.validator.annotation.ExistFormat;
import com.prince.validator.annotation.Less;
import com.prince.validator.annotation.NotBlank;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by sky on 17-7-10.
 */
public class User{
    private Long id;
    @NotBlank(fieldName="姓名")
    private String name;
    @Less(fieldName="年龄", value=100)
    private int age;
    @ExistFormat(fieldName = "性别", exist="男，女")
    private String sex;
    private String phone;
    @DateFormat(fieldName="生日", format="yyyy-MM-dd")
    private String birthday;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

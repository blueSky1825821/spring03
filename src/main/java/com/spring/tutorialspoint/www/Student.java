package com.spring.tutorialspoint.www;

import java.io.Serializable;

/**
 * Created by sky on 2016/12/18.
 */
public class Student implements Serializable{
    private Integer age;
    private String name;
    private String hobby;
    private String password;

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

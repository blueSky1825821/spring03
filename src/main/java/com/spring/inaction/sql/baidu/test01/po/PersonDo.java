package com.spring.inaction.sql.baidu.test01.po;

import java.io.Serializable;

/**
 * Created by sky on 2017/1/23.
 */
public class PersonDo implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int sex;
    private String hobby;

    public PersonDo() {
    }

    public PersonDo(int id, String name, int sex, String hobby) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}

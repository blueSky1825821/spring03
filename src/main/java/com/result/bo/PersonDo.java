package com.result.bo;

import java.io.Serializable;

/**
 * Created by sky on 2017/1/23.
 */
public class PersonDo implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idNo;
    private String name;
    private int sex;
    private String hobby;

    public PersonDo(int idNo, String name, int sex, String hobby) {
        this.idNo = idNo;
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
    }

    public PersonDo() {
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getId() {
        return idNo;
    }

    public void setId(int id) {
        this.idNo = id;
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

    @Override
    public String toString() {
        return "PersonDo{" +
                "idNo=" + idNo +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

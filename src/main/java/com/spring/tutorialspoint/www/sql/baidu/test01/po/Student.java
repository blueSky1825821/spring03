package com.spring.tutorialspoint.www.sql.baidu.test01.po;

import java.io.Serializable;

/**
 * Created by sky on 2017/2/6.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -7163004163334815825L;

    private String name;
    private String psw;
    private Boolean enabled;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

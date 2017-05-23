package com.yiibai.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @describe: User
 * @author: Yiibai
 * @version: V1.0
 * @copyright http://www.yiibai.com
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1L;
    private int id;
    private String username;
    private String mobile;
    private Date birthday;
    private List<String> extend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public List<String> getExtend() {
        return extend;
    }

    public void setExtend(List<String> extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(id).append(username).append(mobile).append(birthday).append(extend).toString();
    }
}

package com.baidu.jsr;



import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by sky on 17-7-6.
 */
public class User implements Serializable{
    @NotEmpty(message = "{user.id}")
    private Long id;

    @NotEmpty(message = "{user.name}")
    @Length(min = 5, max = 20)
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "${user.name.illegal}")
    private String name;

    @NotNull(message = "{user.password.null}")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

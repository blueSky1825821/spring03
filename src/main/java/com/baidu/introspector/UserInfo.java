package com.baidu.introspector;

/**
 * Created by sky on 17-7-5.
 * 内省(Introspector) 是Java 语言对 JavaBean 类属性、事件的一种缺省处理方法。
 * 　　JavaBean是一种特殊的类，主要用于传递数据信息，
 * 这种类中的方法主要用于访问私有的字段，且方法名符合某种命名规则。
 * 如果在两个模块之间传递信息，可以将信息封装进JavaBean中，这种对象称为“值对象”(Value Object)，或“VO”。
 * 方法比较少。这些信息储存在类的私有变量中，通过set()、get()获得。
 * <p>
 * Java JDK中提供了一套 API 用来访问某个属性的 getter/setter 方法，这就是内省。
 */
public class UserInfo {
    private long userId;
    private String userName;
    private int age;
    private String emailAddress;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

/**
 * @Title: Student.java
 * @Package com.gc.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author rocky
 * @date 2016年6月28日 下午4:10:27
 */
package com.gc.action;

import java.util.Objects;

/**
 * @ClassName: Student
 * @Description: TODO(作用:)
 * @author rocky
 * @date 2016年6月28日 下午4:10:27
 */
public class Student {
    private String name;
    private String age;
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}

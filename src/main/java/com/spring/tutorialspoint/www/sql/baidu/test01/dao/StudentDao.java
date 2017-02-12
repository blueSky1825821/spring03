package com.spring.tutorialspoint.www.sql.baidu.test01.dao;

import com.spring.tutorialspoint.www.sql.baidu.test01.po.Student;

/**
 * Created by sky on 2017/2/6.
 */
public interface StudentDao {
    Student getStudent(String name);
}

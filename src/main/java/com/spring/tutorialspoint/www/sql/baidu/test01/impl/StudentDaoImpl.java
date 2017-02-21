package com.spring.tutorialspoint.www.sql.baidu.test01.impl;

import com.spring.tutorialspoint.www.sql.baidu.test01.dao.StudentDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.Student;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 2017/2/6.
 */
public class StudentDaoImpl extends SqlMapClientDaoSupport implements StudentDao {

    @Override
    public Student getStudent(String name) {
        try{
            return (Student)getSqlMapClientTemplate().queryForObject(getClass().getName() + ".queryStudentById", name);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

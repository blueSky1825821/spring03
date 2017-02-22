package com.spring.tutorialspoint.impl;

import com.spring.tutorialspoint.dao.StudentDao;
import com.spring.tutorialspoint.po.Student;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

/**
 * Created by sky on 2017/2/6.
 */
public class StudentDaoImpl extends SqlMapClientDaoSupport implements StudentDao {

    @Override
    public Student getStudent(String name) {
        try{
            return (Student)getSqlMapClientTemplate().queryForObject(getClass().getName() + ".queryStudentByName", name);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertStudent(Student student) {
        try {
            getSqlMapClientTemplate().insert(getClass().getName() + ".insertStudent", student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student queryStudentByName(String name) {
        try {
            return (Student) getSqlMapClientTemplate().queryForObject(getClass().getName() + ".queryStudentByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> queryStudentList(Student student) {
        try {
            return (List<Student>) getSqlMapClientTemplate().queryForList(getClass().getName() + ".queryStudentList", student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

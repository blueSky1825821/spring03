package com.spring.tutorialspoint.www.sql.baidu.test01.dao;

import com.spring.tutorialspoint.www.sql.baidu.test01.po.Student;

import java.util.List;

/**
 * Created by sky on 2017/2/6.
 */
public interface StudentDao {
    Student getStudent(String name);
    boolean insertStudent(Student student);   //添加
    Student queryStudentByName(String name);   //添加
    //    public boolean deleteById(int id);            //删除
//    public boolean updatePerson(PersonDo personDo);    //修改
//    public PersonDo queryById(int id);              //根据ID查询
    List<Student> queryStudentList(Student student);         //查询全部
}

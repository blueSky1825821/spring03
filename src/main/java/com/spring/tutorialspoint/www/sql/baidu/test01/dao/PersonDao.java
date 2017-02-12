package com.spring.tutorialspoint.www.sql.baidu.test01.dao;

import com.spring.tutorialspoint.www.sql.baidu.test01.po.PersonDo;

import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public interface PersonDao {
    boolean insertPerson(PersonDo personDo);   //添加
    PersonDo queryPersonByName(String name);   //添加
//    public boolean deleteById(int id);            //删除
//    public boolean updatePerson(PersonDo personDo);    //修改
//    public PersonDo queryById(int id);              //根据ID查询
    List<PersonDo> queryPersonList(PersonDo personDo);         //查询全部
}

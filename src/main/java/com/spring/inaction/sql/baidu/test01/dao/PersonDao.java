package com.spring.inaction.sql.baidu.test01.dao;

import com.spring.inaction.sql.baidu.test01.po.PersonDo;

import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public interface PersonDao {
    public boolean insertPerson(PersonDo personDo);   //添加
    public boolean deleteById(int id);            //删除
    public boolean updatePerson(PersonDo personDo);    //修改
    public PersonDo queryById(int id);              //根据ID查询
    public List<PersonDo> queryPerson(PersonDo personDo);         //查询全部
}

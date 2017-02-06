package com.spring.inaction.sql.baidu.test01.dao.impl;

import com.spring.inaction.sql.baidu.test01.dao.PersonDao;
import com.spring.inaction.sql.baidu.test01.po.PersonDo;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public class PersonDaoImpl extends SqlMapClientDaoSupport implements PersonDao {
    @Override
    public boolean insertPerson(PersonDo personDo) {
        getSqlMapClientTemplate().insert(getClass().getName() + "insertPerson", personDo);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        getSqlMapClientTemplate().delete("deleteById", id);
        return false;
    }

    @Override
    public boolean updatePerson(PersonDo personDo) {
        return false;
    }

    @Override
    public PersonDo queryById(int id) {
        return null;
    }

    @Override
    public List<PersonDo> queryPerson(PersonDo personDo) {
        List<PersonDo> persons = getSqlMapClientTemplate().queryForList(getClass().getName() + ".queryPerson", personDo);
        return persons;
    }
}

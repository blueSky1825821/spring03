package com.spring.tutorialspoint.impl;

import com.spring.tutorialspoint.dao.PersonDao;
import com.spring.tutorialspoint.po.PersonDo;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public class PersonDaoImpl extends SqlMapClientDaoSupport implements PersonDao, Serializable {

    @Override
    public boolean insertPerson(PersonDo personDo) {
        try {
            getSqlMapClientTemplate().insert(getClass().getName() + ".insertPerson", personDo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PersonDo queryPersonByName(String name) {
        try {
            return (PersonDo) getSqlMapClientTemplate().queryForObject(getClass().getName() + ".queryPersonByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PersonDo> queryPersonList(PersonDo personDo) {
        try {
            return (List<PersonDo>) getSqlMapClientTemplate().queryForList(getClass().getName() + ".queryPersonList", personDo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

/*    @Override
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
        List<PersonDo> persons = getSqlMapClientTemplate().queryForList("queryPerson", personDo);
        return persons;
    }

    public void setSqlMapTransactionTemplate(TransactionTemplate sqlMapTransactionTemplate) {
        this.sqlMapTransactionTemplate = sqlMapTransactionTemplate;
    }

    public TransactionTemplate getSqlMapTransactionTemplate() {
        return sqlMapTransactionTemplate;
    }*/

}

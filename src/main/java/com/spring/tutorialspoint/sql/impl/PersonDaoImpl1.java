package com.spring.tutorialspoint.sql.impl;




import com.spring.tutorialspoint.www.sql.baidu.test01.dao.PersonDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.PersonDo;

import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */

public class PersonDaoImpl1 extends TemplateDaoImpl<PersonDo> implements PersonDao {

    @Override
    public boolean insertPerson(PersonDo personDo) {
        try {
            insert(getClass().getName() + ".insertPerson", personDo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PersonDo queryPersonByName(String name) {
        try {
            return (PersonDo) queryForObject(getClass().getName() + ".queryPersonByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PersonDo> queryPersonList(PersonDo personDo) {
        try {
            return (List<PersonDo>) queryForList(getClass().getName() + ".queryPersonList", personDo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

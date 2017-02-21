package com.spring.tutorialspoint.sql.manager.impls;

import com.spring.tutorialspoint.sql.dao.TemplateDao;
import com.spring.tutorialspoint.sql.manager.PersonManager;
import com.spring.tutorialspoint.www.sql.baidu.test01.dao.PersonDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/2/14.
 */
@Service
public class PersonManagerImpl extends TemplateManagerImpl<PersonDo> implements PersonManager {

//    @Autowired
//    PersonDao personDao;

    @Override
    public List personQuery(Map query) {
        return null;
    }

    @Override
    public boolean personAdd(Map query) {
        return false;
    }

    @Override
    public Integer personCount(Map query) {
        return null;
    }

    @Override
    public Date getLastUpdateTime(Long id) {
        return null;
    }

    @Override
    public Date getLastWarningTime(Long id) {
        return null;
    }

    @Override
    public TemplateDao<PersonDo> getDao() {
        return null;
    }
}

package com.spring.tutorialspoint.manager.impls;

import com.spring.tutorialspoint.dao.TemplateDao;
import com.spring.tutorialspoint.manager.PersonManager;
import com.spring.tutorialspoint.po.PersonDo;
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

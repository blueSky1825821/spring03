package com.spring.tutorialspoint.manager;


import com.spring.tutorialspoint.po.PersonDo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wm on 16-1-12.
 */
public interface PersonManager extends TemplateManager<PersonDo> {


    public List personQuery(Map query);


    public boolean personAdd(Map query);


    public Integer personCount(Map query);


    Date getLastUpdateTime(Long id);

    Date getLastWarningTime(Long id);


}

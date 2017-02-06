package com.spring.inaction.sql.baidu.test01.test;

import com.spring.inaction.sql.baidu.test01.dao.PersonDao;
import com.spring.inaction.sql.baidu.test01.dao.impl.PersonDaoImpl;
import com.spring.inaction.sql.baidu.test01.po.PersonDo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public class ActionImplTest {
    @Autowired
    PersonDao personDao;

    //查询全部
    @Test
    public void testQueryAllPerson(){
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
        PersonDaoImpl s = (PersonDaoImpl)context.getBean("personDAO");
        PersonDo personDo = new PersonDo();
        List<PersonDo> persons = s.queryPerson(personDo);
        //System.out.println(persons.size());
        Iterator<PersonDo> ite = persons.iterator();
        while(ite.hasNext()){
            personDo = ite.next();
            System.out.print("ID: "+personDo.getId());
            System.out.print(" Name: "+personDo.getName());
            System.out.print(" Sex: "+personDo.getSex());
            System.out.print(" Hobby: "+personDo.getHobby());
            System.out.println();
        }
    }

    @Test
    public void testQueryPerson(){
        PersonDo personDo = new PersonDo();
        personDo.setId(1);
        List<PersonDo> persons = personDao.queryPerson(personDo);
        //System.out.println(persons.size());
        Iterator<PersonDo> ite = persons.iterator();
        while(ite.hasNext()){
            personDo = ite.next();
            System.out.print("ID: "+personDo.getId());
            System.out.print(" Name: "+personDo.getName());
            System.out.print(" Sex: "+personDo.getSex());
            System.out.print(" Hobby: "+personDo.getHobby());
            System.out.println();
        }
    }

    @Test
    public void testInsertPerson(){
        PersonDo personDo = new PersonDo();
        personDo.setId(2);
        personDo.setName("wang");
        personDo.setSex(1);
        personDo.setHobby("play");
        Boolean p = personDao.insertPerson(personDo);
        System.out.println(p.toString());
    }
}

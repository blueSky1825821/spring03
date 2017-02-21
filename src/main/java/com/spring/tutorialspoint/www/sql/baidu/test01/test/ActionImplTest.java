package com.spring.tutorialspoint.www.sql.baidu.test01.test;

import com.spring.tutorialspoint.www.sql.baidu.test01.dao.PersonDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.dao.StudentDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.PersonDo;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sky on 2017/1/23.
 */
public class ActionImplTest extends ImplTest{
    @Autowired
    PersonDao personDao;


    //查询全部
    @Test
    public void testQueryPersonByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
        PersonDao s = (PersonDao) context.getBean("personDAO");
        PersonDo o = null;
        if (null != s) {
            o = s.queryPersonByName("wangmin");

        } else {
            System.out.println("注入失败！！！");
        }
//        PersonDo personDo = new PersonDo();
//        personDo.setId(2);
//        personDo.setSex(1);
//        personDo.setName("2");
//        personDo.setHobby("s");
        System.out.println(o.toString());

    }

    @Test
    public void testQueryPersonList() {
        PersonDo personDo = new PersonDo();
        personDo.setSex(1);
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
        PersonDao personDao1 = (PersonDao) context.getBean("personDAO");
        List<PersonDo> persons = personDao1.queryPersonList(personDo);
        Iterator<PersonDo> ite = persons.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
//        while(ite.hasNext()){
//            personDo = ite.next();
//            System.out.print("ID: "+personDo.getId());
//            System.out.print(" Name: "+personDo.getName());
//            System.out.print(" Sex: "+personDo.getSex());
//            System.out.print(" Hobby: "+personDo.getHobby());
//            System.out.println();
//        }
    }

    @Test
    public void testInsertPerson() {
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
        PersonDao personDao1 = (PersonDao) context.getBean("personDAO");
        PersonDo personDo = new PersonDo();
        personDo.setIdNo(3);
        personDo.setName("wang");
        personDo.setSex(1);
        personDo.setHobby("study");
        Boolean p = personDao1.insertPerson(personDo);
        System.out.println(p.toString());
    }

    @Test
    public void testInsertPerson1() {
        PersonDo personDo = new PersonDo();
        personDo.setIdNo(3);
        personDo.setName("wang");
        personDo.setSex(1);
        personDo.setHobby("study");
        Boolean p = personDao.insertPerson(personDo);
        System.out.println(p.toString());
    }

    @Test
    public void testStudent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        if (null != studentDao) {
            Student student = studentDao.getStudent("ph");
            if (null != student) {
                System.out.println("== 学生名字：" + student.getName() + ",学生密码：" + student.getPsw());
            } else {
                System.out.println("== 没有该学生信息！");
            }
        } else {
            System.out.println("== StudentDao注入失败！");
        }
    }

    @Test
    public void testMysql() {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url = "jdbc:mysql://localhost:3306/mytest";    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, "root", "yuantu123");
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            String sql = "select * from person";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("编号" + "\t" + "姓名" + "\t" + "年龄");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void te() {
    }
}

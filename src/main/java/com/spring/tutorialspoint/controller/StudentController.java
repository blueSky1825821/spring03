package com.spring.tutorialspoint.controller;

import com.spring.tutorialspoint.dao.PersonDao;
import com.spring.tutorialspoint.dao.StudentDao;
import com.spring.tutorialspoint.exception.SpringException;
import com.spring.tutorialspoint.po.PersonDo;
import com.spring.tutorialspoint.po.Student;
import com.utils.FileUtilsUp;
import com.utils.StringUtilsUp;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sky on 2016/12/18.
 */
@Controller
public class StudentController {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private StudentDao studentDao;

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest httpServletRequest;

    static Logger log = Logger.getLogger(StudentController.class.getName());

    @RequestMapping(value = "/test.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public void test() {
        PersonDo p = personDao.queryPersonByName("wangmin");
        System.out.println(p);
    }

    @RequestMapping(value = "/student.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }

    @RequestMapping(value = "/registerRetStudent.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(@ModelAttribute("student") Student student,
                           ModelMap model) {
        if (student.getName().length() < 2) {
            throw new SpringException("Given name is too short, 填写真实姓名呢！");
        } else {
            model.addAttribute("name", student.getName());
        }
        if (Integer.valueOf(student.getAge()) < 10) {
            throw new SpringException("Given age is too low, 未成年人可不能填写！");
        } else {
            model.addAttribute("age", student.getAge());
        }
        if (student.getHobby().length() < 5) {
            throw new SpringException("Given hobby is too short, 得认真填写！");
        } else {
            model.addAttribute("hobby", student.getHobby());
        }
        if (student.getPassword().length() < 6) {
            throw new SpringException("Given password is too short, at least 6！");
        } else {
            model.addAttribute("password", student.getPassword());
        }
        model.addAttribute("phone", student.getPhone());
        model.addAttribute("sex", student.getSex());
        if (studentDao.insertStudent(student)) {
            model.addAttribute("message", "注册成功！");
            return "result";
        } else {
            throw new SpringException("注册失败，请重新注册！");
        }
    }

    @RequestMapping(value = "/loginStudent.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loginStudent() {
        return new ModelAndView("student1", "command", new Student());
    }

    @RequestMapping(value = "/loginRetStudent.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@ModelAttribute("student1") Student student,
                        ModelMap model) {
        if (StringUtilsUp.isBlank(student.getName(), student.getPassword())) {
            throw new SpringException("用户名密码必须填写");
        }
        List<Student> list = studentDao.queryStudentList(student);
        if (list.isEmpty()) {
            throw new SpringException("查询不到用户信息, 请注册");
        }
        Student student1 = list.get(0);
        model.addAttribute("name", student1.getName());
        model.addAttribute("age", student1.getAge());
        model.addAttribute("phone", student1.getPhone());
        model.addAttribute("hobby", student1.getHobby());
        model.addAttribute("url", student1.getUrl());

        return "result";
    }

}

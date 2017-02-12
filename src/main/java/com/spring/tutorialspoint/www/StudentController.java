package com.spring.tutorialspoint.www;

import com.spring.tutorialspoint.www.sql.baidu.test01.dao.PersonDao;
import com.spring.tutorialspoint.www.sql.baidu.test01.po.PersonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sky on 2016/12/18.
 */
@Controller
public class StudentController {
//    @Autowired
//    private PersonDao personDao;

    @RequestMapping(value = "/student.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }

    @RequestMapping(value = "/registerStudent.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryStudent(@ModelAttribute("student") Student student,
                             ModelMap model) {
//        PersonDo s = personDao.queryPersonByName("wang");
//        System.out.println(s.toString());
        if (student.getName().length() < 2) {
            throw new SpringException("Given name is too short, 填写真实姓名呢！");
        } else {
            model.addAttribute("name", student.getName());
        }
        if (student.getAge() < 10) {
            throw new SpringException("Given age is too low, 未成年人可不能填写！");
        } else {
            model.addAttribute("age", student.getAge());
        }
        if (student.getHobby().length() < 5) {
            throw new SpringException("Given hobby is too short, 得认真填写！");
        } else {
            model.addAttribute("hobby", student.getHobby());
        }

        return "result";
    }

    @RequestMapping(value = "/loginStudent.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public String addStudent(@ModelAttribute("student") Student student,
                             ModelMap model) {
        if (student.getName().length() < 2) {
            throw new SpringException("Given name is too short, 填写真实姓名呢！");
        } else {
            model.addAttribute("name", student.getName());
        }
        if (student.getAge() < 10) {
            throw new SpringException("Given age is too low, 未成年人可不能填写！");
        } else {
            model.addAttribute("age", student.getAge());
        }
        if (student.getHobby().length() < 5) {
            throw new SpringException("Given hobby is too short, 得认真填写！");
        } else {
            model.addAttribute("hobby", student.getHobby());
        }

        return "result";
    }
}

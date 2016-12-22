package com.gc.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 2016/11/6.
 */
//继承SimpleFormController
@Controller
public class HelloWorldAction1 {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String viewPage;

    //覆写onSubmit
    protected ModelAndView onSubmit(Object command) throws Exception {
        HelloWorld helloWorld = (HelloWorld) command;
        Map model = new HashMap();
        model.put("helloWorld", helloWorld.getMsg());
        //返回依赖注入定义的页面
        return new ModelAndView(getViewPage(), model);
    }

    public String getViewPage() {
        return viewPage;
    }

    public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }


/*    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String helloWorld;
    private String viewPage;
    //实现Controller接口中的handleRequest()方法
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        model.put("helloWorld", getHelloWorld());
        //用来显示页面和页面上的内容
        return new ModelAndView(getViewPage(), model);
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getViewPage() {
        return viewPage;
    }

    //依赖注入要返回的界面
    public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }*/

}

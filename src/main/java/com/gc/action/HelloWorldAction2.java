package com.gc.action;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 2016/11/6.
 */
//继承SimpleFormController
public class HelloWorldAction2 extends MultiActionController {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String viewPage;

    //新增动作
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        String helloWorld = ServletRequestUtils.getRequiredStringParameter(request, "msg");
        Map model = new HashMap();
        model.put("helloWorld", "insert:" + helloWorld);
        return new ModelAndView(getViewPage(), model);
    }
    //修改动作
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        String helloWorld = ServletRequestUtils.getRequiredStringParameter(request, "msg");
        Map model = new HashMap();
        model.put("helloWorld", "update:" + helloWorld);
        return new ModelAndView(getViewPage(), model);
    }
    //删除动作
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        String helloWorld = ServletRequestUtils.getRequiredStringParameter(request, "msg");
        Map model = new HashMap();
        model.put("helloWorld", "delete:" + helloWorld);
        return new ModelAndView(getViewPage(), model);
    }
    public String getViewPage() {
        return viewPage;
    }

    //依赖注入返回页面
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

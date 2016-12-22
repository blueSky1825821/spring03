package com.gc.action;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * 实现 HandlerInterceptor 接口 添加拦截器
 * Created by sky on 2016/12/8.
 */
public class NotLeaveWord1 extends HandlerInterceptorAdapter {
    //通过依赖注入完成
    private int startTime;
    private int endTime;

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    //在执行具体转发前截取
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前时间
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        //假如在8点到17点之间，则转向内网
        if (startTime <= hour && hour < endTime) {
            response.sendRedirect("http://localhost:9000/spring02/index.jsp");
            return false;
        } else {
            return true;
        }
    }
}

package com.gc.action;

import com.gc.impl.TimeBookInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sky on 16-7-5.
 */
public class TimeBookProxy {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private TimeBookInterface timeBookInterface;

    //在该类中针对前面的接口 TimeBookInterface 编程，而不针对具体的类
    public TimeBookProxy(TimeBookInterface timeBookInterface) {
        this.timeBookInterface = timeBookInterface;
    }

    //实际业务处理
    public void doAuditing(String name) {
        logger.log(Level.INFO, name + "开始审核数据");
        timeBookInterface.doAuditing(name);
        logger.log(Level.INFO, name + "审核数据结束");
    }

}

package com.gc.action;

import com.gc.impl.TimeBookInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sky on 16-7-5.
 */
public class TimeBook implements TimeBookInterface {
    Logger logger = Logger.getLogger(this.getClass().getName());

    //审核数据的相关程序
    public void doAuditing(String name) {
        logger.log(Level.INFO, name + "开始审核数据");
        //审核数据的相关程序
        //.......
        logger.log(Level.INFO, name + "审核数据结束");
    }
}

package com.core.program.awt.test01;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sky on 2017/3/29.
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        //所有的Swing组建必须由事件分派线程进行配置，线程将鼠标点击个按键控制转移到用户接口组件
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame simpleFrame = new SimpleFrame();
                //关闭
                simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //可见
                simpleFrame.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFUALT_WIDTH =300;
    private static final int DEFUALT_HEIGHT =200;

    public SimpleFrame() {
        //setBounds(); 重定位组件
        setLocationByPlatform(true);
        setSize(DEFUALT_WIDTH, DEFUALT_HEIGHT);
    }
}

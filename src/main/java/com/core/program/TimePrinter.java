package com.core.program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by sky on 2017/3/28.
 */
public class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone,the time is " +now);
        Toolkit.getDefaultToolkit().beep();
    }
}

package com.core.program;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by sky on 2017/3/28.
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

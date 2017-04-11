package com.core.program.xml;

import com.common.ParamsKeyConstant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sky on 2017/4/9.
 */
public class GridBagTest {
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String fileName = args.length == 0 ? "fontdialog.xml" : args[0];

            }
        });
    }
}

class FrontFrame extends JFrame {
    public FrontFrame(String fileName) {
        setSize(ParamsKeyConstant.DEFUALT_WIDTH, ParamsKeyConstant.DEFUALT_WIDTH);
        setTitle("GridBagTest");


    }

}
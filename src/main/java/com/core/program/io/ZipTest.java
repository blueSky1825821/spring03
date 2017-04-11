package com.core.program.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by sky on 2017/4/4.
 */
public class ZipTest {
    public static void main(String[] args) {

    }
}

class ZipTestFramme extends JFrame {
    public ZipTestFramme() throws HeadlessException {
        setTitle("ZipTest");
        setSize(100, 200);

        //add the menu and the open ande exit menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(""));
                int r = chooser.showOpenDialog(ZipTestFramme.this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    String zipName = chooser.getSelectedFile().getPath();
                }
            }
        });
    }
}
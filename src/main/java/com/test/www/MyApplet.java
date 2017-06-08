package com.test.www;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sky on 2017/5/31.
 */
public class MyApplet extends JApplet {

    private JLabel label = new JLabel();

    public void init() {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
    }

    public void start() {
        String firstName = getParameter("firstName");
        String lastName = getParameter("lastName");
        label.setText("Hello " + firstName + " " + lastName);
    }
}

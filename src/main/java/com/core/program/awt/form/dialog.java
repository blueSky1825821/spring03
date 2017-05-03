package com.core.program.awt.form;

import com.utils.StringUtilsUp;

import javax.swing.*;
import java.awt.event.*;

public class dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField firstTextField;
    private JTextField secondTextField;
    private JTextField resultTextField;
    private JComboBox symbolComboBox;
    private JList list1;

    public dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        symbolComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (symbolComboBox.getSelectedIndex() != -1) {
                    if (!StringUtilsUp.checkDigit(firstTextField.getText() + secondTextField.getText())) {
                        JOptionPane.showMessageDialog(null, "输入包含非数字内容！");
                        return;
                    }
                    String data = "" + symbolComboBox.getItemAt
                            (symbolComboBox.getSelectedIndex());
                    if (data.equals("+"))
                        resultTextField.setText("" + (Integer.valueOf(firstTextField.getText()) + Integer.valueOf(secondTextField.getText())));
                    else if (data.equals("-"))
                        resultTextField.setText("" + (Integer.valueOf(firstTextField.getText()) - Integer.valueOf(secondTextField.getText())));
                    else if (data.equals("*"))
                        resultTextField.setText("" + (Integer.valueOf(firstTextField.getText()) * Integer.valueOf(secondTextField.getText())));
                    else if (data.equals("/"))
                        resultTextField.setText("" + (Integer.valueOf(firstTextField.getText()) / Integer.valueOf(secondTextField.getText())));
                }
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dialog dialog = new dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}

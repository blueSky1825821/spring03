package com.combat1200.string;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class CharacterASCII extends JFrame {
    
    private JPanel contentPane;
    private JTextField charInputField;
    private JTextField codeOutputField;
    private JFormattedTextField codeInputField;
    private JTextField charOutputField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CharacterASCII frame = new CharacterASCII();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public CharacterASCII() {
        setTitle("字符串与编码转换");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null,
                "字符串与Unicode转换",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(13, 59,
                17)));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 3, 5, 20));
        
        charInputField = new JTextField();
        panel.add(charInputField);
        charInputField.setColumns(10);
        
        JButton codeButton = new JButton("转换为ASCCII码");
        codeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_codeButton_actionPerformed(e);
            }
        });
        panel.add(codeButton);
        
        codeOutputField = new JTextField();
        codeOutputField.setEditable(false);
        panel.add(codeOutputField);
        codeOutputField.setColumns(10);
        
        codeInputField = new JFormattedTextField(NumberFormat
                .getIntegerInstance());
        panel.add(codeInputField);
        codeInputField.setColumns(10);
        
        JButton charButton = new JButton("\u8F6C\u6362\u4E3A\u5B57\u7B26");
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_charButton_actionPerformed(e);
            }
        });
        panel.add(charButton);
        
        charOutputField = new JTextField();
        charOutputField.setEditable(false);
        panel.add(charOutputField);
        charOutputField.setColumns(10);
    }

    protected void do_codeButton_actionPerformed(ActionEvent e) {
        String text = charInputField.getText();// 获取用户输入的字符串
        char[] charArray = text.toCharArray();// 获取字符串的字符数组
        StringBuilder builder = new StringBuilder();// 创建字符串构建器
        for (char c : charArray) {// 遍历字符数组
            builder.append((int) c + " ");// 连接各字符的编码
        }
        codeOutputField.setText(builder.toString());// 结果输出到文本框
    }

    protected void do_charButton_actionPerformed(ActionEvent e) {
        Number value = (Number) codeInputField.getValue();// 获取用户输入Unicode编码
        long code = value.longValue();// 取输入数字的Long类型值
        charOutputField.setText(((char) code) + "");// 输出编码到文本框
    }
}

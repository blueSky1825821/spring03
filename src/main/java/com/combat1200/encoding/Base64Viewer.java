package com.combat1200.encoding;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sky on 2017/5/23.
 * Base64加密 数据量增加最小
 */
public class Base64Viewer extends JFrame {
    private static final long serialVersionUID = -2686990740589101209L;
    private JPanel contentPane;
    private JTextArea message1TextArea;
    private JTextArea message2TextArea;

    public static void main(String[] args) {
        String s = DigestUtils.md5Hex("123456");
        System.out.println("加密" + s);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Base64Viewer frame = new Base64Viewer();
                frame.setVisible(true);
            }
        });
    }

    public Base64Viewer() {
        setTitle("Base64查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 175);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        JButton button = new JButton("加密");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        buttonPanel.add(button);

        JPanel messagePanel = new JPanel();
        contentPane.add(messagePanel, BorderLayout.CENTER);
        messagePanel.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel message1Panel = new JPanel();
        messagePanel.add(message1Panel);
        message1Panel.setLayout(new BorderLayout(0, 0));

        JLabel message1Lable = new JLabel("未加密的字符串");
        message1Lable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        message1Lable.setHorizontalAlignment(SwingConstants.CENTER);
        message1Panel.add(message1Lable, BorderLayout.NORTH);

        message1TextArea = new JTextArea();
        message1TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        message1Panel.add(message1TextArea, BorderLayout.CENTER);

        JPanel message2Panel = new JPanel();
        messagePanel.add(message2Panel);
        message2Panel.setLayout(new BorderLayout(0, 0));

        JLabel message2Lable = new JLabel("已加密的字符串");
        message2Lable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        message2Lable.setHorizontalAlignment(SwingConstants.CENTER);
        message2Panel.add(message2Lable, BorderLayout.NORTH);

        message2TextArea = new JTextArea();
        message2TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        message2Panel.add(message2TextArea, BorderLayout.CENTER);

    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String sourceString = message1TextArea.getText();   //编码的字符串
        if (0 == sourceString.length()) {
            JOptionPane.showConfirmDialog(this, "请输入要编码的字符串", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Base64 base64 = new Base64();
        byte[] encodeBytes = base64.encode(sourceString.getBytes());
        message2TextArea.setText(new String(encodeBytes));
    }

}

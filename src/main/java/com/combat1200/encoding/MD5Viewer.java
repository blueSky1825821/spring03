package com.combat1200.encoding;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by sky on 2017/5/23.
 * MD5加密
 */
public class MD5Viewer extends JFrame {
    private static final long serialVersionUID = 8722656519909578699L;
    private JPanel contentPane;
    private JTextField textField;
    private String md5;
    private JLabel messageLabel;

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
                MD5Viewer frame = new MD5Viewer();
                frame.setVisible(true);
            }
        });
    }

    public MD5Viewer() {
        setTitle("MD5查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 175);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel filePanel = new JPanel();
        contentPane.add(filePanel);

        JLabel fileLable = new JLabel("选择文件");
        fileLable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        filePanel.add(fileLable);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        filePanel.add(textField);
        textField.setColumns(10);

        JButton fileButton = new JButton("打开文件");
        fileButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_fileButton_actionPerformed(e);
            }
        });
        filePanel.add(fileButton);

        JPanel messagePanel = new JPanel();
        contentPane.add(messagePanel);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        messagePanel.add(messageLabel);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);

        JButton md5Button = new JButton("md5加密");
        md5Button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        md5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_md5Button_actionPerformed(e);
            }
        });
        buttonPanel.add(md5Button);
    }

    protected void do_fileButton_actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //让文件选择器只能选择文件
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fileChooser.getSelectedFile();
            textField.setText(selectFile.getName());
            InputStream fis = null;
            try {
                fis = new FileInputStream(selectFile);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                md5 = DigestUtils.md5Hex(fis);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    protected void do_md5Button_actionPerformed(ActionEvent e) {
        if (null == md5) {
            JOptionPane.showConfirmDialog(this, "请选择要计算的文件", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        messageLabel.setText(md5);
    }
}

package com.combat1200.enumandgenericity.enum0;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by sky on 2017/5/20.
 * 简单的文件合并工具
 */
public class FileConcatenation extends JFrame {
    private static final long serialVersionUID = 5592010207848128980L;
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTable table;
    private int id;
    private List<FileInputStream> files = new ArrayList<>();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FileConcatenation frame = new FileConcatenation();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * create the frame
     */
    public FileConcatenation() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("文件合并工具");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);

        JLabel label = new JLabel("新文件的绝对路径");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        choosePanel.add(label);

        pathTextField = new JTextField();
        pathTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        choosePanel.add(pathTextField);
        pathTextField.setColumns(10);

        //增加文件按钮
        JButton chooseButton = new JButton("增加文件");
        chooseButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_chooseButton_actionPerformed(e);
            }
        });
        choosePanel.add(chooseButton);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        //合并文件
        JButton concatButton = new JButton("合并文件");
        concatButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        concatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_concatButton_actionPerformed(e);
            }
        });
        buttonPanel.add(concatButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }

    /**
     * 选择要合并的文件
     *
     * @param e
     */
    protected void do_chooseButton_actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();  //创建文件选择器
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                files.add(new FileInputStream(file));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            //获取表格模型
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{++id, file.getName()});   //添加文件信息到模型
        }
    }

    /**
     * 合并文件
     *
     * @param e
     */
    protected void do_concatButton_actionPerformed(ActionEvent e) {
        String fileName = pathTextField.getText();  //获得用户输入的新文件的绝对路径
        if (0 == fileName.length()) {
            JOptionPane.showMessageDialog(this, "请输入新文件的绝对路径", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (0 == files.size()) {
            JOptionPane.showMessageDialog(this, "请选择要合并的文件", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(files));
        BufferedInputStream bis = new BufferedInputStream(sis, 8 * 1024);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            int length = 0;
            while (-1 != (length = bis.read())) {
                fos.write(length);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (null == fos) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        JOptionPane.showMessageDialog(this, "合并文件成功！", "", JOptionPane.WARNING_MESSAGE);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[]{"序号", "文件名"});
        table.setModel(model);
    }
}

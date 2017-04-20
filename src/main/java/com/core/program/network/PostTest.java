package com.core.program.network;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sky on 2017/4/11.
 */
public class PostTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PostTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class PostTestFrame extends JFrame {
    private JPanel northPanel;

    public static String doPost(String urlString, Map<String, String> nameValiePairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        boolean first = true;
        for (Map.Entry<String, String> pair : nameValiePairs.entrySet()) {
            if (first) first = false;
            else out.print('&');
            String name = pair.getKey();
            String value = pair.getValue();
            out.print(name);
            out.print('=');
            out.print(URLEncoder.encode(value, "UTF-8"));
        }
        out.close();
        Scanner in;
        StringBuilder response = new StringBuilder();
        try {
            in = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            if (!(connection instanceof HttpURLConnection)) throw e;
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (null == err) throw e;
            in = new Scanner(err);
        }
        while (in.hasNextLine()) {
            response.append(in.nextLine());
            response.append("\n");
        }
        in.close();
        return response.toString();
    }

    public PostTestFrame() {
        setTitle("PostTest");

        northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new GridLayout(0, 2));
        northPanel.add(new JLabel("Host: ", SwingConstants.TRAILING));
        final JTextField hostFiled = new JTextField();
        northPanel.add(hostFiled);
        northPanel.add(new JLabel("Action: ", SwingConstants.TRAILING));
        final JTextField actionField = new JTextField();
        northPanel.add(actionField);
        for (int i = 1; i <= 8; i++) {
            northPanel.add(new JTextField());
        }
        final JTextArea result = new JTextArea(20, 40);
        add(new JScrollPane(result));

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        JButton addButton = new JButton("More");
        southPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                northPanel.add(new JTextField());
                northPanel.add(new JTextField());
                pack();
            }
        });

        JButton getButton = new JButton("Get");
        southPanel.add(getButton);
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                final Map<String, String> post = new HashMap();
                for (int j = 4; j < northPanel.getComponentCount(); j += 2) {
                    String name = ((JTextField) northPanel.getComponent(j)).getText();
                    if (name.length() > 0) {
                        String value = ((JTextField) northPanel.getComponent(j + 1)).getText();
                        post.put(name, value);
                    }
                }

                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            String urlString = hostFiled.getText() + "/" + actionField.getText();
                            result.setText(doPost(urlString, post));
                        } catch (IOException e) {
                            result.setText("" + e);
                        }
                        return null;
                    }
                }.execute();
            }
        });
        pack();

    }
}

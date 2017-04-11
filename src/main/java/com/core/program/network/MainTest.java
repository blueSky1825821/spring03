package com.core.program.network;

import com.common.ParamsKeyConstant;
import com.core.program.awt.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sky on 2017/4/10.
 */
public class MainTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MailTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MailTestFrame extends JFrame {
    private Scanner in;
    private PrintWriter out;
    private JTextField from;
    private JTextField to;
    private JTextField smtpServer;
    private JTextArea message;
    private JTextArea comm;

    public MailTestFrame() {
        setSize(ParamsKeyConstant.DEFUALT_WIDTH, ParamsKeyConstant.DEFUALT_HEIGHT);
        setTitle("MailTest");

        setLayout(new GridBagLayout());

        add(new JLabel("From:"), new GBC(0, 0).setFill(GBC.HORIZONTAL));

        from = new JTextField(20);
        add(from, new GBC(1, 0).setWeight(100, 0));

        add(new JLabel("To:"), new GBC(0, 1).setFill(GBC.HORIZONTAL));

        to = new JTextField(20);
        add(to, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0));

        add(new JLabel("SMTP server:"), new GBC(0, 2).setFill(GBC.HORIZONTAL));

        smtpServer = new JTextField(20);
        add(smtpServer, new GBC(1, 2).setFill(GBC.HORIZONTAL).setWeight(100, 0));

        message = new JTextArea();
        add(new JScrollPane(message), new GBC(0, 3, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));

        comm = new JTextArea();
        add(new JScrollPane(comm), new GBC(0, 4, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, new GBC(0, 5, 2, 1));

        JButton sendButton = new JButton("Send");
        buttonPanel.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws Exception {
                        comm.setText("");
                        sendMail();
                        return null;
                    }
                }.execute();
            }
        });
    }

    public void sendMail() {
        try {
            Socket s = new Socket(smtpServer.getText(), 465);
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();

            in = new Scanner(inStream);
            out = new PrintWriter(outStream, true/*auto flush*/);
            String hostName = InetAddress.getLocalHost().getHostName();
            receive();
            send("HELLO" + hostName);
            receive();
            send("MAIL FROM: <" + from.getText() + ">");
            receive();
            send("RCPT TO:<" + to.getText() + ">");
            receive();
            send("DATA");
            receive();
            send(message.getText());
            send(".");
            receive();
            s.close();
        } catch (Exception e) {
            comm.append("Error: " + e);
        }
    }

    public void send(String s) throws IOException {
        comm.append(s);
        comm.append("\n");
        out.print(s.replace("\n", "\r\n"));
        out.print("\r\n");
        out.flush();
    }

    public void receive() throws IOException {
        String line = in.nextLine();
        comm.append(line);
        comm.append("\n");
    }
}
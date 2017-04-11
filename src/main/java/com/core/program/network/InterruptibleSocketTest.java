package com.core.program.network;

import com.common.ParamsKeyConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by sky on 2017/4/10.
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        JFrame frame = new InterruptibleSocketFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class InterruptibleSocketFrame extends JFrame {
    private Scanner in;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TestServer server;
    private Thread connectThread;
    private JButton interruptbleButton;

    public InterruptibleSocketFrame() {
        setSize(ParamsKeyConstant.DEFUALT_WIDTH, ParamsKeyConstant.DEFUALT_HEIGHT);
        setTitle("InterruptibleSocketFrame");

        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        messages = new JTextArea();
        add(new JScrollPane(messages));

        interruptbleButton = new JButton("Interrupible");
        blockingButton = new JButton("Blocking");

        northPanel.add(interruptbleButton);
        northPanel.add(blockingButton);

        interruptbleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptbleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectInterruptibly();
                        } catch (IOException e) {
                            messages.append("InterruptibleSocketTest.connectInterruptibly: " + e);
                        }
                    }
                });
                connectThread.start();
            }
        });

        blockingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptbleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectBlocking();
                        } catch (IOException e) {
                            messages.append("InterruptibleSocketTest.connectBlocking: " + e);
                        }
                    }
                });
                connectThread.start();
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectThread.interrupt();
                cancelButton.setEnabled(false);
            }
        });
        server = new TestServer();
        new Thread(server).start();
    }

    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible: \n");
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
        try {
            in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading \n");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            channel.close();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("Channel closed \n");
                    interruptbleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }

    }

    public void connectBlocking() throws IOException {
        messages.append("Blocking: \n");
        Socket sock = new Socket("localhost", 8189);
        try {
            in = new Scanner(sock.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            sock.close();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("Socket closed \n");
                    interruptbleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    class TestServer implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket s = new ServerSocket(8189);
                while (true) {
                    Socket incoming = s.accept();
                    Runnable r = new TestServerHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }
            } catch (IOException e) {
                messages.append("TestServer.run: " + e);
            }
        }
    }

    class TestServerHandler implements Runnable {
        private Socket incoming;
        private int counter;

        public TestServerHandler(Socket i) {
            incoming = i;
        }

        @Override
        public void run() {
            try {
                OutputStream outStream = incoming.getOutputStream();
                new PrintWriter(outStream, true/*auto flush*/);
                while (counter < 100) {
                    counter++;
                    if (counter <= 10) System.out.println(counter);
                    Thread.sleep(100);
                }
                incoming.close();
                messages.append("Closing server\n");
            } catch (Exception e) {
                messages.append("\nTestServerHandler.run: " + e);
            }
        }
    }
}




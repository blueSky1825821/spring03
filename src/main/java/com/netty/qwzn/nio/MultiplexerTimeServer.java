package com.netty.qwzn.nio;

import com.threadTest.test05.P;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wm on 17-9-29.
 */
public class MultiplexerTimeServer implements Runnable {
    private Selector selector;

    private ServerSocketChannel servChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器，绑定监听端口
     *
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            //1、打开ServerSocketChannel，用于监听客户端的连接，是所有客户端连接的副管道
            servChannel = ServerSocketChannel.open();
            //2、绑定ip，限制最大连接数，设置非阻塞模式
            servChannel.socket().bind(new InetSocketAddress(port), 1024);
            servChannel.configureBlocking(false);
            //3、创建多路复用器
            selector = Selector.open();
            //4、将ServerSocketChannel 注册到Selector，监听ACCEPT
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                //设置轮训时间间隔
                selector.select(1000);
                //5、轮训准备就绪的Key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        //多路复用器关闭后，所有注册在上面的Channel和Pipe等都会被自动去注册并关闭，所以不需要重复释放资源
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        //6、多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路
        if (key.isValid()) {
            //处理新接入的请求消息
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                //7、设置非阻塞模式
                sc.configureBlocking(false);
                //Add the new connection to the selector
                //8、将新接入的客户端连接注册到多路复用器上，监听读操作，读取客户端发送的网络消息
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                //Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                //9、异步读取客户端请求消息到缓冲区
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    //10、编码
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order: " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "RAD ORDER";
                    //11、发送给客户端
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                } else
                    ;   //读到0字节，忽略
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}

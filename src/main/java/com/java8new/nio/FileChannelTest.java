package com.java8new.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wm on 17-8-27.
 */
public class FileChannelTest {
    private static int InitCapacity = 1024;

    public static void main(String[] args) {
        getByteByChannel("/media/play/upload/tmp/frontgateway-params.log.2017-09-13");
        method2();
    }

    public static void getByteByChannel(String src) {
        try {
            long start = System.currentTimeMillis();
            RandomAccessFile aFile = new RandomAccessFile(src, "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(InitCapacity);
            int bytesRead = inChannel.read(buf);
            while (-1 != bytesRead) {
//                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
//                    System.out.println((char) buf.get());
                    buf.get();
                }
                buf.clear();
//                buf.compact();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() {
        long start = System.currentTimeMillis();
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("/media/play/upload/tmp/frontgateway-params.log.2017-09-13"));

            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
//                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                long end = System.currentTimeMillis();
                System.out.println(end - start);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

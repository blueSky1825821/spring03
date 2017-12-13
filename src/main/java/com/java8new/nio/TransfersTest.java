package com.java8new.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by wm on 17-8-27.
 */
public class TransfersTest {
    public static void main(String[] args) {
        transfersFrom("/media/play/upload/tmp/1.txt", "/media/play/upload/tmp/2.txt");
        transfersTo("/media/play/upload/tmp/1.txt", "/media/play/upload/tmp/3.txt");
    }

    private static void transfersFrom(String src, String dest) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(src, "rw");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile(dest, "rw");
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long size = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transfersTo(String src, String dest) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(src, "rw");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile(dest, "rw");
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long size = fromChannel.size();
            fromChannel.transferTo(position, size, toChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

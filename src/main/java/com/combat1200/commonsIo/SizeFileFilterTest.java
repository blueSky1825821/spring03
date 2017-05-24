package com.combat1200.commonsIo;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.SizeFileFilter;

import java.io.File;

/**
 * Created by sky on 2017/5/23.
 * 文件过滤操作
 */
public class SizeFileFilterTest {
    public static void main(String[] args) {
        File dir = new File("/");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName() + "大小是：" + file.length());
        }
        System.out.println("过滤后");
        String[] fileNames = dir.list(new SizeFileFilter(1024 * 1024));
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}

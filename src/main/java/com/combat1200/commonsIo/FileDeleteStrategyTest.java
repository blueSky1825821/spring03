package com.combat1200.commonsIo;

import org.apache.commons.io.FileDeleteStrategy;

import java.io.File;
import java.io.IOException;

/**
 * Created by sky on 2017/5/23.
 */
public class FileDeleteStrategyTest {
    public static void main(String[] args) {
        File rootFile = new File("tmp/");
        if (!rootFile.exists()) {
            rootFile.mkdir();
        }
        File[] list = rootFile.listFiles();
        System.out.println("获取所有文件绝对路径");
        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
        FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
        try {
            strategy.delete(new File("tmp"));
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        strategy = FileDeleteStrategy.FORCE;
        try {
            strategy.delete(new File("tmp"));
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

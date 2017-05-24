package com.combat1200.commonsIo;

import com.utils.FileUtilsUp;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sky on 2017/5/23.
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcDir = new File("tmp/01/");
        File destDir = new File("tmp/02");
        List<String> list = new ArrayList<>();
        FileUtilsUp.getFilePath(list, destDir);
        for (String s : list) {
            System.out.println(s);
        }
        try {
            FileUtils.copyDirectory(srcDir, destDir);
            FileUtilsUp.getFilePath(list, srcDir);
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

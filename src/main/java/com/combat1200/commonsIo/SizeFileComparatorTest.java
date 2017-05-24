package com.combat1200.commonsIo;

import org.apache.commons.io.comparator.SizeFileComparator;

import java.io.File;
import java.util.Arrays;

/**
 * Created by sky on 2017/5/23.
 */
public class SizeFileComparatorTest {
    public static void main(String[] args) {
        File rootFile = new File("\\");
        File[] files = rootFile.listFiles();
        for (File file : files) {
            System.out.print(file.getName() + "\t");
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_COMPARATOR);
        for (File file : files) {
            System.out.print(file.getName() + "\t");
        }
        Arrays.sort(files, SizeFileComparator.SIZE_REVERSE);
        for (File file : files) {
            System.out.print(file.getName() + "\t");
        }
    }
}

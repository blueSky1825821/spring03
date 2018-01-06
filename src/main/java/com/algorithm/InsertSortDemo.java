package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by wm on 17-12-31.
 */
public class InsertSortDemo {
    public static int[] data = new int[10];//数据数组

    public static void main(String[] args) {
        int i;//循环变量
        int index;//数组下标变量
        System.out.println("Please input the values you want to sort(Exit for 0)");
        index = 0;//数组下标变量初始值
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        do {
            System.out.println("Data " + index + ":");
            try {
                String myline = br.readLine();
                st = new StringTokenizer(myline);
                data[index] = Integer.parseInt(st.nextToken());//取得输入值
            } catch (IOException e) {
                System.out.println("IO error:" + e);
            }
            index++;
        } while (data[index - 1] != 0);//排序前数据内容
        System.out.println("Before insert sorting:");
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
        insertSort(index - 1);//插入排序
        System.out.println("After insert sorting:");//排序后结果
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
    }

    public static void insertSort(int index) {
        int i, j, k;//循环变量
        int insertNode;//欲插入数据变量
        for (i = 1; i < index; i++) {
            insertNode = data[i];//设定欲插入的数值
            j = i - 1;//找到合适的插入位置
            while (j >= 0 && insertNode < data[j]) {
                data[j + 1] = data[j];
                j--;
                data[j + 1] = insertNode;//将数值插入
                System.out.println("Current sorting result:");
                for (k = 0; k < index; k++) {
                    System.out.println(" " + data[k] + " ");
                }
                System.out.println();
            }
        }
    }
}

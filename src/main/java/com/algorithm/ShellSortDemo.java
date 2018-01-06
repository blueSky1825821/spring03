package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by wm on 17-12-31.
 */
public class ShellSortDemo {
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
        System.out.println("Before shell sorting:");
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
        shellSort(index - 1);//插入排序
        System.out.println("After shell sorting:");//排序后结果
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
    }

    public static void shellSort(int index) {
        int j, k;//循环变量
        int temp;  //暂存标量
        boolean change; //数据是否改变
        int dataLenght;//分割集合的间隔长度
        int pointer;//进行处理的位置
        dataLenght = index / 2;//初始集合间隔长度
        while (dataLenght != 0) {
            for (j = dataLenght; j < index; j++) {
                change = false;
                temp = data[j];//暂存data[j]的值，待交换值时用
                pointer = j - dataLenght;//计算进行处理的位置
                while (temp < data[pointer] && pointer >= 0 && pointer <= index) {
                    data[pointer + dataLenght] = data[pointer];
                    pointer = pointer - dataLenght;//计算下一个欲进行处理的位置
                    change = true;
                    if (pointer < 0 || pointer > index) {
                        break;
                    }
                }
                data[pointer + dataLenght] = temp;//与最后的数值交换
                if (change) {
                    System.out.println("Current sorting result:");
                    for (k = 0; k < index; k++) {
                        System.out.println(" "+ data[k] + " ");
                    }
                    System.out.println();
                }
            }
            dataLenght = dataLenght/2;//计算下次分割的间隔长度
        }
    }
}

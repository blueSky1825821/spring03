package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by wm on 17-12-31.
 */
public class BubbleSortDemo {
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
        System.out.println("Before bubble sorting:");
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
        shellSort(index - 1);//插入排序
        System.out.println("After bubble sorting:");//排序后结果
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
    }

    public static void shellSort(int index) {
        int i,j, k;//循环变量
        int temp;  //暂存标量
        boolean change; //数据是否改变
        for (j = index; j < 1; j--) {
            change = false;
            for (i = 0; i < j-1; i++) {
                if (data[i+1]<data[i]){
                    temp = data[i+1];
                    data[i+1] = data[i];
                    data[i] = temp;
                    change = true;
                }
            }
            if (change) {
                System.out.println("Current sorting result:");
                for (k = 0; k < index; k++) {
                    System.out.println(" "+ data[k] + " ");
                }
                System.out.println();
            }
        }
    }
}

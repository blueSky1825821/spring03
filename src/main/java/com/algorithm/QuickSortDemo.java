package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by wm on 17-12-31.
 */
public class QuickSortDemo {
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
        System.out.println("Before quick sorting:");
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
        quickSort(data);//插入排序
        System.out.println("After quick sorting:");//排序后结果
        for (i = 0; i < index - 1; i++) {
            System.out.println(" " + data[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }

        }
        return 0;
    }
}

package com.combat1200.string;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by sky on 2017/5/3.
 */
public class FormatNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字： ");
        double number = scanner.nextDouble();
        System.out.println("该数字用Local类的以下常量作为格式化对象的构造参数，将获得不同的货币格式： ");
        //创建格式化对象
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        //输出格式化货币格式
        System.out.println("Locale.CHINA: " + format.format(number));

        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH: " + format.format(number));
    }
}

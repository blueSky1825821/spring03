package com.design.pattern.singleton;

/**
 * Created by wm on 17-8-13.
 * 用于观察enum初始化顺序
 */
public enum Car {
    Benz(1), Volks(2);

    private static int t = 123;

    private int value = -1;

    static {
        System.out.println("静态初始化块, t=" + t);
    }

    {
        System.out.println("构造化块，value " + this.value + "=-2");
        //        System.out.println("初始化块，value " + this.value + "= -2, t=" + t);
        this.value = -2;
    }

    private Car(int value) {
        System.out.println("构造方法，value " + this.value + "=" + value);
        //        System.out.println("初始化块，value " + this.value + "= -2, t=" + t);
        this.value = value;
    }

    public static void main(String...args) {
        System.out.println();
    }
}

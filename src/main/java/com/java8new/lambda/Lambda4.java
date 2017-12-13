package com.java8new.lambda;

/**
 * Created by wm on 17-8-20.
 * 访问外部变量
 */
public class Lambda4 {
    static int outerStaticNum;

    int outerNum;

    void testScopes() {
        int num = 1;
        Lambda2.Converter<Integer, String> stringConverter =
                (form) -> String.valueOf(form + num);

        String convert = stringConverter.convert(2);
        System.out.println(convert);

        Lambda2.Converter<Integer, String> stringConverter2 = (form) -> {
            outerNum = 13;
            return String.valueOf(form);
        };

        String[] array = new String[1];
        Lambda2.Converter<Integer, String> stringConverter3 = (form) -> {
            array[0] = "Hi there";
            return String.valueOf(form);
        };

        stringConverter3.convert(23);
        System.out.println(array[0]);
    }

    public static void main(String[] args) {
        new Lambda4().testScopes();
    }
}

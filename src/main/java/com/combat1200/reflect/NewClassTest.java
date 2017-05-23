package com.combat1200.reflect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by sky on 2017/5/19.
 * 动态实例化类
 */
public class NewClassTest {
    public static void main(String[] args) {
        try {
            //获得File类的Constructor对象
            Constructor<File> constructor = File.class.getConstructor(String.class);
            File file = constructor.newInstance("temp.txt");        //相当于new File("temp.txt");
            System.out.println("创建文件：");
            file.createNewFile();
            System.out.println("创建文件夹是否成功：" + file.exists());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

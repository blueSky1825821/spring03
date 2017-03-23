package com.threadTest.pattern.singleton.serialize;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by sky on 2017/3/22.
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = 800L;

    //内部类方式
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    //方法readResolve会在ObjectInputStream已经读取一个对象并在准备返回前调用。
    // ObjectInputStream 会检查对象的class是否定义了readResolve方法。
    // 如果定义了，将由readResolve方法指定返回的对象。
    // 返回对象的类型一定要是兼容的，否则会抛出ClassCastException 。
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了 readResolve方法！");
        return MyObjectHandler.myObject;
    }
}


package com.design.pattern.factory;

/**
 * Created by wm on 18-1-6.
 */
public class Client {
    public static void main(String[] args) {
        //创建需要使用的Ｃreator 对象
        ExportOperate operate = new ExportDBFileOperate();
        //调用输出数据的功能方法
        operate.export("测试数据");
    }
}

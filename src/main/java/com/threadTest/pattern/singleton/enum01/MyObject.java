package com.threadTest.pattern.singleton.enum01;

import java.sql.Connection;

/**
 * Created by sky on 2017/3/22.
 */
public enum MyObject {
    connectionFactory;
    private Connection connection;
    private MyObject() {
        System.out.println("调用了MyObject的构造");
        String url = "jdbc:mysql://localhost:3306/serial";
        String username = "root";
        String password = "";
        String driverName = "com.mysql.cj.jdbc.Driver";
    }

}

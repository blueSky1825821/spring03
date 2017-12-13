package com.design.pattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sky on 2017/3/22.
 * 使用枚举值时都会调用构造函数
 */
public class EnumSingleton {
    public enum MyEnumSingleton {
        connectionFactory;
        private Connection connection;

        private MyEnumSingleton() {
            System.out.println("调用了MyObject的构造");
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
            String username = "root";
            String password = "yuantu123";
            String driverName = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }

    public static Connection getConnection() {
        return MyEnumSingleton.connectionFactory.getConnection();
    }
}

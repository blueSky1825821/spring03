package com.gc.action;

import javax.sql.DataSource;
import java.io.Flushable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sky on 16-7-18.
 */
public class JdbcHelloWorld {

    DataSource dataSource;

    //获取数据源
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void test() {
        Connection conn = null;
        Statement stmt = null;

        try {//获取数据库连接
            dataSource.getConnection();
            //开始启动事务
            //Sets this connection's auto-commit mode to the given state.
            conn.setAutoCommit(false);
            //Creates a Statement object for sending SQL statements to the database.
            conn.createStatement();
            //执行相应的操作
            stmt.executeUpdate("INSERT INTO hello VALUES (1, 'gf', 'HelloWorld')");

            //执行成功则提交事务
            conn.commit();
        } catch (SQLException e1) {
            if (conn != null) {
                try {
                    //执行不成功则回滚
                    conn.rollback();
                } catch (SQLException e2) {
                    System.out.println("数据库连接有异常" + e2);
                }
            }
        } finally {
            //加入stmt不为空，则关闭stmt
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e3) {
                    System.out.println("执行操作有异常" + e3);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e4) {
                    System.out.println("数据连接有异常" + e4);
                }
            }
        }


    }


}

package com.yiibai.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by sky on 2017/5/10.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes(Date.class) //java 类型 描述了哪些Java类型可被拦截。
public class MyDateTypeHandler extends BaseTypeHandler<Date>{
    //重新定义要写往数据库的数据。
    //preparedStatement:执行的SQL语句  i：需要转换的第几个参数 date:数据内容 jdbcType:数据库存入的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(date.getTime()));
    }

    //以下三个方法 从数据库读出的数据类型进行转换。
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new Date(resultSet.getLong(s));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new Date(resultSet.getLong(i));
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}

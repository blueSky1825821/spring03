package com.yiibai.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sky on 2017/5/10.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes(List.class) //java 类型 描述了哪些Java类型可被拦截。
public class MyStringArrayTypeHandler extends BaseTypeHandler<List<String>> {
    private List<String> getStringArray(String columnValue) {
        if (columnValue == null)
            return null;
        return Arrays.asList(columnValue.split(","));
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        //preparedStatement:执行的SQL语句  i：需要转换的第几个参数 date:数据内容 jdbcType:数据库存入的类型
        //重新定义要写往数据库的数据。
        StringBuffer result = new StringBuffer();
        for (String value : strings) {
            result.append(value).append(",");
        }
        preparedStatement.setString(i, result.deleteCharAt(result.length() - 1).toString());
    }

    //以下三个方法 从数据库读出的数据类型进行转换。
    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //由于BaseTypeHandler中已经把parameter为null的情况做了处理，所以这里我们就不用再判断parameter是否为空了，直接用就可以了
        return getStringArray(resultSet.getString(s));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getStringArray(resultSet.getString(i));
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getStringArray(callableStatement.getString(i));
    }
}

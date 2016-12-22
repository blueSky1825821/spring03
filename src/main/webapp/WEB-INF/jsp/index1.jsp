<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/6
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--是否使用EL语法--%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>第一个MVC JSTL实例</title>
</head>
<body>
<H1><c:out value="${helloWorld}"/></H1>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2017/6/1
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting HTTP Status Code</title>
</head>
<body>
<%
    // Set error code and reason.   错误码控制访问页面
    response.sendError(404, "Need authentication!!!" );
%>
</body>
</html>

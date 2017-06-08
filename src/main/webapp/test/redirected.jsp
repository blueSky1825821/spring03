<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2017/6/4
  Time: 8:29
  To change this template use File | Settings | File Templates.
  重定向
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Redirection</title>
</head>
<body>
<div align="center">
    <h1>Page Redirection</h1>
</div>
<%
    // New location to be redirected
    String site = new String("http://www.yiibai.com");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>
</html>

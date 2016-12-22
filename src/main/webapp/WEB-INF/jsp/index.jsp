<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/11/6
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>第一个MVC实例</title>
    <%
        String str = (String) request.getAttribute("helloWorld");
    %>
</head>
<body>
<h1><%=str%>
</h1>
</body>
</html>

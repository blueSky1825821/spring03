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
    <title>第3个MVC实例 数据绑定</title>
    <%
        String str = (String) request.getAttribute("helloWorld");
    %>
</head>
<body>
    <form name="HelloWorld" action="/spring02/helloWorld3.do" method="post">
        您输入的欢迎语是 <input type="text" name="msg" value=""/><br>
        <input type="submit" value="提交">
        <% request.getAttribute("helloWorld"); %><br>
        <p><%=str %>

    </form>
</body>
</html>

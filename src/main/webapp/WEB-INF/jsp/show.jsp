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
    <title>第2个MVC实例</title>
    <%
        String str = (String) request.getAttribute("helloWorld");
    %>
</head>
<body>
    <form name="HelloWorld" action="/spring02/helloWorld1.do" method="post">
        您输入的欢迎语是"${helloWorld}"<br>
        您输入的欢迎语是${helloWorld}
        <% request.getAttribute("helloWorld"); %><br>
        <p><%=str %>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/16
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--使用EL表达式--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<%
    String s = (String) request.getAttribute("message");
    request.setAttribute("s1", s);
%>
    <h2>${message}</h2>
    <h2><%=s%></h2>
    <h2>${s1}</h2>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/8
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>抛送异常页面</title>
</head>
<body>
<%Exception ex = (Exception) request.getAttribute("Exception");%>
<H2>Exception: <%=ex.getMessage()%></H2>
</body>
</html>

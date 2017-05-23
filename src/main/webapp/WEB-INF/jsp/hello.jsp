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
    <style type="text/css">
        body {
            background-color: yellow
        }

        h1 {
            background-color: #00ff00
        }

        h2 {
            background-color: transparent
        }

        p {
            background-color: rgb(250, 0, 255)
        }
    </style>
    <h1><title>Hello World</title></h1>
</head>
<body>
<%
    String s = (String) request.getAttribute("message");
    request.setAttribute("s1", s);
%>
<h2>${message}</h2>
<h2><%=s%>
</h2>
<h2>${s1}</h2>
<h1>这是标题 1</h1>
<h2>这是标题 2</h2>
<p>这是段落</p>
<p class="no2">这个段落设置了内边距。</p>

</body>
</html>

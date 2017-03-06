<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/11/6
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>多个文件、图片上传</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<tr>
    <form name="Form1" action="/spring03/picUpload.do1" method="post" enctype="multipart/form-data">
        <h1>采用multipart提供的file.transfer方法上传文件</h1>
        <p>
            选择文件：<input type="file" name="pics">
        <p>
            选择文件：<input type="file" name="pics">
        <p>
            <input type="submit" value="upload"/>
    </form>

    <img alt="暂无图片" src="${fileUrl}" />
</body>
</html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
遍历List:<br/>
<c:forEach var="item" items="${list}">
    <c:out value="${item}"/><br/>
</c:forEach>

<br>
查看所有缓存：
<br>
<c:out value="${viewCache}"/>
</body>
</html>

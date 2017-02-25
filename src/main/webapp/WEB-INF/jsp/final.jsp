<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring Page Redirection</title>
</head>
<body>

<h2>Redirected Page</h2>

<center>
    遍历数组:
    <c:forEach var="fileName" items="${fileNames}">
        <c:out value="${fileName}" /><br>
    </c:forEach>

</body>
</html>
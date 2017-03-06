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
    遍历数组:<br/>
    <c:forEach var="fileName" items="${fileNames}">
        <c:out value="${fileName}"/><br>
    </c:forEach>

    <br/>
    遍历List:<br/>
    <c:forEach var="picName" items="${picsNameList}">
        <c:out value="${picName}"/><br/>
    </c:forEach>

    <br/>
    遍历Map集合<br/>
    <c:forEach var="me" items="${picsNameMap}">
        <c:url value="/downFile.do1" var="picsPath">
            <c:param name="picsPathName" value="${picsPath}"></c:param>
        </c:url>
        ${me.value}<a href="${picsPath}${me.key}">下载</a><img src="${picsPath}${me.key}"><br/>
    </c:forEach>
</center>
</body>
</html>
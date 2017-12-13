<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 17-7-6
  Time: 下午2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:if test="${msgs!=null && msgs.size()>0}">
    <fmt:message key="${msgs}" />
</c:if>--%>

<spring:hasBindErrors name="user">
    <c:if test="${errors.fieldErrorCount > 0}">
        字段错误：<br/>
        <c:forEach items="${errors.fieldErrors}" var="error">
            <spring:message var="message" code="${error.code}" arguments="${error.arguments}"
                            text="${error.defaultMessage}"/>
            ${error.field}------${message}<br/>

        </c:forEach>
    </c:if>


    <c:if test="${errors.globalErrorCount > 0}">
        全局错误：<br/>
        <c:forEach items="${errors.globalErrors}" var="error">
            <spring:message var="message" code="${error.code}" arguments="${error.arguments}"
                            text="${error.defaultMessage}"/>
            <c:if test="${not empty message}">
                ${message}<br/>
            </c:if>
        </c:forEach>
    </c:if>

<%--    <c:if test="${msgs!=null && msgs.size()>0}">
        <fmt:message key="${msgs}"/>
    </c:if>--%>
</spring:hasBindErrors>

<spring:hasBindErrors name="customer">
    <c:if test="${errors.fieldErrorCount > 0}">
        字段错误：<br/>
        <c:forEach items="${errors.fieldErrors}" var="error">
            <spring:message var="message" code="${error.code}" arguments="${error.arguments}"
                            text="${error.defaultMessage}"/>
            ${error.field}------${message}<br/>

        </c:forEach>
    </c:if>


    <c:if test="${errors.globalErrorCount > 0}">
        全局错误：<br/>
        <c:forEach items="${errors.globalErrors}" var="error">
            <spring:message var="message" code="${error.code}" arguments="${error.arguments}"
                            text="${error.defaultMessage}"/>
            <c:if test="${not empty message}">
                ${message}<br/>
            </c:if>
        </c:forEach>
    </c:if>

    <%--    <c:if test="${msgs!=null && msgs.size()>0}">
            <fmt:message key="${msgs}"/>
        </c:if>--%>
</spring:hasBindErrors>

</body>
</html>

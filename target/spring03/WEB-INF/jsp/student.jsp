<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/18
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Student Information</h2>
<form method="POST" action="/spring02/addStudent.do1" modelAttribute="student">
    <table>
        <tr>
            <td><label path="name">Name</label></td>
            <td><input path="name"/></td>
        </tr>
        <tr>
            <td><label path="age">Age</label></td>
            <td><input path="age"/></td>
        </tr>
        <tr>
            <td><label path="id">id</label></td>
            <td><input path="id"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2017/6/1
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using GET Method to Read Form Data & Setting Cookies</title>
</head>
<body>
<div align="center">
    <h1>Setting Cookies</h1>

    <form action="main.jsp" method="POST">
        First Name: <input type="text" name="first_name">
        <br/>
        Last Name: <input type="text" name="last_name"/>
        <input type="submit" value="Submit"/>
    </form>

    <form action="main.jsp" method="POST" target="_blank">
        <input type="checkbox" name="maths" checked="checked"/> Maths
        <input type="checkbox" name="physics"/> Physics
        <input type="checkbox" name="chemistry" checked="checked"/>
        Chemistry
        <input type="submit" value="Select Subject"/>
    </form>
</div>
</body>
</html>

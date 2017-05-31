<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/18
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>教工系统</title>
    <%--    <style>
            body{
                background-images: url(/photos/christmas.jpg);
                background-repeat: repeat-x;
            }
        </style>--%>

    <style>
        .error {
            color: #ff0000;
        }

        .errorStyle {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

</head>

<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
    <%--<img src="photos/3.jpg" height="100%" width="100%"/>--%>
</div>

<% String url = request.getScheme() + "://" + request.getServerName() + request.getServletPath();%>

<br><br><br>
<center>
    <%--<audio id="media" src="music/IWantYou.mp3" autoplay="true" loop="true" controls>--%>
    <audio id="media" src="music/IWantYou.mp3" autoplay="autoplay" loop="loop" preload="auto" controls>
    </audio>

    <h2>Happy Fairy Information</h2>
    <%--<form:errors path="*" cssClass="errorStyle" element="div"/>--%>
    <form:form method="POST" action="registerRetStudent.do1" commandName="student">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="password">password</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="age">Age</form:label></td>
                <td><form:input path="age"/></td>
                <td><form:errors path="age" cssClass="error"/></td>
                    <%--表单使用密码--%>
            </tr>
            <tr>
                <td><form:label path="sex">sex</form:label></td>
                <td><form:radiobutton path="sex" value="1" label="男"/></td>
                <td><form:radiobutton path="sex" value="2" label="女"/></td>
                <td><form:errors path="sex" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="phone">phone</form:label></td>
                <td><form:input path="phone"/></td>
            </tr>
            <tr>
                <td><form:label path="hobby">hobby</form:label></td>
                <td><form:input path="hobby"/></td>
            </tr>
            <tr>
                <td><form:label path="url">照片URL</form:label></td>
                <td><form:input path="url"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="注册"/>
                    <input type="button" class="button button-primary" value="登陆"
                           onclick="window.open('${pageContext.request.contextPath}/loginStudent.do1')">
                </td>
            </tr>
        </table>
    </form:form>
</center>

<script>

</script>
</body>
</html>

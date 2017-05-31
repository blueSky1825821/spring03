<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2016/12/18
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教工系统</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
    <%--<img src="photos/4.jpg" height="100%" width="100%"/>--%>
</div>
<center>
    <audio id="media" src="music/snowman.mp3" autoplay="autoplay" loop="loop" preload="auto" controls>
    </audio>

    <h1>Happy Fairy Information</h1>
    <br>
    <table>
        <tr>
            <td><h2>提示消息</h2></td>
            <td><h2>${message}</h2></td>
        </tr>
        <tr>
            <td><h2>Name</h2></td>
            <td><h2>${student.name}</h2></td>
        </tr>
        <tr>
            <td><h2>Age</h2></td>
            <td><h2>${student.age}</h2></td>
        </tr>
        <tr>
            <td><h2>SEX</h2></td>
            <td><h2>${(student.sex=="1"? "男" : "女")}</h2></td>
        </tr>
        <tr>
            <td><h2>Hobby</h2></td>
            <td><h2>${student.hobby}</h2></td>
        </tr>
    </table>
    <br>
    <br>
    <h2>${student.name}，您好，欢迎您登陆教工系统！</h2><br>
    <h2>希望您每天能开开心心的！！!</h2>
    <br>
    <h1><font color="red"> Merry Christmas</font></h1>
</center>
</body>
</html>

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
    <title>问卷调查</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
    <img src="photos/4.jpg" height="100%" width="100%"/>
</div>
<center>
    <audio id="media" src="music/snowman.mp3" autoplay="autoplay" loop="loop" preload="auto" controls>
    </audio>

    <h1>Happy Fairy Information</h1>
    <br>
    <table>
        <tr>
            <td><h2>Name</h2></td>
            <td><h2>${name}</h2></td>
        </tr>
        <tr>
            <td><h2>Age</h2></td>
            <td><h2>${age}</h2></td>
        </tr>
        <tr>
            <td><h2>Hobby</h2></td>
            <td><h2>${hobby}</h2></td>
        </tr>
    </table>
    <br>
    <br>
    <h2>${name}，你的兴趣其实是为你做这个的汉子，他为你花了很长的时间，希望你圣诞快乐!</h2>
    <br>
    <h1><font color="red"> Merry Christmas</font></h1>
</center>
</body>
</html>

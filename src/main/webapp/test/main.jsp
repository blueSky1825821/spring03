<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2017/5/31
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Create cookies for first and last names.
    Cookie firstName = new Cookie("first_name",
            request.getParameter("first_name"));
    Cookie lastName = new Cookie("last_name",
            request.getParameter("last_name"));

    // Set expiry date after 24 Hrs for both the cookies.
    firstName.setMaxAge(60 * 60 * 24);
    lastName.setMaxAge(60 * 60 * 24);

    // Add both the cookies in the response header.
    response.addCookie(firstName);
    response.addCookie(lastName);
%>

<html>
<head>
    <title>The include Action Example</title>
    <style>
        #center {
            /*width: 200px;*/
            /*height: 200px;*/
            /*background-color: red;*/

            text-align: center;
        }
    </style>
</head>
<body>
<div id="center">
    <h2>The include action Example</h2>
    <jsp:include page="date.jsp" flush="false"/>
</div>

<%--java bean--%>
<jsp:useBean id="userInfo" class="com.test.www.UserInfo"/>
<jsp:setProperty name="userInfo" property="name" value="wang"/>
<p>Got message...</p>
<jsp:getProperty name="userInfo" property="name"/>

<%--直接跳转--%>
<%--<jsp:forward page="date.jsp" />--%>

<%--plugin动作是用来插入Java组件到一个JSP页面--%>
<div align="center">

    <h1>Using GET Method to Read Form Data</h1>
    <ul>
        <li><p><b>First Name:</b>
            <%= request.getParameter("first_name")%>
        </p></li>
        <li><p><b>Last Name:</b>
            <%= request.getParameter("last_name")%>
        </p></li>
    </ul>

    <h2>Reading Cookies</h2>
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        if (cookies != null) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print("Name : " + cookie.getName() + ",  ");
                out.print("Value: " + cookie.getValue() + " <br/>");
            }
        } else {
            out.println("<h2>No cookies founds</h2>");
        }
    %>

</div>

</body>
</html>
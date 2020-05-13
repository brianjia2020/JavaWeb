<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-02
  Time: 10:17 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    b.jsp页面 <br>
    <%= 12%> <br>
    <%= 12.2 %> <br>
    <%= "I am a String" %> <br>

    <%
        int i = 12;
        if (i == 12 ){
            System.out.println("I am so handsome");
        } else {
            System.out.println("haha");
        }
    %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-16
  Time: 10:56 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% request.setAttribute("key","value");%>

    JSP expression for the value of the key is: <%= request.getAttribute("key")%><br>

    EL expression for the value of the key is: ${key}
</body>
</html>

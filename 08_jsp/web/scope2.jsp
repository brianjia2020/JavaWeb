<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-13
  Time: 7:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is scope2.jsp page</h1>
    whether pageContext has value: <%= pageContext.getAttribute("key")%><br>
    whether request has value: <%= request.getAttribute("key")%><br>
    whether session has value: <%= session.getAttribute("key")%><br>
    whether application has value: <%= application.getAttribute("key")%><br>
</body>
</html>

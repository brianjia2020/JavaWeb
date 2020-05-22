<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-18
  Time: 8:08 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContext1");
        pageContext.setAttribute("key2","pageContext2");
    %>

    ${key1}
</body>
</html>

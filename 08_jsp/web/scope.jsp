<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-13
  Time: 6:51 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is scope.jsp page</h1>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key", "session");
        application.setAttribute("key","application");
    %>
    whether pageContext has value: <%= pageContext.getAttribute("key")%><br>
    whether request has value: <%= request.getAttribute("key")%><br>
    whether session has value: <%= session.getAttribute("key")%><br>
    whether application has value: <%= application.getAttribute("key")%><br>
    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>
</body>
</html>

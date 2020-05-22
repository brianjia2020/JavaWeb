<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-18
  Time: 8:24 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getScheme()%> <br>
    1.page scheme: ${pageContext.request.scheme} <br>
    2.server ip: ${pageContext.request.serverName} <br>
    3.server port: ${pageContext.request.serverPort} <br>
    4.application path: ${pageContext.request.contextPath}<br>
    5.request function: ${pageContext.request.method}<br>
    6.remote ip address: ${pageContext.request.remoteHost}<br>
    7.session id: ${pageContext.session.id}
</body>
</html>

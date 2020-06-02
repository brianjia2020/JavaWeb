<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-23
  Time: 10:17 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- loop over 1 to 10  --%>
    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach>

    <hr>
    <%-- loop over Object array --%>
    <%
        request.setAttribute("arr", new String[]{"2262243815","2893397045"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item} <br>
    </c:forEach>

    <hr>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value1");
        map.put("key3","value1");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        ${entry.key}
        ${entry.value} <br>
    </c:forEach>
</body>
</html>

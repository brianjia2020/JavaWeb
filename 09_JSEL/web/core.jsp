<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-20
  Time: 9:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    before save: ${requestScope.abc}<br>
    <c:set scope="request" var="abc" value="i love you" />
    after save:  ${requestScope.abc}<br>

    <hr>
    <%--
        c:if
            test to for testing the conditions
    --%>
    <c:if test="${12==12}" >
        <h1>12 == 12</h1>
    </c:if>

    <hr>

    <%--
        choose when otherwise
    --%>
    <%
        request.setAttribute("height",190);
    %>
    <c:choose>
        <c:when test="${requestScope.height >= 190}">
            <h1>You are a giant</h1>
        </c:when>
        <c:when test="${requestScope.height >= 180}">
            <h1>You are so tall</h1>
        </c:when>
        <c:when test="${requestScope.height >= 170}">
            <h1>You are so so</h1>
        </c:when>
        <c:otherwise>
            <h1>hmm you are even shorter than 170</h1>
        </c:otherwise>

    </c:choose>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-13
  Time: 9:03 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">99 table</h1>
    <table width="600ps" align="center">
    <%
        for (int i = 0; i <= 9; i++){ %>
        <tr>
            <%
                for (int j = 0; j <= i; j++){
            %>
            <td>
                <%= j+"x" + i + '=' + (i*j) %>
            </td>
        <% } %>
        </tr>
        <% } %>
    </table>
</body>
</html>

<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-14
  Time: 9:54 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("stuList");
    %>
    <table border="1px black solid" width="500">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
            <td>Phone</td>
        </tr>
    <% for(Student student: studentList){ %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
        </tr>
        <% } %>
    </table>


</body>
</html>

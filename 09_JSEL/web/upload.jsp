<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-24
  Time: 10:06 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/09_JSEL/uploadServlet" method="post" enctype="multipart/form-data">
        username: <input type="text" name="username"/><br>
        photo: <input type="file" name="photo"> <br>
        <input type="submit" name="upload">
    </form>
</body>
</html>

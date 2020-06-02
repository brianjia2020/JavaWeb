<%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-27
  Time: 10:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String base_path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                        +request.getContextPath() + "/";
%>
<%=base_path%>
<base href=<%=base_path%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

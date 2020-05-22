<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: bjia
  Date: 2020-05-17
  Time: 9:13 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("Brian Jia");
        person.setPhones(new String[]{"2262243815","2893397045"});
        List<String> cities = new ArrayList<>();
        cities.add("Toronto");
        cities.add("Suzhou");
        cities.add("Xian");
        person.setCities(cities);

        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>

    output the person: ${person};<br>
    output the person'name: ${person.name} <br>
    output the person's phone list: ${person.phones[0]} <br>
    output the person's city list: ${person.cities} <br>
    output the person's city list: ${person.cities[0]} <br>
    output the person's map: ${person.map} <br>
    output the person's map value of key1: ${person.map.key1}

</body>
</html>

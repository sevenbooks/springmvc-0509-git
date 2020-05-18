<%--
  Created by IntelliJ IDEA.
  User: 16097
  Date: 2020/5/8
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>pages.success.jsp</h2>

time : ${requestScope.time}

request user : ${requestScope.user}
session user : ${sessionScope.user}


request school : ${requestScope.school}
session school : ${sessionScope.school}

</body>
</html>

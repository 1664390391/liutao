<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: green">success!</h1>
<h3 style="color: green">requestScope_time:${requestScope.time}</h3>
<h3 style="color: green">sessionScope_time:${sessionScope.time}</h3>
<h3 style="color: green">requestScope_name:${requestScope.name}</h3>
<h3 style="color: green">sessionScope_name:${sessionScope.name}</h3>


<h3 style="color: green"><fmt:message key="i18n.username"></fmt:message></h3>
<h3 style="color: green"><fmt:message key="i18n.password"></fmt:message></h3>
</body>
<script type="text/javascript" src="/WEB-ROOT/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function () {
        alert("hello jquery!");
    })
</script>
</html>

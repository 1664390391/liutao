<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/18
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: green">success!</h1>
<h1> 测试 @SessionAttributes 注解中的属性是否在会话中有效</h1>
<h3 style="color: green">requestScope_time:${requestScope.time}</h3>
<h3 style="color: green">sessionScope_time:${sessionScope.time}</h3>
</body>
</html>

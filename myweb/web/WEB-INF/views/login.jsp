<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>涛哥的index.jsp</title>
  </head>
  <body>

    <form action="modelDemo/testModel" method="post">
      name:<input name="name"><br/>
      age:<input name="age" ><br/>
      province:<input name="address.province" ><br/>
      city:<input name="address.city"><br/>
      <input type="submit" value="login"><br/>
    </form>

    <a href="modelDemo/login"><h3>Login.jsp</h3></a>

  </body>
</html>

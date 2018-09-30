<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>涛哥的index.jsp</title>
  </head>
  <body>

    <%--<form action="${pageContext}/saveUser" method="post">modelDemo--%>
    <form action="${pageContext.request.contextPath}/modelDemo/saveUser" method="post">
      name:<input name="name"><br/>
      age:<input name="age" ><br/>
      birthday:<input name="birthday" ><br/>
      <input type="submit" value="提交并login"><br/>
    </form>

  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/WEB-ROOT/js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
      $(function () {
          $.post("${pageContext.request.contextPath}/requestMappingDemo/testJSON",function (data) {
            console.log(data);
          })
      })
  </script>
</html>

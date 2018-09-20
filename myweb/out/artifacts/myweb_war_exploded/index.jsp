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

  <a href="modelDemo/testModelMap"><h3>testModelMap</h3></a>
  <a href="modelDemo/testModelAndView"><h3>testModelAndView</h3></a>

  <form action="modelDemo/testModel" method="post">
    name:<input name="name"><br/>
    age:<input name="age" ><br/>
    province:<input name="address.province" ><br/>
    city:<input name="address.city"><br/>
    <input type="submit" value="testModel"><br/>
  </form>


    <a href="requestMappingDemo/testRequestParam?username=aaa&age=11"><h3>testRequestParam</h3></a>

    <h3>------测试REST的简单的CRUD----------------------------------------</h3>
    <form action="TestRESTPOST/111" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="testRESTPOSTTOPUT">
    </form>
    <br/>
    <form action="TestRESTPOST/111" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="testRESTPOSTTODELETE">
    </form>
    <br/>
    <form action="TestRESTPOST" method="post">
      <input type="submit" value="testRESTPOST">
    </form>
    <br/>
    <a href="testRESTGET/111"><h3>testRESTGET</h3></a>
    <h3>-----------------------------------------------------------</h3>


    <a href="requestMappingDemo/testPathVariable/111"><h3>testPathVariable</h3></a>
    <br/>
    <a href="requestMappingDemo/testParamsAndHeadsMethod?username=20&age=10"><h3>testParamsAndHeadsMethod</h3></a>
    <br/>
    <form action="requestMappingDemo/testPostMethod" method="post">
      <input type="submit" value="testPostMethodButton">
    </form>
    <br/>
    <a href="requestMappingDemo/testPostMethod"><h3>testPostMethod</h3></a>
    <br/>
    <a href="toSuccessPage"><h3>toSuccessPage</h3></a>
  </body>
</html>

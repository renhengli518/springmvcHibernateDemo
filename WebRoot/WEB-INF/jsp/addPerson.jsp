<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>addPerson.jsp</title>
  </head>
  
  <body>
  <h3>添加Person</h3>
  <hr>
  <form action="<%=path %>/per/save" method="post">
  <table border="1" width="500">
    <tr>
    <td>Name:</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
    <td>Age:</td>
    <td><input type="text" name="age"></td>
    </tr>
    <tr>
    <td>Address:</td>
    <td><input type="text" name="address"></td>
    </tr>
    <tr>
    <td><input type="reset" name="res" value="取 消"></td>
    <td><input type="submit" name="sub" value="提 交"></td>
    </tr>
    </table>
  </form>
  </body>
</html>

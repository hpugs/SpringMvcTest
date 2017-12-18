<%@page import="javafx.scene.control.Tab"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
    	<table border="1">
    		<a href="user/addJsp.action">添加</a>
    		<tr><th colspan="4">学生表</th></tr>
    		<tr><th>id</th><th>name</th><th>age</th><th>管理</th></tr>
    		<c:forEach var="user" items="${users}">
    			<tr><td>${user.id}</td><td>${user.name}</td><td>${user.age}</td><td><a href="user/addJsp.action?id=${user.id}">修改</a></td></tr>
    		</c:forEach>
    	</table>
    </center> 
  </body>
</html>

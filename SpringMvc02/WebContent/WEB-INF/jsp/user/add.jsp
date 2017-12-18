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
    	<form action="user/add.action" method="post">
	    	<table border="1">
	    		<tr><th colspan="2">学生信息</th></tr>
	    		<c:if test="${not empty user.id}">
	    			<tr><td>id</td><td><input type="text" name="id" value="${user.id}"/></td></tr>
	    		</c:if>
	    		<tr><td>name</td><td><input type="text" name="name" value="${user.name}" placeholder="学生姓名"/></td></tr>
	    		<tr><td>age</td><td><input type="text" name="age" value="${user.age}" placeholder="学生年龄"/></td></tr>
	    		<tr><td>remark</td><td><input type="text" name="remark" value="${user.remark}" placeholder="学生备注"/></td></tr>
	    		<tr><td colspan="2" style="text-align: center;"><input type="submit" value="添加"/>&nbsp;&nbsp;<input type="reset" value="重置"/></td></tr>
	    	</table>
    	</form>
    </center> 
  </body>
</html>

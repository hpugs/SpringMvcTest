<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
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
		<form action="user/login.action" method="post">
	    	<table border="1">
	    		<tr><th colspan="2">登录</th></tr>
	    		<tr><td>name</td><td><input type="text" name="name" placeholder="请输入姓名"/></td></tr>
	    		<tr><td>pwd</td><td><input type="password" name="pwd" placeholder="请输入密码"/></td></tr>
	    		<tr><td colspan="2" style="text-align: center;"><input type="submit" value="登录"/>&nbsp;&nbsp;<input type="reset" value="重置"/></td></tr>
	    	</table>
    	</form>
	</center> 
  </body>
</html>

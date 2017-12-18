<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
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
    <center><table>
    	<tr><th colspan="2">文件上传</th></tr>
    	<tr>
    		<form action="updateFileOnStream.action" method="post" enctype="multipart/form-data">
    			<td><input type="file" name="file"></td>
    			<td><input type="submit" value="单文件上传"></td>
    		</form>
    	</tr>
    	<tr>
    		<form action="updateFileOnTransto.action" method="post" enctype="multipart/form-data">
    			<td><input type="file" name="file"></td>
    			<td><input type="submit" value="单文件上传"></td>
    		</form>
    	</tr>
    	<tr>
    		<form action="updateFile.action" method="post" enctype="multipart/form-data">
    			<td><input type="file" name="file"></td>
    			<td><input type="submit" value="单文件上传"></td>
    		</form>
    	</tr>
    	<tr>
    		<form action="updateFilesOnTransto.action" method="post" enctype="multipart/form-data">
    			<td><input type="file" name="files" multiple="multiple"></td>
    			<td><input type="submit" value="多文件上传"></td>
    		</form>
    	</tr>
    </table></center> 
  </body>
</html>

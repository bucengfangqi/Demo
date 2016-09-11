<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	#test{
	position: relative;
	left:40%;
	font-size:18px;
	color:#D0D0D0;
	}
	a{
	color:#FFF;
	}
	*{
	text-decoration:none;
	}
	a:HOVER{
	text-decoration:underline;
	}
	</style>
  </head>
  
  <body id="test" bgcolor="#06C">
    亲爱的${loginSign}，欢迎您~<a href="clean.action">点此注销</a>&nbsp;<br /><br />
    您当前位置-->页面二&nbsp;<a href="testAll.action">进入首页</a><br /><br />
    
    <a href="test1.action">页面一</a>&nbsp;&nbsp;
    	页面二&nbsp;&nbsp;
    <a href="test3.action">页面三</a><br /><br />
    <a href="test4.action">页面四</a>&nbsp;&nbsp;
    <a href="test5.action">页面五</a>&nbsp;&nbsp;
    <a href="test6.action">页面六</a>
  </body>
</html>

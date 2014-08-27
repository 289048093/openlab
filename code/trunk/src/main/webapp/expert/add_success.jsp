<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
  	<div align="center">
  		问题添加成功，已发送给对应专家。请耐心等待回复。<br>
  		<a style="text-decoration: underline; color: blue;" href="expertQuestionManager/expertQuestion!query.action">点击返回</a>如需修改你可以进入
  		<a style="text-decoration: underline; color: blue;" href="userCenter/main.jsp">个人中心</a>
  		
  	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仪器设备预约失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.error_msg{font-size: 12px; color:red;text-align: center;}
	</style>
  </head>
  
  <body>
  								<div class="error_msg">
															<s:if
																test="#request.cloudContext.errorMsgList!=null && #request.cloudContext.errorMsgList.size()>0">
																<s:iterator value="#request.cloudContext.errorMsgList"
																	var="msg">
																	<s:property value="#request.msg"/>
											
										</s:iterator>
															</s:if>
														</div>
  </body>
</html>

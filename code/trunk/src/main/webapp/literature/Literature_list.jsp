<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>科技文献</title>
		<link rel="stylesheet" type="text/css" href="css/Literature_list.css">
	</head>

	<body>
				<div class="content_body">
					<div class="content_body_title">
						<span style="padding-left: 10px;">科技文献</span>
					</div>
					<center>
						<iframe src="literature/sz_duxiu_.jsp" frameborder="0"  scrolling="no" style="width: 500px;position:relative;border:0px;"></iframe>
					</center>
				</div>
	</body>
</html>

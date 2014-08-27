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

		<title>仪器设备</title>
		<script type="text/javascript" src="resource/equipment/equipment.js"></script>
	</head>

	<body>
		<input type="button" id="insertequipment" class="addoperate"
			value="添加" />

	</body>
</html>

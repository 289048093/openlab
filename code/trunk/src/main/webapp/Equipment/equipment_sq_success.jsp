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

		<title>预约服务</title>
		<style type="text/css">
<!--
body,td,th {
	font-family: 宋体, Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
	$(function(){});
	function clock() {
	var t = $("#settimeclose");
	i = i - 1
	t.html("本窗口将在" + i + "秒后自动关闭!");
	if (i > 0) {
		setTimeout("clock();", 1000);
	} else {
		window.close();
	}
}
var i = 7
clock();
</script>
	</head>
	<body>
		<table width="680" align="center" cellpadding="2" cellspacing="1"
			bgcolor="#b5d6e6">
			<tr>
				<td height="27" colspan="4" align="center"
					background="images/m_03.gif">
					<strong>仪器申请提交结果</strong>
				</td>
			</tr>
			<tr>
				<td height="22" colspan="4" align="center" bgcolor="#f1fafa">
					申请信息
				</td>
			</tr>
			<tr>
				<td height="22" align="center" bgcolor="#f1fafa">
					申请人
				</td>
				<td height="22"  align="left" bgcolor="#FFFFFF">
				${userLogin.realname}
				</td>
				<td height="22" align="center" bgcolor="#f1fafa">
					预约号
				</td>
				<td height="22"  align="left" bgcolor="#FFFFFF">
				${cloudContext.vo.ordrNum}
				</td>
			</tr>
			<tr>
				<td height="22" align="center" bgcolor="#f1fafa">
					仪器名称
				</td>
				<td width="265" height="22" align="left" bgcolor="#FFFFFF">
					${cloudContext.vo.equipmentVO.name}
				</td>
				<td width="98" height="22" align="center" bgcolor="#F1FAFA">
					仪器型号
				</td>
				<td width="205" height="22" align="left" bgcolor="#FFFFFF">
						${cloudContext.vo.equipmentVO.model}
				</td>
			</tr>
			<tr>
			
				<td height="40" align="center" bgcolor="#f1fafa">
					联系电话
				</td>
				<td height="40"  align="left" style="color: red;" bgcolor="#FFFFFF">
				   ${cloudContext.vo.equipmentVO.phone}
				</td>
			
				<td height="40" align="center" bgcolor="#f1fafa">
					订单状态
				</td>
				<td height="40"  align="left" style="color: red;" bgcolor="#FFFFFF">
					申请已成功提交，请注意查收审核结果。
				</td>
			</tr>
			<tr>
				<td height="35" colspan="2" align="center" style="color: red;" bgcolor="#FFFFFF">
						<div id="settimeclose">
						本窗口将在5秒后自动关闭
						</div>
				</td>
				<td height="35" colspan="2" align="center" bgcolor="#FFFFFF">
					<a href="userCenter/main.jsp?linkFlag=1" target="_blank">点击进入个人中心仪器设备订单</a>
					<input type="button" name="button3" id="button3" value="关闭窗口"
						onclick='window.close()' //>
				</td>
			</tr>
		</table>
	</body>
</html>

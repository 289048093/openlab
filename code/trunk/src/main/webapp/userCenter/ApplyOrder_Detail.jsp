<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>订单二维码</title>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	</head>

	<body>
				<div class="content_body" style="width:99%">
					<div class="content_body_title">
						<span style="padding-left: 10px;">订单二维码</span>
					</div>
					<div class="content_body_list">
						<table class="content_body_list_table">
							<tr>
								<td class="content_body_list_table_bt1">
									订单号
								</td>
								<td colspan="3">
									<span>${cloudContext.vo.ordrNum}<img  src="TwoDimensionCode?code=${cloudContext.vo.ordrNum}" style="width: 80px;height:80px;"></span>
									
								</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">仪器名称</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.equipmentName}</td>
								<td class="content_body_list_table_bt1">仪器型号</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.model}</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">下单时间</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.applyDate}</td>
								<td class="content_body_list_table_bt1">联系人</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.contact}</td>
							</tr>
							<tr>
							<td class="content_body_list_table_bt1">电话</td>
								<td class="content_body_list_table_bt2" colspan="3">${cloudContext.vo.phone}</td>
							</tr>
	
							
						</table>
					</div>
				</div>
	</body>
</html>

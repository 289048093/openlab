<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>仪器设备-列表页面</title>
		<link rel="stylesheet" type="text/css" href="css/IndustryDetection_list.css">
	</head>

	<body>
				<div class="content_list">
					<div class="content_list_title">
						<span>行业检测分类</span>
					</div>
					<div class="content_list_list_sys">
						<div class="content_list_list_sys_title">
							实验室类别
						</div>
						<ul class="content_list_list_sys_title_ul">
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">化学实验室</a>
							</li>
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">物理实验室</a>
							</li>
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">医药实验室</a>
							</li>
						</ul>
					</div>
					<div class="content_list_list_hy">
						<div class="content_list_list_sys_title">
							行业类型
						</div>
						<ul class="content_list_list_sys_title_ul">
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">农业</a>
							</li>
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">轻工业</a>
							</li>
							<li>
								<img src="images/arrow1.gif"></img>	
								<a href="#">能源业</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="content_body">
					<div class="content_body_title">
						<span style="padding-left: 10px;">行业监测</span>
					</div>
					<div class="content_body_sousuo">
						<img src="images/ssbg_01.gif" class="content_body_sousuo_bg1"></img>
						<span>监测名称：<input type="text"/> </span>
						<span>单位名称：<input type="text"/> </span>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<span><input type="button" class="jc_sousuo"/> </span>
						<!--<span><input type="button" class="super_yq_sousuo"/> </span>-->
						<img src="images/ssbg_04.gif" class="content_body_sousuo_bg2"></img>
					</div>
					<div class="content_body_list">
						<table class="content_body_list_table">
							<tr class="content_body_list_table_toptr">
								<td class="content_body_list_table_toptd1">序号</td>
								<td class="content_body_list_table_toptd2">监测名称</td>
								<td class="content_body_list_table_toptd3">服务报价</td>
								<td class="content_body_list_table_toptd4">负责单位</td>
								<td class="content_body_list_table_toptd5">操作</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="DownloadCenter/downloadcenter_detail.jsp">土地含碱度监测</a> </td>
								<td>自己制造</td>
								<td>云景的</td>
								<td>
									<input type="button" title="预约申请表下载" class="jc_sq_download" />/
									<input type="button" class="yq_shenqing"/> 
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td><a href="DownloadCenter/downloadcenter_detail.jsp">水质监测</a></td>
								<td>仪器型号</td>
								<td>所在单位</td>
								<td>
									<input type="button" title="预约申请表下载" class="jc_sq_download" />/
									<input type="button" class="yq_shenqing"/> 
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td><a href="DownloadCenter/downloadcenter_detail.jsp">石油勘察</a></td>
								<td>仪器型号</td>
								<td>所在单位</td>
								<td>
									<input type="button" title="预约申请表下载" class="jc_sq_download" />/
									<input type="button" class="yq_shenqing"/> 
								</td>
							</tr>
							<tr>
								<td>4</td>
								<td><a href="DownloadCenter/downloadcenter_detail.jsp">血液化验</a></td>
								<td>仪器型号</td>
								<td>所在单位</td>
								<td>
									<input type="button" title="预约申请表下载" class="jc_sq_download" />/
									<input type="button" class="yq_shenqing"/> 
								</td>
							</tr>
						</table>
					</div>
				</div>
	</body>
</html>

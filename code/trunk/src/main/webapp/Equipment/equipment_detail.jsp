<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<style type="text/css">
</style>

		<title>仪器设备</title>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<link rel="stylesheet" type="text/css" href="css/5icool.org.css" />
		<script type="text/javascript" src="js/jquery-latest.js"></script>
		<script type="text/javascript" src="js/jquery.drag.js"></script>
		<script type="text/javascript">
$(function() {
  var vo="${cloudContext.vo.name}";
   if(vo=="" || vo==null){
   alert("该仪器设备可能已不存在");
    window.location.href ="equipmentManager/equipment!query.action";
   } 
	$("#yq_shenqing").click(function() {
						var s = "${cloudContext.loginedUser}";
						var thereurl = $('#thereUrl').val();
						var url = "equipmentManager/equipment!appointed.action?cloudContext.vo.id="
								+ $(this).attr("lang");
						if (s == "" || s == null) {
							//alert("请先登录");
							showLoginDialog(url);
							return;
						} else {
							if(!!thereurl){
								window.open(thereurl);
							}else{
								window.open(url);
							}
							
						}
					});

});
</script>
<script type="text/javascript">
$(document).ready(function() {
	$("ul.thumb li").hover(function() {
		$(this).css( {
			'z-index' : '10'
		});
		$(this).find('img').addClass("hover").stop().animate( {
			marginTop : '-110px',
			marginLeft : '-110px',
			top : '50%',
			left : '50%',
			width : '200px',
			height : '200px',
			padding : '20px'
		}, 200);
	}, function() {
		$(this).css( {
			'z-index' : '0'
		});
		$(this).find('img').removeClass("hover").stop().animate( {
			marginTop : '0',
			marginLeft : '0',
			top : '0',
			left : '0',
			width : '80px',
			height : '80px',
			padding : '5px'
		}, 400);
	});
		$("ul.thumb li a").click(function() {
			var mainImage = $(this).attr("href"); //Find Image Name
				$("#main_view img").attr( {
					src : mainImage
				});
				return false;
			});
	});
</script>
	</head>

	<body>
		<div class="content_body" style="width: 99%">
			<div class="content_body_title">
				<div style="padding-left: 10px;float:left;">详细信息</div>
					<a href="equipmentManager/equipment!query.action" style="float: right;">返回&gt;&gt;</a>
			</div>
			<div class="content_body_list">
				<table class="content_body_list_table">
					<tr>
						<td class="content_body_list_table_bt1">
							仪器名称
						</td>
						<td>
							<span>${cloudContext.vo.name}</span>

						</td>
						<td class="content_body_list_table_bt1" rowspan="3">
							图片
						</td>
						<td rowspan="3">
							<div id="col">
								<ul class="thumb">
									<li>
										<a href="${cloudContext.vo.pic}"><img
												src="${cloudContext.vo.pic}" alt=""
												style="width: 80; height: 80px;" />
										</a>
									</li>
								</ul>
								</div>
								<span class="content_body_list_table_caozuo"> <s:if
										test="#request.cloudContext.vo.applicable==true && #request.cloudContext.vo.status==1">
										<button lang="${cloudContext.vo.id}" id="yq_shenqing">
											立即申请
										</button>
										<input id="thereUrl" type="hidden" value="<s:property value="#request.cloudContext.vo.redirectURL" />"/>
									</s:if> </span>
						</td>
					</tr>
					<tr>
						<td class="content_body_list_table_bt1">
							仪器型号
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.model}
						</td>
						
					</tr>
					<tr>
						<td class="content_body_list_table_bt1">
							所属单位
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.deptName}
						</td>
						


					</tr>
					<tr>
					<td class="content_body_list_table_bt1">
							仪器类别
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.catName}
						</td>
					<td class="content_body_list_table_bt1">
							所属实验室/技术平台
						</td>
						<td>
							${cloudContext.vo.labName} &nbsp; ${cloudContext.vo.commName}

						</td>
					
					</tr>
					<tr>
						<td class="content_body_list_table_bt1">
							仪器厂商
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.producer}
						</td>
						<td class="content_body_list_table_bt1">
							联系人
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.contact}
						</td>
					</tr>
					<tr>
						<td class="content_body_list_table_bt1">
							联系电话
						</td>
						<td class="content_body_list_table_bt2">
							${cloudContext.vo.phone}
						</td>
						<td class="content_body_list_table_bt1">
							购置时间
						</td>
						<td class="content_body_list_table_bt2">
							<s:date name="#request.cloudContext.vo.purchaseDate"
								format="yyyy-MM-dd" />
						</td>
					</tr>


					<tr>
						<td class="content_body_list_table_bt1">
							简介
						</td>
						<td colspan="3">
							<s:property value="#request.cloudContext.vo.desc" escape="false" />
						</td>
					</tr>


				</table>
			</div>
		</div>
	</body>
</html>

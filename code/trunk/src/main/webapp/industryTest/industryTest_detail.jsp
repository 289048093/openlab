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

		<title>行业检测-详情页面</title>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
	<script type="text/javascript">
	$(function(){
   var vo="${cloudContext.vo.name}";
   if(vo=="" || vo==null){
   alert("该行业检测可能已不存在");
   window.location.href ="industryTestManager/industryTest!query.action";
   } 
	$(".yq_shenqing").click(function(){
	var s="${cloudContext.loginedUser.realname}";
	var url="industryTestManager/industryTest!appointed.action?cloudContext.vo.id="+$(this).attr("lang");
	if(s==""){
	//alert("请先登录");
	//window.open("<%=basePath%>index.jsp");
	showLoginDialog(url);
	return;
	}else{
	window.open(url);
	}
	});
});
			$(function(){
				var cl = $('.content_list').height();
				var bl = $('.content_body').height();
				var max = Math.max(cl,bl);
				$('.content_list').height(max);
				$('.content_body').height(max);
			});
	</script>
		</head>
	<body>
		
				<div class="content_body" style="width:99%">
					<div class="content_body_title">
						<span style="padding-left: 10px;float:left;">详细信息</span>
					<div style="float: right;"><a href="industryTestManager/industryTest!query.action">返回>></a></div>
					</div>
					<div class="content_body_list">
						<table class="content_body_list_table">
							<tr>
								<td class="content_body_list_table_bt1">
								检测名称
								</td>
								<td colspan="3">
									<span>${cloudContext.vo.name}</span>
									<span class="content_body_list_table_caozuo">
										<s:if test="#request.cloudContext.vo.applicable==true">
										<button lang="${cloudContext.vo.id}" class="yq_shenqing">立即预约</button>
									   </s:if>
									</span>
								</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">检测产品</td>
								<td class="content_body_list_table_bt2" colspan="3">${cloudContext.vo.product}</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">检测项目</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.project}</td>
								<td class="content_body_list_table_bt1">领域</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.industryTestCatName}</td>
							</tr>
								<tr>
								<td class="content_body_list_table_bt1">承接单位</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.undertakeUnit}</td>
								<td class="content_body_list_table_bt1">负责人</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.principal}</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">电话</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.phone}</td>
								<td class="content_body_list_table_bt1">email</td>
								<td class="content_body_list_table_bt2">${cloudContext.vo.email}</td>
							</tr>
							<tr>
								<td class="content_body_list_table_bt1">价格</td>
								<td class="content_body_list_table_bt2" colspan="3">${cloudContext.vo.price}</td>
								
							</tr>
						<tr>
								<td class="content_body_list_table_bt1">
									检测内容
								</td>
								<td colspan="3">
									<div class="lang_content">
										<s:property value="#request.cloudContext.vo.content" escape="false"/>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
	</body>
</html>

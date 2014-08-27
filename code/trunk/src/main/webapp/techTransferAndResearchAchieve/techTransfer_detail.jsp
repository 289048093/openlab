<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>技术转移</title>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
	var vo="${cloudContext.vo.title}";
   if(vo=="" || vo==null){
   alert("该技术转移可能已不存在");
   window.location.href ="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action";
   } 
		
		</script>

	</head>

	<body>
				<div class="content_body" style="width:99%">
					<div class="content_body_title">
					   	<span style="padding-left: 10px;float:left;">详细信息</span>
					<a style="float: right;" href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action">返回>></a>
					</div>
					<div class="content_body_list">
						<table class="content_body_list_table">
							<tr>
								<td class="content_body_list_table_bt1">
								标题
								</td>
								<td colspan="3">
								 <s:property value="#request.cloudContext.vo.title" />
								</td>
							</tr>
							
							<tr>
								
								<td class="content_body_list_table_bt1">负责人</td>
								<td class="content_body_list_table_bt2"> <s:property value="#request.cloudContext.vo.userName" /></td>
								<td class="content_body_list_table_bt1">状态:</td>
								<td class="content_body_list_table_bt2"><s:if test="#request.cloudContext.vo.status==0">
				   	 企业已申请
				    </s:if>
				    <s:elseif test="#request.cloudContext.vo.status==1">洽谈合同阶段</s:elseif>
				    <s:elseif test="#request.cloudContext.vo.status==2">合同已签订</s:elseif>
				    <s:elseif test="#request.cloudContext.vo.status==3"> 项目履行中</s:elseif>
				    <s:elseif test="#request.cloudContext.vo.status==4">正常</s:elseif></td>
							
							</tr>
					
						
							<tr>
								<td class="content_body_list_table_bt1">
									内容
								</td>
								<td colspan="3">
								<s:property value="#request.cloudContext.vo.content" escape="false"/>
								</td>
							</tr>
							
							
						</table>
					</div>
				</div>
	</body>
</html>


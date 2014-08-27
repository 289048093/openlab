<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
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

		<title>科研成果与技术转移</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="css/IndustryDetection_list.css">
		<link rel="stylesheet" type="text/css" href="css/example_detail.css">
			<script type="text/javascript">
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
	    <div style="width: 978px; height:200px;">
		<div class="content_list"  style="height:200px;">
			<div class="content_list_title">
			   <div style="float: left;">	科研成果</div>
				
					<a
						href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action" style="float: right;">更多>></a>
			
			
			</div>
			<div>
				<ul class="title_listul">
					<s:if
						test="cloudContext.params.researchLevelVOs!=null && cloudContext.params.researchLevelVOs.size>=6">
						<s:iterator value="cloudContext.params.researchLevelVOs"
							var="researchLevelVO" begin="0" end="5">
							<li class="column_item_control_sml">
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action?cloudContext.params.levelId=<s:property value='id'/>"><s:property
										value="name" /> </a>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
					<s:iterator value="cloudContext.params.researchLevelVOs"
							var="researchLevelVO" >
							<li class="column_item_control_sml">
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action?cloudContext.params.levelId=<s:property value='id'/>"><s:property
										value="name" /> </a>
							</li>
						</s:iterator>
					
					</s:else>
				</ul>
			</div>
		</div>
		<!-- left end -->
		<!-- right start -->

		<div class="content_detail"  style="height:200px;">
			<div class="content_detail_title">
				<div style="float: left">
					科研成果
				</div>
				<div style="float: right;">
					<a
						href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action">更多>></a>
				</div>
			</div>
			<div>
				<ul class="content_detail_titleul">
					<s:if
						test="cloudContext.params.achieveVOs!=null && cloudContext.params.achieveVOs.size>=6">
						<s:iterator value="cloudContext.params.achieveVOs" var="achieveVO" begin="0" end="5">
							<li>
								<a class="astyle"
									href='techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!researchAchieveDetail.action?cloudContext.vo.id=<s:property value="id"/>'>
									<s:property value="#request.achieveVO.name" /> </a>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						<s:iterator value="cloudContext.params.achieveVOs" var="achieveVO" >
							<li>
								<a class="astyle"
									href='techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!researchAchieveDetail.action?cloudContext.vo.id=<s:property value="id"/>'>
									<s:property value="#request.achieveVO.name" /> </a>
							</li>
						</s:iterator>
					
					</s:else>
				</ul>
			</div>

		</div>
		<!-- right end -->
</div>
<br/>

	    <div style="width: 978px; height:200px;">
		<div class="content_list"  style="height:200px;">
			<div class="content_list_title" style="padding-left: 0px;">
				<div style="float: left;">技术转移</div>
				<a
						href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action" style="float: right;">更多>></a>
			</div>

			<div>
				<ul class="content_list_list_sys_title_ul">
					<s:if
						test="cloudContext.params.techTransferCatVOs!=null && cloudContext.params.techTransferCatVOs.size>=20">
						<s:iterator value="cloudContext.params.techTransferCatVOs"
							var="techTransferCatVO" begin="0" end="19">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action?cloudContext.params.catId=<s:property value='id'/>"><s:property
										value="name" /> </a>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
					<s:iterator value="cloudContext.params.techTransferCatVOs"
							var="techTransferCatVO">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action?cloudContext.params.catId=<s:property value='id'/>"><s:property
										value="name" /> </a>
							</li>
						</s:iterator>
					</s:else>

				</ul>
			</div>

		</div>
		<!-- left end -->
		<!-- right start -->

		<div class="content_detail"  style="height:200px;">
			<div class="content_body_title" align="center">
				<div style="float: left">
					技术转移
				</div>
				<div style="float: right;">
					<a
						href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action">更多>></a>
				</div>
			</div>
			<div>
					<table class="content_body_list_table">
					<tr class="content_body_list_table_toptr">
						<td class="content_body_list_table_toptd1">
							标题
						</td>
						<td class="content_body_list_table_toptd2">
							负责人
						</td>
						<td class="content_body_list_table_toptd3">
							状态
						</td>

					</tr>
					<s:if
						test="cloudContext.params.transferVOs!=null && cloudContext.params.transferVOs.size>=20">
						<s:iterator value="cloudContext.params.transferVOs"
							var="transferVO" begin="0" end="19">
							<tr>

								<td>
									<a
										href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!transferDetail.action?cloudContext.vo.id=<s:property value="id"/>"><s:property
											value="#request.transferVO.title" /> </a>
								</td>
								<td>
									<s:property value="#request.transferVO.userName" />
								</td>
								<td>
									<s:if test="#request.transferVO.status==0">
				    企业已申请
				    </s:if>
									<s:elseif test="#request.transferVO.status==1">洽谈合同阶段</s:elseif>
									<s:elseif test="#request.transferVO.status==2">合同已签订</s:elseif>
									<s:elseif test="#request.transferVO.status==3"> 项目履行中</s:elseif>
									<s:elseif test="#request.transferVO.status==4">正常</s:elseif>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
					<s:iterator value="cloudContext.params.transferVOs"
							var="transferVO">
							<tr>

								<td>
									<a
										href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!transferDetail.action?cloudContext.vo.id=<s:property value="id"/>"><s:property
											value="#request.transferVO.title" /> </a>
								</td>
								<td>
									<s:property value="#request.transferVO.userName" />
								</td>
								<td>
									<s:if test="#request.transferVO.status==0">
				    企业已申请
				    </s:if>
									<s:elseif test="#request.transferVO.status==1">洽谈合同阶段</s:elseif>
									<s:elseif test="#request.transferVO.status==2">合同已签订</s:elseif>
									<s:elseif test="#request.transferVO.status==3"> 项目履行中</s:elseif>
									<s:elseif test="#request.transferVO.status==4">正常</s:elseif>
								</td>
							</tr>
						</s:iterator>
					
					</s:else>

				</table>
			</div>

		</div>
		<!-- right end -->
</div>
     
	</body>
</html>

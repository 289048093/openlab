<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>行业检测</title>
		<link rel="stylesheet" type="text/css"
			href="css/IndustryDetection_list.css">
		<script type="text/javascript">
	$(function(){
	// 前台行业检测申请预约按钮单击事件
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
		<div class="content_list">
			<div class="content_list_title" style="text-align: center;">
				<span>行业检测</span>
			</div>

			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title">
					领域
				</div>
				<ul class="content_list_list_sys_title_ul">
					<s:if
						test="cloudContext.params.industryTestCatVOs!=null && cloudContext.params.industryTestCatVOs.size>0">
						<s:iterator value="cloudContext.params.industryTestCatVOs"
							var="industryTestCatVO">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="industryTestManager/industryTest!query.action?cloudContext.vo.industryTestcatId=<s:property value="#request.industryTestCatVO.id" />"><s:property
										value="#request.industryTestCatVO.name" /> </a>
							</li>
						</s:iterator>
					</s:if>

				</ul>
			</div>
		</div>
		<div class="content_body">
			<div class="content_body_title">
				<img src="images/dh.gif" />
				<span id="title">首页 -> 行业检测</span>
			</div>
			<div class="content_body_sousuo">
				<form action="industryTestManager/industryTest!query.action">
					<img src="images/ssbg_01.gif" class="content_body_sousuo_bg1"></img>
					<input type="hidden" name="cloudContext.vo.industryTestcatId"
						value="${cloudContext.vo.industryTestcatId}">
					<span style="left: -201px; position: relative;">名称：<input
							type="text" name="cloudContext.vo.name"
							value="${cloudContext.vo.name }" /> </span>

					<span style="left: -200px; position: relative;"><input
							type="submit" class="yq_sousuo" value="查询" /> </span>
					<!--<span><input type="button" class="super_yq_sousuo"/> </span>-->
					<!--						<img src="images/ssbg_04.gif" class="content_body_sousuo_bg2"></img>-->
				</form>
			</div>
			<form action="industryTestManager/industryTest!query.action"
				id="myform" method="post">
				<div class="content_body_list">
					<table class="content_body_list_table">
						<tr class="content_body_list_table_toptr">
							<td class="content_body_list_table_toptd1">
								检测名称
							</td>
							<td class="content_body_list_table_toptd3">
								检测产品
							</td>
							<td class="content_body_list_table_toptd4">
								检测项目
							</td>
							<td class="content_body_list_table_toptd5">
								操作
							</td>
						</tr>
						<s:if
							test="cloudContext.params.industryTestVOs!=null && cloudContext.params.industryTestVOs.size>0">
							<s:iterator value="cloudContext.params.industryTestVOs"
								var="industryTestVOs">
								<tr>
									<td>
										<a
											href="industryTestManager/industryTest!queryById.action?cloudContext.vo.id=<s:property value="#request.industryTestVOs.id" />"><s:property
												value="#request.industryTestVOs.name" /> </a>
									</td>

									<td>
										<s:property value="#request.industryTestVOs.product" />
									</td>
									<td>
										<s:property value="#request.industryTestVOs.project" />
									</td>
									<td>
										<s:if test="#request.industryTestVOs.applicable==true">
											<!--								<a href="#"><input type="button" title="预约申请表下载" class="jc_sq_download" /></a>/-->

											<input type="button" class="yq_shenqing"
												lang="<s:property value="#request.industryTestVOs.id"/> "
												style="cursor: pointer;">
										</s:if>
										<!--									<a href="industryTest/uploadAppointed.jsp">上传预约表预约</a>-->
									</td>
								</tr>
							</s:iterator>
						</s:if>
					</table>
				</div>
				<!-- 分页 -->
				<pg:pager url="industryTestManager/industryTest!query.action"
					items="${cloudContext.pageInfo.dataCount}"
					export="currentPageNumber=pageNumber"
					maxPageItems="${cloudContext.pageInfo.eachPageData}">
					<pg:param name="pagesize"
						value="${cloudContext.pageInfo.eachPageData }" />
					<pg:param name="cloudContext.vo.industryTestcatId"
						value="${cloudContext.vo.industryTestcatId }" />
					<pg:param name="cloudContext.pageInfo.dataCount"
						value="${cloudContext.pageInfo.dataCount}" />
					<!-- 参数name -->
					<pg:param name="cloudContext.vo.name"
						value="${cloudContext.vo.name}" />

					<!-- 参数类别 -->
					<input type="hidden" name="cloudContext.vo.industryTestcatId"
						value="<s:property value="#request.cloudContext.vo.industryTestcatId" />" />
					<input type="hidden" name="cloudContext.vo.name"
						value="<s:property value="#request.cloudContext.vo.name" />" />
					<input type="hidden" name="cloudContext.vo.area"
						value="<s:property value="#request.cloudContext.vo.area" />" />
					<input type="hidden" name="pager.offset"
						value="<s:property value="cloudContext.pageInfo.start"/>" />
					<div class="">
						<div class="pager_center">
							<pg:first>
								<a href="${pageUrl}">首页</a>
							</pg:first>
							<pg:prev>
								<a href="${pageUrl}">上一页</a>
							</pg:prev>
							<s:if test="cloudContext.pageInfo.dataCount==0">
								<font color="red" id="nowPage">1</font>
							</s:if>
							<s:else>
								<pg:pages>
									<%
										if (currentPageNumber == pageNumber) {
									%>
									<font color="red" id="nowPage">${pageNumber }</font>
									<%
										} else {
									%>
									<a href="${pageUrl }">${pageNumber }</a>
									<%
										}
									%>
								</pg:pages>
							</s:else>
							<pg:next>
								<a href="${pageUrl}">下一页</a>
							</pg:next>
							<pg:last>
								<a href="${pageUrl}">尾页</a>
							</pg:last>
						</div>
						<div class="pager_right">
							当前第 ${currentPageNumber }
							页&nbsp;共${cloudContext.pageInfo.dataCount }条记录
							<span>&nbsp;每页显示</span>
							<select onchange="$('#myform').submit()" id="eachPageData"
								name="pagesize">
								<option value="20" ${cloudContext.pageInfo.eachPageData==20?
									"selected='selected'":"" }>
									20
								</option>
								<option value="40" ${cloudContext.pageInfo.eachPageData==40?
									"selected='selected'":"" }>
									40
								</option>
								<option value="60" ${cloudContext.pageInfo.eachPageData==60?
									"selected='selected'":"" }>
									60
								</option>
							</select>
						</div>
					</div>
				</pg:pager>
				<!-- 分页结束 -->
			</form>
		</div>
	</body>
</html>

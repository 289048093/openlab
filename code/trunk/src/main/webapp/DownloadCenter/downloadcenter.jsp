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

		<title>下载中心</title>
		<link rel="stylesheet" type="text/css"
			href="css/downloadcenter_list.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
		<div class="content_list">
			<div class="content_list_title" style="text-align: center">
				<span>下载分类</span>
			</div>
			<div class="content_list_list">
				<table class="content_list_list_table">
					<s:if
						test="cloudContext.params.downloadFileCat!=null && cloudContext.params.downloadFileCat.size>0">
						<s:iterator value="cloudContext.params.downloadFileCat"
							var="downloadFileCat">
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a
										href="downloadFileManager/downloadFile!query.action?cloudContext.params.catId=<s:property value='id'/>"><s:property
											value="name" /> </a>
								</td>
							</tr>
						</s:iterator>
					</s:if>
				</table>
			</div>
		</div>
		<div class="content_body">
			<div class="content_body_title">
				<img src="images/dh.gif" />
				<span id="title">首页 ->下载中心</span>
			</div>
			<div class="content_body_sousuo">
				<form id="dform" style="margin: 0px;"
					action="downloadFileManager/downloadFile!query.action"
					method="post">
					<img src="images/ssbg_01.gif" class="content_body_sousuo_bg1"></img>
					<span class="search_offset">文件名称：<input type="text"
							name="cloudContext.vo.name" value="${cloudContext.vo.name}" /> </span>
					<span class="search_offset">文件描述：<input type="text"
							name="cloudContext.vo.desc" value="${cloudContext.vo.desc}" /> </span>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="search_offset"><input type="submit" value="搜索" />
					</span>
				</form>
			</div>
			<form action="downloadFileManager/downloadFile!query.action"
				id="myform" method="post">
				<div class="content_body_list">
					<table class="content_body_list_table">
						<tr class="content_body_list_table_toptr">
							<td class="content_body_list_table_toptd1">
								序号
							</td>
							<td class="content_body_list_table_toptd2">
								文件名称
							</td>
							<td class="content_body_list_table_toptd3">
								描述
							</td>
							<td class="content_body_list_table_toptd4">
								操作
							</td>
						</tr>
						<s:if
							test="cloudContext.params.downloadFile!=null && cloudContext.params.downloadFile.size>0">
							<s:iterator value="cloudContext.params.downloadFile"
								var="download" status="number">
								<tr>
									<td>
										${number.count }
									</td>
									<td>
										<s:property value="name" />
									</td>
									<td>
										<s:property value="desc" />
									</td>
									<td>
										<a href="<s:property value="url" />" class="yq_shenqing">
										</a>
									</td>
								</tr>
							</s:iterator>
						</s:if>
					</table>
				</div>
				<!-- 分页 -->
				<pg:pager url="downloadFileManager/downloadFile!query.action"
					items="${cloudContext.pageInfo.dataCount}"
					export="currentPageNumber=pageNumber"
					maxPageItems="${cloudContext.pageInfo.eachPageData}">
					<pg:param name="pagesize"
						value="${cloudContext.pageInfo.eachPageData }" />
					<pg:param name="cloudContext.params.catId"
						value="${cloudContext.params.catId[0] }" />
					<pg:param name="cloudContext.pageInfo.dataCount"
						value="${cloudContext.pageInfo.dataCount}" />
					<!-- 参数name -->
					<pg:param name="cloudContext.vo.name"
						value="${cloudContext.vo.name}" />
					<!-- 参数描述 -->
					<pg:param name="cloudContext.vo.desc"
						value="${cloudContext.vo.desc}" />
					<!-- 参数类别 -->
					<input type="hidden" name="cloudContext.params.catId"
						value="<s:property value="#request.cloudContext.params.catId[0]" />" />

					<input type="hidden" name="cloudContext.vo.name"
						value="<s:property value="#request.cloudContext.vo.name" />" />
					<input type="hidden" name="cloudContext.vo.desc"
						value="<s:property value="#request.cloudContext.vo.desc" />" />
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

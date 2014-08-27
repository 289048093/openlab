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

		<title>专家咨询</title>
		<link rel="stylesheet" type="text/css" href="css/experts_list.css">
		<SCRIPT type="text/javascript" src="expert/expert_list.js"></SCRIPT>
	</head>

	<body>
		<div class="content_list">
			<div class="content_list_title" style="text-align: center">
				<span>问答天地</span>
			</div>

			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title">
					经典问答
				</div>
				<ul class="content_list_list_sys_title_ul">
					<s:if
						test="cloudContext.params.classicsexperts!=null && cloudContext.params.classicsexperts.size>0">
						<s:iterator value="cloudContext.params.classicsexperts">
							<li>
								<img src="images/arrow1.gif"></img>
								<a href="expertQuestionManager/expertQuestion!showoneExpert.action?cloudContext.vo.id=<s:property value="id" />" >
								<s:property value="title" /> </a>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						没有数据
					</s:else>
				</ul>
			</div>
			
		</div>
		<div class="content_body">
			<div class="content_body_title">
				<img src="images/dh.gif"></img>
				<span id="title">首页 -&gt;所有问答</span>
			</div>
			<div class="content_body_list">
					<ul class="title_listul">
					<s:if
						test="cloudContext.params.allexperts!=null && cloudContext.params.allexperts.size>0">
						<s:iterator value="cloudContext.params.allexperts" var="expertquestion">
							<li class="column_item_control_sml">
							<a href="expertQuestionManager/expertQuestion!showoneExpert.action?cloudContext.vo.id=<s:property value="id" />" >
								<s:property value="title" /> </a>
							</li>
						</s:iterator>
					</s:if>
				</ul>
					<form action="expertQuestionManager/expertQuestion!queryAll.action"
					id="myform" method="post">
					<!-- 分页 -->
					<pg:pager url="expertQuestionManager/expertQuestion!queryAll.action"
						items="${cloudContext.pageInfo.dataCount}"
						export="currentPageNumber=pageNumber"
						maxPageItems="${cloudContext.pageInfo.eachPageData}">
						<pg:param name="pagesize"
							value="${cloudContext.pageInfo.eachPageData }" />
						<pg:param name="cloudContext.params.catId"
							value="${cloudContext.params.catId[0] }" />
						<pg:param name="cloudContext.pageInfo.dataCount"
							value="${cloudContext.pageInfo.dataCount}" />
						<input type="hidden" name="cloudContext.params.catId"
							value="<s:property value="#request.cloudContext.params.catId[0]" />" />
						<input type="hidden" name="pager.offset"
							value="<s:property value="cloudContext.pageInfo.start"/>" />
						<div style="height: 30px;" class="">
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
									<option value="5" ${cloudContext.pageInfo.eachPageData==5?
										"selected='selected'":"" }>
										20
									</option>
									<option value="10" ${cloudContext.pageInfo.eachPageData==10?
										"selected='selected'":"" }>
										40
									</option>
									<option value="15" ${cloudContext.pageInfo.eachPageData==15?
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
			
		</div>
	
	</body>
</html>

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

		<title>政策法规</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/example_detail.css">
			<script type="text/javascript">
			window.onload=function(){
				var content = '.content_detail';
				var list  = '.content_list';
				var cl = $(list).height();
				var bl = $(content).height();
				var max = Math.max(cl,bl);
				$(list).height(max);
				$(content).height(max);
			};
		</script>
	</head>
	<body>
		<form action="policyManager/policy!query.action" id="myform"
			method="post">
			<div class="content_list">
				<div class="content_list_title">
					政策法规分类
				</div>
				<div>
					<ul class="title_listul">
						<s:if
							test="cloudContext.params.policyCatVOs!=null && cloudContext.params.policyCatVOs.size>0">
							<s:iterator value="cloudContext.params.policyCatVOs"
								var="policyCat">
								<li class="column_item_control_sml">
									<a
										href="policyManager/policy!query.action?cloudContext.params.catId=<s:property value='id'/>"><s:property
											value="name" /> </a>
								</li>
							</s:iterator>
						</s:if>
					</ul>
				</div>
			</div>
			<!-- left end -->
			<!-- right start -->
			<div class="content_detail">
				<div class="content_detail_title">
				<img src="images/dh.gif"/>
					<span id="title">首页 -> 政策法规</span>
				</div>
				<div>
					<ul class="content_detail_titleul">
						<s:if
							test="cloudContext.params.topPolicyVOs!=null && cloudContext.params.topPolicyVOs.size>0">
							<s:iterator value="cloudContext.params.topPolicyVOs" var="policyVO">
								<li>
									<a class="astyle"
										href='policyManager/policy!detail.action?cloudContext.vo.id=<s:property value="id"/>'>
										<s:property value="#request.policyVO.title" /> </a>
								</li>
							</s:iterator>
						</s:if>
						<s:if
							test="cloudContext.params.untopPolicyVOs!=null && cloudContext.params.untopPolicyVOs.size>0">
							<s:iterator value="cloudContext.params.untopPolicyVOs" var="policyVO">
								<li>
									<a class="astyle"
										href='policyManager/policy!detail.action?cloudContext.vo.id=<s:property value="id"/>'>
										<s:property value="#request.policyVO.title" /> </a>
								</li>
							</s:iterator>
						</s:if>
					</ul>
				</div>
				<!-- 分页 -->
				<pg:pager url="policyManager/policy!query.action"
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
				</div>
		</form>
		<!-- right end -->

	</body>
</html>

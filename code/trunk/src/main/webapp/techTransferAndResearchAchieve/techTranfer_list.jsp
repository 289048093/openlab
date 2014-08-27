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

		<title>技术转移</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="css/IndustryDetection_list.css">
		<link rel="stylesheet" type="text/css" href="css/example_detail.css">
		<script type="text/javascript">
			window.onload=function(){
				var content = '.content_list';
				var list  = '.content_body';
				var cl = $(list).height();
				var bl = $(content).height();
				var max = Math.max(cl,bl);
				$(list).height(max);
				$(content).height(max);
			};
		</script>
	</head>

	<body>
		<div class="content_list">
			<div class="content_list_title" style="padding-left: 0px;">
				<span>技术转移</span>
			</div>

			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title">
					技术转移分类
				</div>
				<ul class="content_list_list_sys_title_ul">
					<s:if
						test="cloudContext.params.techTransferCatVOs!=null && cloudContext.params.techTransferCatVOs.size>0">
						<s:iterator value="cloudContext.params.techTransferCatVOs"
							var="techTransferCatVO">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action?cloudContext.params.catId=<s:property value='id'/>"><s:property
										value="name" /> </a>
							</li>
						</s:iterator>
					</s:if>

				</ul>
			</div>

		</div>
		<!-- left end -->
		<!-- right start -->
		<form
			action="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action"
			id="myform" method="post">
			<div class="content_body" style="width: 73%">
				<div class="content_body_title" align="center">
                  	<img src="images/dh.gif"/>
				<span id="title">首页 ->技术转移</span>
				</div>
				<br />
				<div class="content_body_list">
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
							test="cloudContext.params.transferVOs!=null && cloudContext.params.transferVOs.size>0">
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
						</s:if>

					</table>
				</div>
				<!-- 分页 -->
				<pg:pager
					url="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryTransfer.action"
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

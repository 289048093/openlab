<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
					<span id="title">首页 ->政策法规详情</span>
			</div>
			<div class="content_">
				<h3 align="center" class="news_title">
					<s:property value="#request.cloudContext.vo.title" />
				</h3>
				<div style="margin-top: -10px; text-align: center; border-bottom: 1px solid #5A5AEC; padding-bottom: 4px;">
					发布时间：
					<s:date name="#request.cloudContext.vo.addDate" format="yyyy/MM/dd" />
					&nbsp;&nbsp;&nbsp;供稿单位：
					<s:property value="#request.cloudContext.vo.providerName" />
					&nbsp;&nbsp;&nbsp;阅读次数：
					<s:property value="#request.cloudContext.vo.count" />
				</div>
				<div class="news_content">
					<s:property value="#request.cloudContext.vo.content" escape="false" />
				</div>
			</div>
		</div>
		<!-- right end -->
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	var vo="${cloudContext.vo.name}";
   if(vo=="" || vo==null){
   alert("该科研成果可能已不存在");
   window.location.href ="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action";
   } 
		</script>
	</head>
	<body>
		<div class="content_list">
			<div class="content_list_title">
				科研成果
			</div>
			<div>
				<ul class="title_listul">
					<s:if
						test="cloudContext.params.researchLevelVOs!=null && cloudContext.params.researchLevelVOs.size>0">
						<s:iterator value="cloudContext.params.researchLevelVOs"
							var="researchLevelVO">
							<li class="column_item_control_sml">
								<a
									href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!queryResearchAchieve.action?cloudContext.params.levelId=<s:property value='id'/>"><s:property
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
			   首页->科研成果
			</div>
		<div class="content_">
				<h3 align="center" class="news_title">
					<s:property value="#request.cloudContext.vo.name" />
				</h3>
				<div
					style="margin-top: -10px; text-align: center; border-bottom: 1px solid #5A5AEC; padding-bottom: 4px;">
				    发布时间：
					<s:date name="#request.cloudContext.vo.addDate" format="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;
				   供稿单位：
				   <s:property value="#request.cloudContext.vo.providerName"/>
				</div>
				<div class="news_content">
					<s:property value="#request.cloudContext.vo.desc" escape="false"/>
				</div>
			</div>
		</div>
		<!-- right end -->
	</body>
</html>

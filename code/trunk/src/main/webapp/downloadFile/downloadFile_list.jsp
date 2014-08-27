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

		<title>下载中心</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/example_detail.css">
		<link rel="stylesheet" type="text/css"
			href="css/downloadcenter_list.css">
		<script type="text/javascript">
     function downloadFile(id) {
	     window.open("downloadFileManager/downloadFile!downloadFile.action?cloudContext.vo.id="+ id);
     }
			
	</script>
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
						下载中心分类
					</div>
					<div>
						<ul class="title_listul">
							<s:if
								test="cloudContext.params.downloadFileCatVOs!=null && cloudContext.params.downloadFileCatVOs.size>0">
								<s:iterator value="cloudContext.params.downloadFileCatVOs"
									var="downloadFileCat">
									<li class="column_item_control_sml">
										<a
											href="downloadFileCatManager/downloadFileCat!queryById.action?cloudContext.vo.id=<s:property value='id'/>"><s:property
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
						<span id="title">首页 -> 下载中心</span>
					</div>
					<div class="content_body_sousuo">
						<img src="images/ssbg_01.gif" class="content_body_sousuo_bg1"></img>
						<span>文件名称：<input type="text" /> </span>
						<span>单位名称：<input type="text" /> </span> &nbsp;&nbsp;&nbsp;&nbsp;
						<span><input type="button" class="yq_sousuo" /> </span>
						<!--<span><input type="button" class="super_yq_sousuo"/> </span>-->
						<img src="images/ssbg_04.gif" class="content_body_sousuo_bg2"></img>
					</div>
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
									文件描述
								</td>
								<td class="content_body_list_table_toptd4">
									操作
								</td>
							</tr>
							<s:if
								test="cloudContext.params.downloadFileCatVO!=null && cloudContext.params.downloadFileCatVO.size>0">
								<s:iterator value="cloudContext.params.downloadFileCatVO"
									var="downloadFileCatVO">
									<tr>
										<td>
											<s:property value="#request.downloadFileCatVO.id" />
										</td>
										<td>
											<s:property value="#request.downloadFileCatVO.name" />
										</td>
										<td>
											<s:property value="#request.downloadFileCatVO.desc" />
										</td>
										<td>
											<a href="javascript:;" class="yq_shenqing"
												onclick="downloadFile(<s:property value="id" />)"> </a>
										</td>
									</tr>
<
								</s:iterator>
							</s:if>
						</table>
					</div>
				</div>
				<!-- right end -->
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cloudking.openlab.PropertyManager"%>
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

		<title>仪器设备</title>
		<link rel="stylesheet" type="text/css"
			href="css/IndustryDetection_list.css">
		<script type="text/javascript" src="js/slide.js"></script>
		<script type="text/javascript">
	$(function(){
	$(".yq_shenqing").click(function(){
	var s="${cloudContext.loginedUser}";
	var thereurl = $(this).next().val();
	var url="equipmentManager/equipment!appointed.action?cloudContext.vo.id="+$(this).attr("lang");
	if(s=="" ||s==null){
	//alert("请先登录");
	showLoginDialog(url)
	return;
	}else{
		if(!!thereurl){
			window.open(thereurl);
		}else{
			window.open(url);
		}
	}
	});

});

function check(){
//开始时间

//结束时间

}
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
		<div class="content_list" style="">
			<div class="content_list_title" style="text-align: center">
				<span>仪器设备</span>
			</div>

			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title" style="cursor: pointer;"
					id="instrumentType_title">
					按仪器类型分类
				</div>
				<ul class="content_list_list_sys_title_ul hide_"
					id="instrumentType_list"
					<s:if test="cloudContext.vo.catId!=null">style='display:block;'</s:if>>
					<s:if
						test="cloudContext.params.equipmentCatVOs!=null && cloudContext.params.equipmentCatVOs.size>0">
						<s:iterator value="cloudContext.params.equipmentCatVOs"
							var="equipmentCatVO">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="equipmentManager/equipment!query.action?cloudContext.vo.catId=<s:property value="#request.equipmentCatVO.id" />"><s:property
										value="#request.equipmentCatVO.name" /> </a>
							</li>
						</s:iterator>
					</s:if>
				</ul>
			</div>
			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title" style="cursor: pointer;"
					id="laboratory_title">
					按重点实验室分类
				</div>
				<ul class="content_list_list_sys_title_ul hide_"
					id="laboratory_list"
					<s:if test="cloudContext.vo.labId!=null">style='display:block;'</s:if>>
					<s:if
						test="cloudContext.params.labVOs!=null && cloudContext.params.labVOs.size>0">
						<s:iterator value="cloudContext.params.labVOs" var="labVO">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="equipmentManager/equipment!query.action?cloudContext.vo.labId=<s:property value="#request.labVO.id" />"><s:property
										value="#request.labVO.name" /> </a>
							</li>
						</s:iterator>
					</s:if>
				</ul>
			</div>
			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title" style="cursor: pointer;"
					id="laboratory_title">
					按公共技术平台分类
				</div>
				<ul class="content_list_list_sys_title_ul hide_"
					id="laboratory_list"
					<s:if test="cloudContext.vo.commId!=null">style='display:block;'</s:if>>
					<s:if
						test="cloudContext.params.comms!=null && cloudContext.params.comms.size>0">
						<s:iterator value="cloudContext.params.comms" var="comm">
							<li>
								<img src="images/arrow1.gif"></img>
								<a
									href="equipmentManager/equipment!query.action?cloudContext.vo.commId=<s:property value="#request.comm.id" />"><s:property
										value="#request.comm.name" /> </a>
							</li>
						</s:iterator>
					</s:if>

				</ul>
			</div>
		</div>
		<div class="content_body">
			<div class="content_body_title">
				<img src="images/dh.gif" />
				<span id="title">首页 -&gt;仪器设备</span>
			</div>
			<div class="content_body_sousuo">
				<form action="equipmentManager/equipment!query.action" method="post"
					onsubmit="check()">
					<img src="images/ssbg_01.gif" class="content_body_sousuo_bg1"></img>
					<input type="hidden" name="cloudContext.vo.catId"
						value="${cloudContext.vo.catId}">
					<input type="hidden" name="cloudContext.vo.labId"
						value="${cloudContext.vo.labId}">
					<span style="left: -102px; position: relative;">名称：<input
							type="text" name="cloudContext.vo.name"
							value="${ cloudContext.vo.name }" /> </span>
					<span style="left: -37px; position: relative;">型号：<input
							type="text" name="cloudContext.vo.model"
							value="${ cloudContext.vo.model }" /> </span>
					<span><input type="submit" class="yq_sousuo" value="查询"
							style="cursor: pointer;" /> </span>
					<!--<span><input type="button" class="super_yq_sousuo"/> </span>-->
					<!--						<img src="images/ssbg_04.gif" class="content_body_sousuo_bg2"></img>-->
				</form>

			</div>
			<form action="equipmentManager/equipment!query.action" id="myform"
				method="post">
				<div class="content_body_list">
					<table class="content_body_list_table">
						<tr class="content_body_list_table_toptr">
							<td>
								图片
							</td>
							<td class="content_body_list_table_toptd1">
								名称
							</td>
							<td class="content_body_list_table_toptd2">
								型号
							</td>
							<td class="content_body_list_table_toptd3">
								所属单位
							</td>

							<td class="content_body_list_table_toptd4">
								联系人
							</td>
							<td class="content_body_list_table_toptd5">
								操作
							</td>
						</tr>
						<s:if
							test="cloudContext.params.equipmentVOs!=null && cloudContext.params.equipmentVOs.size>0">
							<s:iterator value="cloudContext.params.equipmentVOs"
								var="equipmentVO">
								<tr>

									<td>
										<img src='${equipmentVO.pic}'
											style="width: 30px; height: 30px;" />
									</td>
									<td class="content_body_list_table_toptd1">
										<a
											href="equipmentManager/equipment!queryById.action?cloudContext.vo.id=<s:property value="#request.equipmentVO.id" />"><s:property
												value="#request.equipmentVO.name" /> </a>
									</td>
									<td class="content_body_list_table_toptd2">
										<s:property value="#request.equipmentVO.model" />
									</td>
									<td class="content_body_list_table_toptd3">

										<s:property value="#request.equipmentVO.deptName" />
									</td>
									<td class="content_body_list_table_toptd4">

										<s:property value="#request.equipmentVO.contact" />
									</td>
									<td class="content_body_list_table_toptd5">
							
														<!--								<a href="#"><input type="button" title="预约申请表下载" class="jc_sq_download" /></a>/-->
                                          <s:if test="#request.equipmentVO.applicable==true && #request.equipmentVO.status==1">
											<a>
											<input type="button" class="yq_shenqing"
													lang="<s:property value="#request.equipmentVO.id" />" style="cursor: pointer;"/>
											<input type="hidden" value="<s:property value="#request.equipmentVO.redirectURL" />"/>	
													 </a>
													</s:if>						
										<!--									<a href="industryTest/uploadAppointed.jsp">上传预约表预约</a>-->
									</td>
								</tr>
							</s:iterator>
						</s:if>
					</table>
				</div>
				<!-- 分页 -->
				<pg:pager url="equipmentManager/equipment!query.action"
					items="${cloudContext.pageInfo.dataCount}"
					export="currentPageNumber=pageNumber"
					maxPageItems="${cloudContext.pageInfo.eachPageData}">
					<pg:param name="pagesize"
						value="${cloudContext.pageInfo.eachPageData }" />
					<pg:param name="cloudContext.vo.catId"
						value="${cloudContext.vo.catId }" />
					<pg:param name="cloudContext.vo.labId"
						value="${cloudContext.vo.labId }" />
					<pg:param name="cloudContext.vo.commId"
						value="${cloudContext.vo.commId }" />
					<pg:param name="cloudContext.pageInfo.dataCount"
						value="${cloudContext.pageInfo.dataCount}" />
					<!-- 参数name -->
					<pg:param name="cloudContext.vo.name"
						value="${cloudContext.vo.name}" />
					<!-- 参数型号 -->
					<pg:param name="cloudContext.vo.model"
						value="${cloudContext.vo.desc}" />
					<!-- 参数类别 -->
					<input type="hidden" name="cloudContext.vo.catId"
						value="<s:property value="#request.cloudContext.vo.catId" />" />
					<input type="hidden" name="cloudContext.vo.commId"
						value="<s:property value="#request.cloudContext.vo.commId" />" />
					<input type="hidden" name="cloudContext.vo.labId"
						value="<s:property value="#request.cloudContext.vo.labId" />" />
					<input type="hidden" name="cloudContext.vo.name"
						value="<s:property value="#request.cloudContext.vo.name" />" />
					<input type="hidden" name="cloudContext.vo.desc"
						value="<s:property value="#request.cloudContext.vo.model" />" />
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

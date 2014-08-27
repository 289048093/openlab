<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cloudking.openlab.PropertyManager"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.cloudking.openlab.util.StringUtil"%>
<%@page import="com.cloudking.openlab.SessionListener"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
    String srcPath = request.getParameter("path");
    if (StringUtil.isBlank(srcPath)) {
        srcPath = (String) request.getAttribute("path");
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<decorator:usePage id="decoratedPage" />
<html>
	<head>
		<base href="<%=basePath%>">

		<title><decorator:title default="深圳市大学城管理平台" />
		</title>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<link rel="stylesheet" href="css/top_css.css" type="text/css"></link>
		<link rel="stylesheet" href="css/login_dialog.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery.drag.js"></script>
		<script type="text/javascript" src="decorators/commonlogin.js"></script>
		<script type="text/javascript">
			$(function(){
				var $db = $('.ck_dialog_login_body');
				$db.css('margin-left',-$db.width()/2+'px');
				$db.css('margin-top',-$db.height()/2+'px');
			});
			window.basePath = "<%=basePath%>";
		</script>
		<decorator:head />
	</head>
	<body>
		<div class="main">
			<!-- 头部：logo，导航 -->
			<div id="top" align="center">
				<img src="images/big_logo3_6.png" border="0"></img>
				<div class="dh_">
					<a href="index.jsp">首页</a>&nbsp;|&nbsp;
					<a href="newsManager/news!query.action">新闻通知</a>&nbsp;|&nbsp;
					<a href="pointLabManager/pointLab!query.action">重点实验室</a>&nbsp;|&nbsp;
					<a href="commonTechPlatformManager/commonTechPlatform!query.action">公共技术服务平台</a>&nbsp;|&nbsp;
					<a href="equipmentManager/equipment!query.action">仪器设备</a>&nbsp;|&nbsp;
					<a href="industryTestManager/industryTest!query.action">行业检测</a>&nbsp;|&nbsp;
					<a href="expertQuestionManager/expertQuestion!query.action">专家咨询</a>&nbsp;|&nbsp;
					<a
						href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!query.action">科研成果与技术转移</a>&nbsp;|&nbsp;
					<a href="policyManager/policy!query.action">政策法规</a>&nbsp;|&nbsp;
					<a href="downloadFileManager/downloadFile!query.action">下载中心</a>
				</div>
			</div>
			<!-- 中部：列表，内容 -->
			<div class="content">
				<decorator:body />
				<div class="b_q">
					深圳大学城开放实验室服务平台 版权所有： 2013 深圳高等教育发展办公室(深圳大学城管理办公室)
					<br>
					地址：深圳市南山区西丽丽水路深圳大学城管理中心大楼(518055) 传真:0755-26032921 粤ICP备06024209号
					<br>
					您是第
					<font color="red"><%=session.getAttribute(PropertyManager.VISITOR_COUNT) %></font>访问者
				</div>
			</div>
		</div>


		<div id="login_dialog" unselectable="on"
			style="-moz-user-select: none; -webkit-user-select: none; display: none; height: 100%; width: 100%;"
			onselectstart="return false;">
			<div class="dialog_mask"></div>
			<form action="userManager/user!validOutLogin.action" method="post"
				onsubmit="ajaxLogin();return false;">
				<input name="cloudContext.params.path" value="<%=srcPath%>"
					type="hidden" id="srcPath">
				<div class="ck_dialog_login_body" id="dialog_login_window_">
					<center>
						<div class="dialog_title" id="dialog_title_">
							大学城开放实验室服务平台登录
						</div>
					</center>
					<div id="loginLoadingContent"
						style="display: none; position: relative; top: 50%; color: white;">
						<img src="images/loading_circle.gif" style="height: 20px;" />
						正在玩命登录中。。。
					</div>
					<div id="loginFormContent">
						<center>
							<table class="dialog_login_table" unselectable="off"
								style="-moz-user-select: text; -webkit-user-select: text;"
								onselectstart="return true;">
								<tr>
									<td>
										<div class="ck_input_label">
											用户名:
										</div>
									</td>
									<td>
										<input type="text" name="cloudContext.vo.username"
											id="dialog_username" class="dialog_form_text" />
										<font class="errorMsg"></font>
									</td>
								</tr>

								<tr>
									<td>
										<div class="ck_input_label">
											密码:
										</div>
									</td>
									<td>
										<input type="password" name="cloudContext.vo.password"
											id="dialog_password" class="dialog_form_text">
										<font class="errorMsg"></font>
									</td>
								</tr>
								<tr>
									<td>
										<div class="ck_input_label">
											验证码:
										</div>
									</td>
									<td>
										<input type="text" name="cloudContext.params.checkCode"
											maxlength="4" id="checkCode" class="dialog_form_text">
										<img id="verifyCode" src="VerifyCode?Math.random()"
											style="top: 5px; position: relative; cursor: pointer;"
											onclick="(function(o){o.src='VerifyCode?n='+Math.random();document.getElementById('checkCode').focus();})(this)" />
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<center>
											<input type="submit" value="" class="dialog_login_button" />
											&nbsp;&nbsp;
											<input type="button" class="dialog_close_button"
												onclick="closeLoginDialog();" />
											<!--<span
																style="font-size: 12px; margin-top: 5px; margin-right: 10px;"><font
																color="gray">|</font>&nbsp;&nbsp;&nbsp;&nbsp;<a
																href="index.jsp">返回首页</a> </span>-->
										</center>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div class="dialog_error_msg">
											<s:if
												test="#request.cloudContext.errorMsgList!=null && #request.cloudContext.errorMsgList.size()>0">
												<s:iterator value="#request.cloudContext.errorMsgList"
													var="msg">
											${msg}
										</s:iterator>
											</s:if>
										</div>
									</td>
								</tr>
							</table>
						</center>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>

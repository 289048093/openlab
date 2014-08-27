<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<decorator:usePage id="decoratedPage" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<style type="text/css">
#loading-mask {
	Z-INDEX: 20000;
	LEFT: 0px;
	WIDTH: 100%;
	POSITION: absolute;
	TOP: 0px;
	HEIGHT: 100%;
	BACKGROUND-COLOR: white
}

#loading {
	PADDING-RIGHT: 2px;
	PADDING-LEFT: 2px;
	Z-INDEX: 20001;
	LEFT: 45%;
	PADDING-BOTTOM: 2px;
	PADDING-TOP: 2px;
	POSITION: absolute;
	TOP: 40%;
	HEIGHT: auto
}

#loading IMG {
	MARGIN-BOTTOM: 5px
}

#loading .loading-indicator {
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	BACKGROUND: white;
	PADDING-BOTTOM: 10px;
	MARGIN: 0px;
	FONT: 12px 宋体, arial, helvetica;
	COLOR: #555;
	PADDING-TOP: 10px;
	HEIGHT: auto;
	TEXT-ALIGN: center
}
</style>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<title><decorator:title default="深圳市深圳大学城开放实验室资源共享平台" /></title>
		<link rel="shortcut icon" href="images/favicon.ico"
			type="image/x-icon" />
		<meta name="title" content="深圳市深圳大学城开放实验室资源共享平台" />
		<meta name="keywords" content="深圳市深圳大学城开放实验室资源共享平台" />
		<link href="css/home[1].css" rel="stylesheet" type="text/css" />
		<link href="css/extend_index[1].css" rel="stylesheet" type="text/css" />
		<link href="css/autoClue[1].css" rel="stylesheet" type="text/css" />
		<link href="css/common_ui[1].css" type="text/css" rel="stylesheet" />
		<link href="css/Admin_new[1].css" rel="stylesheet" type="text/css" />
		<link href="css/pro.css" rel="stylesheet" type="text/css" />
		<link type='text/css' href='css/basic_dialog.css' rel='stylesheet'
			media='screen' />
		<style type="text/css">
body {
	background: url("images/bg[1].jpg") no-repeat scroll center top
		transparent;
}
</style>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js">
</script>
		<script type="text/javascript" src="js/jquery.simplemodal.js">
</script>
		<script type="text/javascript" src="js/simplemodal_wrapper.js">
</script>
		<script type="text/javascript" src="js/CkGobal.js">
</script>
		<script type="text/javascript">
<!--
	  function showLocale(objD){
			 var yy = objD.getFullYear();
			 var MM = objD.getMonth()+1;
			 if(MM<10){
			 	MM = '0' + MM;
			 }
			 var dd = objD.getDate();
			 if(dd<10){ 
			 	dd = '0' + dd;
			 }
			 var hh = objD.getHours();
			 var hour=objD.getHours();
			 if(hh<10){
			 	 hh = '0' + hh;
			 }
			 var mm = objD.getMinutes();
			 if(mm<10){
			 	mm = '0' + mm;
			 }
			 var ss = objD.getSeconds();
			 if(ss<10){
				 ss = '0' + ss;
			 }
			 var ww = objD.getDay();
			 if  (ww==0){ 
			 	ww="星期日";
			 }else if  (ww==1){
			 	ww="星期一";
			 }else if  (ww==2){
			 	ww="星期二";
			 }else if  (ww==3){
			 	ww="星期三";
			 }else if  (ww==4){
			 	ww="星期四";
			 }else if  (ww==5){
			 	ww="星期五";
			 }else if (ww==6){
			 	ww="星期六";
			 }
			 var hello="";
			 if(hour < 6){
			 	hello="凌晨好";
			 }else if (hour < 9){
			 	hello="早上好";
			 }else if (hour < 12){
			 	hello="上午好";
			 }else if (hour < 14){
			 	hello="中午好";
			 }else if (hour < 17){
			 	hello="下午好";
			 }else if (hour < 19){
			 	hello="傍晚好";
			 }else if (hour < 22){
			 	hello="晚上好";
			 }else {
			 	hello="夜里好";
			 }
			 var session_realname= $("#session_realnameId").val();
			 //下午好,开发人员! 今天是:2011-08-10 星期三 
			  var str =hello+"，"+session_realname+"！ 今天是："+yy + "-" + MM + "-" + dd+" "+ww + " " + hh + ":" + mm + ":" + ss ;
			 return str;
			}
			function tick(){
			 $("#realTime").html(showLocale(new Date()));
			 window.setTimeout("tick()", 1000);
			}
			
			

	$(function(){
		tick();
	});

//-->
</script>
		<decorator:head />
	</head>
	<body>
		<!--注册-->
		<div id="loginhead">
			<div class="top">
				<div style="width: 990px; margin 0 auto; padding-top: 5px;"
					class="reg">
					<ul id="login">
						<li class="r1">
							用户名：
						</li>
						<li class="r2">
							<input type="text" class="iput-reg" id="user" name="user" />
						</li>
						<li class="r1">
							密码：
						</li>
						<li class="r2">
							<input type="password" class="iput-reg" id="pass" name="pass" />
						</li>
						<li class="r1">
							验证码：
						</li>
						<li>
							<input type="text" name="validateCode" id="validateCode" value=""
								class="iput-validata" />
						</li>
						<li id="captchaImageLi" style="position: relative;">
							<img id="verifyCode" src="VerifyCode?Math.random()"
								style="cursor: pointer; border: 2px solid white; height: 18px; width: 60px; margin-left: 3px;" />
						</li>
						<li class="w12">
							<a href="" id="submit1">登录</a>
						</li>
						<li class="w12">
							<a href="#" id="submit2">忘记密码</a>
						</li>

						<li class="w12" style="float: right;">
							<a href="#">帮助中心</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!--搜索-->
		<div class="t2">
			<div class="logo">
				<img style="margin-top: 20px;" src="images/logo[1].png" />
			</div>
			<div class="search">
				<ul>
					<li class="s1">
						<div id="inputclue">
							<input type="text" id="txt" />
							<ul id="clue" style="display: none;">
							</ul>
						</div>
					</li>
					<li class="s2">
						<a id="searchButton" href="">搜索</a>
					</li>
				</ul>
			</div>
		</div>

		<!--导航-->
		<div class="nav">
			<ul>
				<li class="menu1">
					<a href="javascript:;">首页</a>
				</li>
				<li class="menu1">
					<a href="javascript:;">资源管理</a>
				</li>
				<li class="menu1">
					<a href="javascript:;">业务管理</a>
				</li>
				<li class="menu1">
					<a href="javascript:;">科研问答天地</a>
				</li>
				<li class="menu1">
					<a href="javascript:;">资讯速递</a>
				</li>

			</ul>
		</div>
		<div class="pro">
			<div class="pro_left">
				<ul>
					<li>
						<span class="pro_span">快速通道</span>
					</li>
					<li>
						<a href="#">仪器设备</a>
					</li>
					<li>
						<a href="#">科研人才</a>
					</li>
					<li>
						<a href="#">文献书库</a>
					</li>
					<li>
						<a href="#">信息维护</a>
					</li>
				</ul>
			</div>
		</div>

		<decorator:body />
		<!--页脚-->
		<div class="footer">
			版权所有 © 2012 深圳市云景科技有限公司. 保留所有权利. 深圳市云景科技有限公司 粤ICP备11012869号
			<br />
			深圳市深圳大学城开放实验室资源共享平台
		</div>

		<!-- modal content -->
		<div id="basic-modal-content" unselectable="on"
			style="-moz-user-select: none; -webkit-user-select: none;"
			onselectstart="return false;">
			<div id="basic_dialog_title">
				对话框
			</div>
			<div id="basic_dialog_content" style="height: 100%">
				<form id="basic_dialog_form">
					<div id="dialog_form_content"></div>
				</form>
			</div>
			<div id="basic_dialog_operate">
				<span id="basic_dialog_confirm">确定</span>
				<span id="basic_dialog_cancel">取消</span>
			</div>
		</div>
	</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cloudking.openlab.util.StringUtil"%>
<%@page import="com.cloudking.openlab.util.Constant"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String srcPath2 = request.getParameter("path");
	if (StringUtil.isBlank(srcPath2)) {
		srcPath2 = (String) request.getAttribute("path");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>首页</title>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/index.css">
		<link rel="stylesheet" type="text/css" href="css/imageslide.css">
		<STYLE type="text/css">
.linkCenter:hover {
	text-decoration: none;
}
</STYLE>
		<s:if test="#request.cloudContext.vo!=null">
		</s:if>
		<s:else>
			<script type="text/javascript">
				window.location.href="openlab/indexManager/index!viewIndexContent.action";
			</script>
		</s:else>
		<script type="text/javascript">var noticeCatId = "<%=Constant.NEWS_NOTICE_ID %>";</script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="js/jQuery.textSlider.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript" src="slider.js"></script>

	</head>
	<body>
		<div class="content_img" id="content_img">
		</div>
		<div class="content_main">
			<div class="content_main_title">
				<span id="span_title1"  class="content_main_title1">新闻动态</span>
				<span id="span_title2" class="content_main_title2">通知公告</span>
				<span id="span_title3" class="content_main_title2">政策法规</span>
				<a id="span_title_more"
					href="newsManager/news!query.action?cloudContext.params.catId=<%=Constant.NEWS_NOTICE_ID%>"
					class="content_main_title_more">更多&gt;&gt;</a>
			</div>
			<div id="content_main_list" class="content_main_list">
				<ul class="content_main_list_ul">
					<s:iterator value="cloudContext.vo.newsList">
						<li>
							<a
								href="newsManager/news!detail.action?cloudContext.vo.id=<s:property value="id"/>">
								<s:property value="title" /> </a>
						</li>
					</s:iterator>
				</ul>
				<ul class="content_main_list_ul" style="display: none;">
					<s:iterator value="cloudContext.vo.newsNoticeList">
						<li>
							<a
								href="newsManager/news!detail.action?cloudContext.vo.id=<s:property value="id"/>">
								<s:property value="title" /> </a>
						</li>
					</s:iterator>
				</ul>
				<ul class="content_main_list_ul" style="display: none;">
					<s:iterator value="cloudContext.vo.policyList">
						<li>
							<a
								href="policyManager/policy!detail.action?cloudContext.vo.id=<s:property value="id"/>">
								<s:property value="title" /> </a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="content_user">
			<div style="margin-top: 40px;" align="center">
				<s:if test="#attr.userLogin.realname!=''">
					<div>
						欢迎你:
						<font style="color: red;">${userLogin.realname}</font>
						<a href="userManager/user!logout.action">注销</a>
					</div>
					<div class="personCenter">
						<hr style="border-color: skyBlue;">
						<div class="title"
							style="height: 30px; line-height: 30px; border-bottom: 1px solid whiteSmoke; white-space: nowrap;">
							<span style="float: left; padding-left: 15px;"><a
								href="userCenter/main.jsp" style="font-size: 14px;">个人中心</a> </span>
						</div>
						<div class="cen" style="padding-top: 12px;">
							<ul class="user_center_news">
								<li>
									<a href="userCenter/main.jsp?linkFlag=3" target="_blank"
										class="linkCenter"> <s:if
											test="cloudContext.params.loginUserExperts!=null">
											<span class="tg_num"><s:property
													value="cloudContext.params.loginUserExperts" /> </span>
											<br />
											<br />
											<span> 未读信息 </span>
										</s:if> <s:else>
											<span class="tg_num">0</span>
											<br />
											<br />
											<span>未读信息</span>
										</s:else> </a>
								</li>
								<li>
									<a href="userCenter/main.jsp?linkFlag=1" target="_blank"
										class="linkCenter"> <s:if
											test="cloudContext.vo.applyOrderVO.size()!=0">
											<span class="tg_num"><s:property
													value="cloudContext.vo.applyOrderVO.size()" /> </span>
											<br />
											<br />
											<span>仪器订单</span>
										</s:if> <s:else>
											<span class="tg_num">0</span>
											<br />
											<br />
											<span>仪器订单</span>
										</s:else> </a>
								</li>
								<li>
									<a href="userCenter/main.jsp?linkFlag=2" target="_blank"
										class="linkCenter"> <s:if
											test="cloudContext.vo.applyOrderVOIndustryTest.size()!=0">
											<span class="tg_num"><s:property
													value="cloudContext.vo.applyOrderVOIndustryTest.size()" />
											</span>
											<br />
											<br />
											<span>检测订单</span>
										</s:if> <s:else>
											<span class="tg_num">0</span>
											<br />
											<br />
											<span>检测订单</span>
										</s:else> </a>
								</li>
							</ul>
						</div>
					</div>
				</s:if>
				<s:else>
					<form action="userManager/user!validOutLogin.action" method="post" onsubmit="return yzAll()">
						<input name="cloudContext.params.path" value='<%=srcPath2%>'
							type="hidden" />
						<table class="login_table" style="font-size: 12px;" border="0">
							<tr>
								<td style="width: 40px;">

									用户名:
								</td>
								<td>
									<input type="text" name="cloudContext.vo.username"
										id="username" onblur="jyUsername()" class="form_text" maxlength="20" style="width: 120px;" />
								</td>
							</tr>
							<tr>
								<td>
									密码:
								</td>
								<td>
									<input type="password" name="cloudContext.vo.password"
										id="password" onblur="jyPassWord()" class="form_text" style="width: 120px;">
								</td>
							</tr>
							<tr>
								<td>

									验证码:

								</td>
								<td>
									<input type="text" name="cloudContext.params.checkCode"
										maxlength="4" onblur="jyYZM()" id="checkCode" class="form_text"
										style="width: 60px;">
									<img id="verifyCode" src="VerifyCode?Math.random()"
										style="top: 5px; position: relative; cursor: pointer;"
										onclick="(function(o){o.src='VerifyCode?n='+Math.random();document.getElementById('checkCode').focus();})(this)" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<center>
										<div class="error_msg" align="center" style="color: red;">
											<s:if
												test="#request.cloudContext.errorMsgList!=null && #request.cloudContext.errorMsgList.size()>0">
												<s:iterator value="#request.cloudContext.errorMsgList"
													var="msg">
											${msg}
										</s:iterator>
											</s:if>
										</div>
										<input type="submit" value="登录" class="login_button" />
										&nbsp;|&nbsp;
										<a href="user/reset_password.jsp">忘记密码</a>
										<br>
										校外用户？
										<a href="register/register.jsp">立即注册</a><a href="#">
										<!-- <img
												src="images/help.png" title="帮助" alt="帮助"
												style="width: 20px; position: relative; top: 5px; border: 0px;"> -->
										</a>
									</center>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" style="color: red;" id="loginError">
									
								</td>
							</tr>
						</table>
					</form>
				</s:else>
			</div>
		</div>
		<div class="content_foot">
			<div class="content_foot_left">
				<div class="content_foot_left_title">
					<span>平台统计</span>
				</div>
				<div class="content_foot_left_list">
					<ul class="content_foot_left_list_ul">
						<s:iterator value="cloudContext.vo.equipmentStatList"
							var="statStr">
							<li>
								<s:property value="statStr" />
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="content_foot_center">
				<div class="content_foot_center_title">
					<span class="ss_title1" id="ss_equipment">仪器设备</span>
					<span class="ss_title2" id="ss_literature">科技文献</span>
				</div>
				<div class="content_foot_center_select" id="select_equipment">
					<form action="equipmentManager/equipment!query.action"
						method="post">
						<div class="equipment_cat" id="equipment_cats">
							<s:if
								test="cloudContext.vo.equipmentCatList!=null&&cloudContext.vo.equipmentCatList.size>0">
								<span> <a style="color: black; font-weight: bold;"
									href="javascript:;" onclick="set_noequipmentCat(this)">全部</a> </span>
								<s:if test="cloudContext.vo.equipmentCatList.size>3">
									<s:iterator value="cloudContext.vo.equipmentCatList" begin="0"
										end="2">
										<span> <a href="javascript:;"
											onclick="set_equipmentCat(<s:property value="id"/>,this)">
												<s:property value="name" /> </a> </span>
									</s:iterator>
								</s:if>
								<s:else>
									<s:iterator value="cloudContext.vo.equipmentCatList">
										<span> <a href="javascript:;"
											onclick="set_equipmentCat(<s:property value="id"/>,this)">
												<s:property value="name" /> </a> </span>
									</s:iterator>
								</s:else>

							</s:if>
							<span> <a href="equipmentManager/equipment!query.action">更多&gt;&gt;</a>
							</span>
						</div>
						<div class="ss_div">
							<img src="images/fdj.png"></img>
							<input name="cloudContext.vo.name" type="text" class="ss_input" />
							<input type="hidden" name="cloudContext.vo.catId"
								id="equipment_catId" />
							<input type="submit" class="ss_but" value="搜索">
						</div>
					</form>
				</div>
				<div class="content_foot_center_select" id="select_literature"
					style="display: none; width: 450px; overflow: hidden;">
					<iframe src="literature/sz_duxiu_.jsp" frameborder="0"
						scrolling="no" class="cr_ifrom" style=""></iframe>
				</div>
			</div>
			<div class="content_foot_right" style="overflow: hidden;">
				<div class="content_foot_right_title">
					<span>专家团队</span>
					<a id="span_title_more" style="float: none; margin-left: 70px;"
						href="expertQuestionManager/expertQuestion!query.action"
						class="content_main_title_more">更多&gt;&gt;</a>
				</div>
				<div style="overflow: hidden; height: 120px;" id="ExpertsShow">
					<ul style="list-style-type: none; padding: 0px; margin: 0px;">
						<s:if
							test="cloudContext.vo.viewExperts!=null && cloudContext.vo.viewExperts.size>0">
							<s:iterator value="cloudContext.vo.viewExperts">
								<li style="height: 120px;">
									<!-- 单个专家的信息》开始 -->
									<div>
										<div style="float: left; margin: 5px;">
											<a href="expertQuestionManager/expertQuestion!oneExpert.action?cloudContext.vo.expertId=<s:property  value="id" />"
												title="点击查看专家详情">
												<img
													src="<s:property  value="headPic"  />"
													width="74px;" height="98px;"></img> </a>
										</div>

										<div style="padding-top: 10px; height: 120px;">
											<table style="font-size: 12px;">
												<tr>
													<td>
														姓名：
													</td>
													<td >
													<div class="expert_field"><s:property value="realname" /></div>
													</td>
												</tr>
												<tr>
													<td>
														性别：
													</td>
													<td class="expert_field">
														<div class="expert_field"><s:if test="sex==0">女</s:if>
														<s:else>男</s:else></div>
													</td>
												</tr>
												<tr>
													<td>
														职称：
													</td>
													<td class="expert_field" title="<s:property value="title" />">
													<div class="expert_field"><s:property value="title" /></div>
														
													</td>
												</tr>
												<tr>
													<td >
														<span style=" white-space: nowrap; float: left;">
															擅长领域：
														</span>
													</td >
													<td class="expert_field" title="<s:property value="researchArea" />">
														<div class="expert_field">
															<s:if test="researchArea.length()>5">
																<s:property value="researchArea.substring(0,5)"/>
															</s:if>	
														</div>
													</td>
												</tr>
												<s:if test="researchArea.length()>5">
													<tr>
														<td colspan="2" title="<s:property value="researchArea" />">
															<div class="newexpert_field"><s:property value="researchArea.substring(5)"/></div>
														</td>
													</tr>
												</s:if>
											</table>
										</div>
									</div>
									<!-- 单个专家的信息》结束 -->
								</li>
							</s:iterator>
						</s:if>
					</ul>
				</div>
			</div>
			<div class="content_tm">
				<div class="content_tm_left">
					<div class="content_foot_left_title">
						<span>最新录入仪器信息</span>
						<a href="equipmentManager/equipment!query.action"
							style="float: none; margin-left: 92px;"
							class="content_main_title_more">更多&gt;&gt;</a>
					</div>
					<div class="content_tm_left_zd">
						<div class="content_tm_left_zd_img">
							<img src="<s:property value='cloudContext.vo.equipmentVO.pic' />"
								width="100%" height="100%" alt="暂无图片" title=""></img>
						</div>
						<div class="content_tm_left_zd_jj">
							<span> <a
								href="equipmentManager/equipment!queryById.action?cloudContext.vo.id=<s:property value="cloudContext.vo.equipmentVO.id" />">
									<s:property value="cloudContext.vo.equipmentVO.name" /> </a> </span>
							<br>
							<span><s:property
									value="cloudContext.vo.equipmentVO.producer" /> </span>
							<br>
							<span><s:property
									value="cloudContext.vo.equipmentVO.model" /> </span>
						</div>
					</div>
					<div class="content_tm_left_list">
						<ul class="content_foot_left_list_ul">
							<s:iterator value="cloudContext.vo.equipmentVoList">
								<li>
									<a
										href="equipmentManager/equipment!queryById.action?cloudContext.vo.id=<s:property value="id" />">
										<s:property value="name" /> </a>
								</li>
							</s:iterator>

						</ul>
					</div>
				</div>
				<div class="content_tm_cneter">
					<div class="content_foot_left_title">
						<span>科研成果</span>
						<a style="float: none; margin-left: 310px;"
							href="techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!query.action"
							class="content_main_title_more">更多&gt;&gt;</a>
					</div>
					<div id="scrollDiv" class="content_foot_left_list">
						<ul class="content_foot_left_list_ul">
							<s:if test="cloudContext.vo.researchAhieveList!=null">
								<s:iterator value="cloudContext.vo.researchAhieveList">
									<li>
										<a
											href="href='techTransferAndResearchAchieveManager/techTransferAndResearchAchieve!researchAchieveDetail.action?cloudContext.vo.id=<s:property value="id"/>">
											<s:property value="name" /> </a>
									</li>
								</s:iterator>
							</s:if>
						</ul>
					</div>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
					    $("#scrollDiv").textSlider({line:1,speed:1000,timer:3600});
					    $("#ExpertsShow").textSlider({line:1,speed:2000,timer:<s:property value="cloudContext.params.expertChangeTime"/>});
					});
				</script>
				
				<div class="content_tm_right">
					<div class="content_foot_right_title">
						<span>仪器服务排名</span>
					</div>
					<div class="content_foot_right_list">
						<table align="center" width="200px;">
							<tr>
								<td>
									<span>设备名称</span>
								</td>
								<td>
									<span>服务次数</span>
								</td>
							</tr>
							<s:if test="cloudContext.params.fwph!=null">
								<s:iterator value="cloudContext.params.fwph">
									<tr>
										<td width="160px;">
											<div style="width: 140px;" class="more_font" title="<s:property value="key"/>"><s:property value="key"/> </div>
										</td>
										<td>
											<s:property value="value"/> 
										</td>
									</tr>
								</s:iterator>
							</s:if>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

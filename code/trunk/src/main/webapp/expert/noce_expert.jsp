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

		<title>仪器设备-列表页面</title>
		<link rel="stylesheet" type="text/css" href="css/expert_list.css">
		<SCRIPT type="text/javascript" src="expert/expert_list.js"></SCRIPT>
		
	</head>

	<body>
		<div class="content_list">
			<div class="content_list_title" style="text-align: center;">
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
			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title">
					历史问答记录
				</div>
				<ul class="content_list_list_sys_title_ul">
					<s:if
						test="cloudContext.params.historyexperts!=null && cloudContext.params.historyexperts.size>0">
						<s:iterator value="cloudContext.params.historyexperts">
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
				<span id="title">首页-&gt;专家咨询</span>
			</div>
			<div class="content_body_list">
				<form action="expertQuestionManager/expertQuestion!query.action"
					id="myform" method="post">
					<div class="content_body_list_title">
						专家风采
					</div>
					<div class="content_body_list_experts">
						<s:if
							test="cloudContext.params.expertusers!=null && cloudContext.params.expertusers.size>0">
							<s:iterator value="cloudContext.params.expertusers">
								<div class="content_body_list_expert">
									<div style="width: 100%; float: left;">
										<div style="float: left; margin: 5px;">
											<img src="<s:property value="headPic" />"
												height="98px;"></img>
										</div>
										<table style="font-size: 12px; margin-top: 5px;">
											<tr>
												<td>
													姓名：
												</td>
												<td width="160px;">
													<s:property value="realname" />
												</td>
											</tr>
											<tr>
												<td>
													性别：
												</td>
												<td>
													<s:if test="sex==0">女</s:if><s:else>男</s:else>
												</td>
											</tr>
											<tr>
												<td>
													职称：
												</td>
												<td>
													<s:property value="title" />
												</td>
											</tr>
											<tr>
												<td>
													擅长领域：
												</td>
												<td>
													<s:property value="researchArea" />
													<s:set var="expertId" value="id"></s:set>
												</td>
											</tr>
											<tr>
												<td rowspan="2">
													<a href="javascript:void(0)" onclick="goIaswer(<s:property value="id" />);">
														<input type="button" value="对他提问">
													</a>
												</td>
											</tr>
										</table>
									</div>
									<div
										style="width: 98%; line-height: 20px; text-align: left; margin-top: 5px;margin-left: 10px;">
										<span>简介:</span>
										<br />
										<font style="font-size: 12px;">&nbsp;&nbsp; <s:property value="desc" /> </font>
									</div>
								</div>
							</s:iterator>
						</s:if>
						<s:else>
						没有专家信息
					</s:else>
					</div>
				</form>
			</div>
			<div class="content_body_tw">
				<div class="content_body_list_title">
					<a id="Iaswear" name="Iaswear">我要提问</a>
				</div>
				<div class="content_body_tw_mywt">
					<form action="expertQuestionManager/expertQuestion!addExpertQuestion.action" onsubmit="return whenSubmit()" method="post">
						<table>
							<tr>
								<td>
									标题：
								</td>
								<td>
									<input name="cloudContext.vo.title" id="questionTitle" type="text" />
									<span id="questionTitleyz" class="redColor"></span>
								</td>
							</tr>
							<tr>
								<td>
									回答专家：
								</td>
								<td>
									<select name="cloudContext.vo.expertId" id="selectExpertid" >
									<option value="0">请选择</option>
										<s:if
											test="cloudContext.params.expertusers!=null && cloudContext.params.expertusers.size>0">
											<s:iterator value="cloudContext.params.expertusers">
												<option value="<s:property value='id'/>"><s:property value="realname"/></option>
											</s:iterator>
										</s:if>
										<s:else>
											<option value="0">没有专家</option>
										</s:else>
									</select>
									<span id="selectExpertidyz" class="redColor"></span>
								</td>
							</tr>
							<tr>
								<td>
									问题：
								</td>
								<td>
									<textarea name="cloudContext.vo.content" id="questionContent" rows="5" cols="50"></textarea>
									<span id="questionContentyz" class="redColor"></span>
								</td>
							</tr>
							<tr>
								<s:if test="cloudContext.loginedUser == null">
									你还没有登录，请先
									<input type="button" onclick="showLoginDialog('expertQuestionManager/expertQuestion!query.action')" value="登录"/>
								</s:if>
								<s:else>
									<td>
										<input type="reset" value="重置" />
									</td>
									<td>
										<input type="submit" value="提交" />
									</td>
								</s:else>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

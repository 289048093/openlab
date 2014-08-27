<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>问答</title>
		<link rel="stylesheet" type="text/css" href="css/expert_detail.css">
				<script type="text/javascript">
			window.onload=function(){
				var content = '.content_body';
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
				<span>问答天地</span>
			</div>

			<div class="content_list_list_hy">
				<div class="content_list_list_sys_title">
				&nbsp;&nbsp;&nbsp;&nbsp;
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
					&nbsp;&nbsp;&nbsp;&nbsp;
					历史问答记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="expertQuestionManager/expertQuestion!queryAll.action">更多&gt;&gt;</a>
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
				<span id="title">首页 -&gt;问答详情</span>
			</div>
			<div class="content_body_list">
					<s:if test="cloudContext.params.theExpert!=null">
						<div class="content_body_list_title">
							<s:property value="cloudContext.params.theExpert.title"/>
						</div>
						<div class="content_body_list_experts">
							<div class="epertquestion_content">
								<s:property value="cloudContext.params.theExpert.content" escape="false"/>
							</div>
							<div style="text-align: right;">
								<span>楼主</span>&nbsp;&nbsp;
								<span><s:property value="cloudContext.params.theExpert.questionerName"/></span>&nbsp;&nbsp;
								<span><s:property value="cloudContext.params.theExpert.addDate"/></span> 
							</div>
						</div>
					</s:if>
					<s:if test="cloudContext.params.experthds!=null && cloudContext.params.experthds.size>0">
						<s:iterator value="cloudContext.params.experthds" status="eaindex">
							<div class="content_body_list_experts">
								<div class="epertquestion_content">
									<s:property value="content" escape="false"/>
								</div>
								<div style="text-align: right;">
									<span>第${eaindex.index+1 }楼</span>&nbsp;&nbsp;
									<span><s:property value="answererName"/></span>&nbsp;&nbsp;
									<span><s:property value="addDate"/></span> 
								</div>
							</div>
						</s:iterator>
					</s:if>
					<s:else>
						<div class="content_body_list_experts">
							<div class="epertquestion_content">
								还没有人回答
							</div>
						</div>
					</s:else>
			</div>
		</div>
	</body>
</html>

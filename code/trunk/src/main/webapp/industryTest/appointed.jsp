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
		<title>行业检测预约</title>
			<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<link rel="stylesheet"
			href="css/jquery/jquery-ui-1.10.3.custom.min.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js">
</script>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<script language="javascript" type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js">
</script>
		<script type="text/javascript"
			src="<%=basePath%>js/appointed_check.js">
</script>
		<script type="text/javascript" src="js/jquery.drag.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
		<style type="text/css">
.errMsg,.tMsg {
	color: red;
}
</style>
<script type="text/javascript">
$(function() {
var subBenginDateList=null;
	checkLogin();
	 //当选择“--其他--”是在其后出现文本输入框
		       $("select").change(function(){
		           var value=$("#selectId").val();
		           if(value==null||value==""){
		              $("#inputId").css("display","inline");
		           }else{
		              $("#inputId").css("display","none");
		           }
		       })
		       });
		       
		         //验证是否已登录
	function checkLogin(){
		var s="${cloudContext.loginedUser}";
		if(s==null || s==""){
			validSuccess=false;
			showLoginDialog("#");		
		}	
	}
	//关闭弹出窗
	$('#close').live("click",function(){
	$("#dialog").hide();
	});
		//选择时间后的事件
	function dateOnpicked(){
	var date=getDate($(this).val());
	var subEndDate = $('#subEndDate').val();
	var subBeginDate = $('#subBeginDate').val();
	$('#dialog').hide();
	var DateList=[];
	if(subBenginDateList){
	successDate=true;
	for(var i=0;i<subBenginDateList.length;i++){
    //alert($(this).val()+"======"+subBenginDateList[i].subBeginDate.replace("T"," ")+"======"+subBenginDateList[i].subEndDate.replace("T"," "));
	 var startTmp=getDate(subBenginDateList[i].subBeginDate.replace("T"," "));
	 var endTmp=getDate(subBenginDateList[i].subEndDate.replace("T"," "));
	if((date>=startTmp && date<=endTmp)){
	successDate=false;
	return;
	}
	}
	if(subEndDate!="" && subBeginDate!=""){
	ajaxDateTmp(subBeginDate,subEndDate);
	}
	}
	}
		function ajaxDateTmp(startDate,endDate){
		var  industryTestId=$("#industryTestId").val();
		$.ajax({
		type:"post",
			url : 'applyOrderManager/applyOrder!findDayOrderByIndustryTest.action',
		data : {
			"cloudContext.vo.industryTestId" :industryTestId,
			"cloudContext.vo.subBeginDateStr" :startDate,
			"cloudContext.vo.subEndDateStr" :endDate,
			"cloudContext.vo.desc" :""
			
		},
      	success : function(data) {	
			var res = data.cloudContext;
			var orders=res.params.orders;
            if(orders &&  orders.length>0){
            successDate=false;
		   $(".tMsg").html("*您选择的时间已被占用!!!");
		  	}
		
		},
		error:function(){
			alert('服务器连接失败');
		}
	});
	}
	function ajaxDate(date){
	var  industryTestId=$("#industryTestId").val();
	$.ajax({
		type:"post",
		url : 'applyOrderManager/applyOrder!findDayOrderByIndustryTest.action',
		data : {
			"cloudContext.vo.industryTestId" :industryTestId,
			"cloudContext.vo.desc" :date
		},
      	success : function(data) {	
			var res = data.cloudContext;
			var orders=res.params.orders;
			subBenginDateList=orders;
            if(orders &&  orders.length>0){
			createTb(orders);
			}else{
			$('#dialog').hide();
			}
		
		},
		error:function(){
			alert('服务器连接失败');
		}
	});
	}
	//选择日期事件
	function cDayFunc(){
	var c=$dp.cal;
	var date=c.newdate['y']+"-"+c.newdate['M']+"-"+c.newdate['d'];
	ajaxDate(date);
		
	}
	
	//创建tr
	function createTb(orders){
	var tb=$("#tb");
	tb.html("");	
	for(var i=0;i<orders.length;i++){
	var tr="<tr><td>"+orders[i].subBeginDate.replace("T"," ")+"</td><td>"+orders[i].subEndDate.replace("T"," ")+"</td></tr>"
    tb.append(tr);
	}
	$dp.show();
	//设置css
	var left=$("#Wate").offset().left;
	var top=$("#Wate").offset().top;
    left =parseFloat(left)+parseFloat(183);
	$('#dialog').css({"left":left,"top":top,position:"absolute",overflow:"auto"});
	$('#dialog').show();
	
	}
		var nodeId;
	//显示选择日期的控件
	function showDatePicker(node){
	    nodeId=node.id;
		var picker = WdatePicker({startDate:'%y-%M-%d %H:%m:00',minDate:'%y-%M-%d %H:%m:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:false,dchanging:cDayFunc,isShowClear:false, isShowToday:false,onpicked:dateOnpicked});
	}

        </script>		
<style type="text/css">
#dialog {
	display: none;
	width: 250px;
	height: 220px;
	background-color: #f1fafa;
	border: 1px solid black;
	overflow: auto;
}

#tb {
	font-size: 12px;
}
</style>
	</head>
	<body>
		<div class="content_body" style="width: 99%">
			<div class="content_body_title">
				<img src="images/dh.gif" />
				<span>首页 -> 行业检测->行业检测预约->填写行业检测预约信息</span>
			</div>
			<div class="content_body_list">
				<!-- 弹出窗口 -->
				<div id="dialog" title="已预约的时间" >
					<table style="width: 100%" align="center">
						<tr>
						<tr>
							<td colspan="2" class="content_body_title">
								<div style="float: left; ">已预约的时间</div>
								<a href="javascript:void(0)" style="float: right;" id="close"><img
										src="images/20080528160817678.png" border="0"/>
								</a>
							</td>
						</tr>
						<tr>
							<td style="font-size:12px;">
								开始时间
							</td>
							<td style="font-size: 12px;">
								结束时间
							</td>

						</tr>
						<tbody id="tb">


						</tbody>
					</table>
				</div>
				<form id="form1" name="form1" method="post"
					action="applyOrderManager/applyOrder!appinted.action"
					onsubmit="return check()">
					<table width="680" align="center" cellpadding="2" cellspacing="1"
						bgcolor="#b5d6e6" class="content_body_list_table">
						<tr>
							<td height="22" colspan="4" align="center" bgcolor="#f1fafa">
								服务方信息
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								承接单位
							</td>
							<td height="22" colspan="3" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.undertakeUnit}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								负责人
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.principal}
							</td>
							<td width="98" height="22" align="center" bgcolor="#F1FAFA">
								电话
							</td>
							<td width="205" height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.phone}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								邮箱
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF"
								colspan="3">
								${cloudContext.vo.email}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								行业检测名称
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.name}
							</td>
							<td height="22" align="center" bgcolor="#f1fafa">
								领域
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF">
								<select style="width: 122px;" name="cloudContext.vo.area"
									id="selectId">
									<s:iterator value="cloudContext.params.area" var="area">
										<!--   -->
										<s:if
											test="#request.area.id == #request.cloudContext.vo.industryTestcatId">
											<option value="${area.name}" selected="selected">
												${area.name}
											</option>
										</s:if>
										<s:else>
											<option value="${area.name}">
												${area.name}
											</option>
										</s:else>
									</s:iterator>
									<option value="">
										--其他--
									</option>
								</select>
								<input type="text" name="cloudContext.vo.area" style="display: none;"
									id="inputId" />
								<!--<s:property value="#request.cloudConext.vo.industryTestcatId" /> #area.id == ${cloudContext.vo.industryTestcatId} -->
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								产品
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.product}
							</td>
							<td width="98" height="22" align="center" bgcolor="#F1FAFA">
								项目
							</td>
							<td width="205" height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.vo.project}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								内容
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF"
								colspan="3">
								<s:property value="#request.cloudContext.vo.content"
									escape="false" />
							</td>
						</tr>
						<tr>
							<td height="22" colspan="4" align="center" bgcolor="#f1fafa">
								申请方信息
							</td>
						</tr>
						<tr>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								申请人姓名
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.realname}
							</td>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								单位
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.company}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								地址
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.addr}
							</td>
							<td height="22" align="center" bgcolor="#F1FAFA">
								E-mail
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.email}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								手机
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.mobilePhone}
							</td>
							<td height="22" align="center" bgcolor="#F1FAFA">
								联系电话
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.telPhone}
							</td>
						</tr>
						<tr>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								开始时间
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								<input type="text" onfocus="showDatePicker(this);" class="Wdate"
									style="width: 150px" name="cloudContext.vo.subBeginDate"
									id="subBeginDate" readonly="readonly" 
								/>
								<span class="errMsg">*</span>
							</td>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								结束时间
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								<input type="text"
									onfocus="showDatePicker(this);"
									class="Wdate" style="width: 150px"
									name="cloudContext.vo.subEndDate" id="subEndDate"
									readonly="readonly" />
								<span class="errMsg">* </span>
						</tr>
						<tr>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								是否接受管理员调整时间
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF" colspan="3">
								<input type="radio" value="0" name="cloudContext.vo.adjust"
									checked="checked">
								是
								<input type="radio" value="1" name="cloudContext.vo.adjust">
								否
							</td>
						</tr>
						<tr>
							<td width="89" height="22" align="center" bgcolor="#f1fafa">
								检测需求
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF" colspan="3">
								<textarea name="cloudContext.vo.desc" style="width: 100%;"
									rows="3"></textarea>
							</td>
						</tr>
						<tr>
							<td height="50" colspan="4" align="center" bgcolor="#FFFFFF">
								<input name="cloudContext.vo.industryTestId" type="hidden"
									 value="${cloudContext.vo.id}" id="industryTestId"/>
								<input name="button" type="submit" class="btn" id="button"
									value=" 确 定 " />
								<span class="tMsg"></span>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>

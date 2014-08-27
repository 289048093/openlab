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

		<title>仪器设备-预约页面</title>

		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
		<link rel="stylesheet"
			href="css/jquery/jquery-ui-1.10.3.custom.min.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js">
</script>
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
//验证这个设备是否可以在本系统预约
$(function(){
	var thereurl = $('#thereUrl').val();
	if(!!thereurl){
		location.href =thereurl;
	}
});

$(function() {
var subBenginDateList=null;
	checkLogin();

	
<!--	 $('#dialog').dialog({-->
<!--     autoOpen: false,//如果设置为true，则默认页面加载完毕后，就自动弹出对话框；相反则处理hidden状态。 -->
<!--  	 bgiframe: true, //解决ie6中遮罩层盖不住select的问题 -->
<!--  	 resizable:false, -->
<!--     width: 400,-->
<!--     position: [800,300]-->
<!--    // modal:true,这个就是遮罩效果   -->
<!--    });-->
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
		var  equipmentId=$("#equipmentId").val();
		$.ajax({
		type:"post",
		url : 'applyOrderManager/applyOrder!findDayOrderByEquipment.action',
		data : {
			"cloudContext.vo.equipmentId" :equipmentId,
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
	var  equipmentId=$("#equipmentId").val();
	$.ajax({
		type:"post",
		url : 'applyOrderManager/applyOrder!findDayOrderByEquipment.action',
		data : {
			"cloudContext.vo.equipmentId" :equipmentId,
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
		height: 221px;
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
				<span>首页 -&gt;仪器设备-&gt;仪器设备预约-&gt;填写设备预约信息</span>
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
							<td style="font-size: 12px;">
								开始时间
							</td>
							<td style="font-size:12px;">
								结束时间
							</td>

						</tr>
						<tbody id="tb">


						</tbody>
					</table>
				</div>
				<form method="post"
					action="applyOrderManager/applyOrder!appinted.action"
					onsubmit="return check()">
					<s:token></s:token>
					<table width="680" align="center" cellpadding="2" cellspacing="1"
						bgcolor="#b5d6e6" class="content_body_list_table">

						<tr>
							<td height="22" colspan="4" align="center" bgcolor="#f1fafa">
								服务方信息
							</td>
						</tr>

						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								单位名称
							</td>
							<td height="22" colspan="3" align="left" bgcolor="#FFFFFF">
								<!-- 验证可否在本系统预约申请 -->
								<input id="thereUrl" type="hidden" value="<s:property value="#request.cloudContext.vo.redirectURL" />"/>
								${cloudContext.vo.deptName}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								名称
							</td>
							<td width="265" height="22" align="left" bgcolor="#FFFFFF"
								colspan="3">
								${cloudContext.vo.name}
							</td>
						</tr>
						<tr>
							<td class="content_body_list_table_bt1">
								简介
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF"
								colspan="3">
								<s:property value="#request.cloudContext.vo.desc" escape="false" />

							</td>
						</tr>
						<tr>
							<td class="content_body_list_table_bt1">
								所属实验室/技术平台
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.labName} &nbsp; ${cloudContext.vo.commName}
							</td>

							<td class="content_body_list_table_bt1">
								所属单位
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.deptName}
							</td>
						</tr>
						<tr>
							<td class="content_body_list_table_bt1">
								仪器型号
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.model}
							</td>
							<td class="content_body_list_table_bt1">
								仪器类别
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.catName}
							</td>
						</tr>
						<tr>
							<td class="content_body_list_table_bt1">
								仪器厂商
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.producer}
							</td>
							<td class="content_body_list_table_bt1">
								联系人
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.contact}
							</td>

						</tr>

						<tr>
							<td class="content_body_list_table_bt1">
								联系电话
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								${cloudContext.vo.phone}
							</td>
							<td class="content_body_list_table_bt1">
								购置时间
							</td>
							<td class="content_body_list_table_bt2" bgcolor="#FFFFFF">
								<s:date name="#request.cloudContext.vo.purchaseDate"
									format="yyyy-MM-dd" />
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
								地址
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.addr}
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgcolor="#f1fafa">
								单位
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF">
								${cloudContext.loginedUser.company}
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
									id="subBeginDate" readonly="readonly"  value=""
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
								使用需求
							</td>
							<td height="22" align="left" bgcolor="#FFFFFF" colspan="3">
								<textarea name="cloudContext.vo.desc" style="width: 100%;"
									rows="3"></textarea>
							</td>
						</tr>
						<tr>
							<td height="50" colspan="4" align="center" bgcolor="#FFFFFF">
								<input name="button" type="submit" class="btn" id="button"
									value=" 确 定 " />
								<span class="tMsg"></span>
								<input name="cloudContext.vo.equipmentId" type="hidden"
									id="equipmentId" value="${cloudContext.vo.id}" />
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>

	</body>
</html>

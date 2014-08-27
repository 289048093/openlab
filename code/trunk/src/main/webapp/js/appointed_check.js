var validSuccess = true;
var successDate=true;
$(function() {
	
	var errorBoxSelecter = '.errMsg';
	
	$('#subBeginDate').live('blur', function() {
        var subEndDate = $('#subEndDate').val();
		var subBeginDate = $('#subBeginDate').val();
		var $errorMsg = $('#subBeginDate').siblings('.errMsg');
		var errorMsg = ''
		if (subBeginDate == '' || subBeginDate == null) {
			errorMsg = '开始时间不能为空';
		} else if (subBeginDate == 'undefined') {
			errorMsg = '开始时间格式不正确';

		}else if(subBeginDate){
		if(successDate==false){
		  $(".tMsg").html("*您选择的时间已被占用!!!");
		  }else if(subEndDate && subBeginDate){
		  if (getDate(subBeginDate) >= getDate(subEndDate)) {
		  $(".tMsg").html("*开始时间不能大于或等于结束时间");
		  }else{
		  $(".tMsg").html("");
		  }
		  }else{
		  	errorMsg = '';
		  }
		
		}else if(subEndDate != '' &&  subEndDate != null && subEndDate != 'undefined' && subBeginDate != '' &&  subBeginDate != null && subBeginDate != 'undefined'){
			if (getDate(subBeginDate) >= getDate(subEndDate)) {
			$(".tMsg").html("*开始时间不能大于或等于结束时间");
		} else {
			$(".tMsg").html("");
		}
}
		validSuccess = (errorMsg == '' && validSuccess && $(".tMsg").html()=='');
		if(validSuccess){
			
		}
		$errorMsg.html(errorMsg);
	});

	$('#subEndDate').live('blur', function() {
		var subEndDate = $('#subEndDate').val();
		var subBeginDate = $('#subBeginDate').val();
		var $errorMsg = $('#subEndDate').siblings('.errMsg');
		var errorMsg = ''
		if (subEndDate == '' || subEndDate == null) {
			errorMsg = '结束时间不能为空';
		}else if (subEndDate == 'undefined') {
			errorMsg = '结束时间格式不正确';
		}else if(subEndDate){
		if(successDate==false){
		$(".tMsg").html("*您选择的时间已被占用!!!");
		  }else if(subEndDate && subBeginDate){
		  if (getDate(subBeginDate) >= getDate(subEndDate)) {
		  $(".tMsg").html("*开始时间不能大于或等于结束时间");
		  }else{
		  $(".tMsg").html("");
		  
		  }
		  }else{
		  	errorMsg = '';
		  }
		
		}else if(subEndDate != '' &&  subEndDate != null && subEndDate != 'undefined' && subBeginDate != '' &&  subBeginDate != null && subBeginDate != 'undefined'){
		if (getDate(subBeginDate) >= getDate(subEndDate)) {
			$(".tMsg").html("*开始时间不能大于或等于结束时间");
		
		  } else {
		
			$(".tMsg").html("");
			
		}
		}     
		validSuccess = (errorMsg == '' && validSuccess && $(".tMsg").html()=='');
		$errorMsg.html(errorMsg);
	});
});

function check() {
	validSuccess = true;
	$('#subBeginDate').blur();
	$('#subEndDate').blur();
	if(validSuccess==true){
	    checkLogin();
		$("#button").attr("disabled",true);
	}
	return validSuccess;


}
//字符串转日期格式，strDate要转为日期格式的字符串
function getDate(strDate) {
	var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
			function(a) {
				return parseInt(a, 10) - 1;
			}).match(/\d+/g) + ')');
	return date;
}
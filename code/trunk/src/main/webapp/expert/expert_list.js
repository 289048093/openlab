$(function() {
			$('.content_list').height($('.content_body').height());
			var cl = $('.content_list').height();
			var bl = $('.content_body').height();
			var max = Math.max(cl, bl);
			$('.content_list').height(max);
			$('.content_body').height(max);
		});
function goIaswer(espertID){
	document.getElementById('Iaswear').scrollIntoView();
	$('#selectExpertid option').each(function(){
		if($(this).val()==espertID){
			$(this).attr('selected','selected');
		}
	});
}
function whenSubmit(){
	if($("#questionTitle").val().length>0 && $("#selectExpertid").val()>0 
		&& $("#questionContent").val().length>0){
		return true;
	}else if(!($("#questionTitle").val().length>0)){
		$("#questionTitleyz").html("请填写问题标题");
		return false;
	}else if(!($("#selectExpertid").val()>0)){
		$("#selectExpertidyz").html("请选择提问专家");
		return false;
	}else if(!($("#questionContent").val().length>0)){
		$("#questionContentyz").html("请填写问题内容");
		return false;
	}
}
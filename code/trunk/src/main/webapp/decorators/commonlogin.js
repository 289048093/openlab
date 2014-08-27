$(function() {
			$('#dialog_title_').drag('#dialog_login_window_');
			$('#dialog_username').blur(validUsername);
			$('#dialog_password').blur(validPassword);
			$('#checkCode').blur(validCheckCode);
		});
function showLoginDialog(url) {
	!!url && $('#srcPath').val(url);
	$('#login_dialog').show();
	$('#dialog_username').focus();
}
function closeLoginDialog() {
	$('#login_dialog').hide();
}
function ajaxLogin() {
	if (!validUsername() || !validPassword() || !validCheckCode()) {
		reloadCheckCode();
		return;
	}
	var username = $('#dialog_username').val();
	var password = $('#dialog_password').val();
	var checkCode = $('#checkCode').val();
	loginLoading();
	$.ajax({
		type:"post",
		url : 'userManager/user!ajaxLogin.action',
		data : {
			"cloudContext.vo.username" : username,
			"cloudContext.vo.password" : password,
			"cloudContext.params.checkCode" : checkCode
		},
		success : function(data) {
			loginOver();
			reloadCheckCode();
			var res = data.cloudContext;
			if (res.errorMsgList && res.errorMsgList.length > 0) {
				$('.dialog_error_msg').html(res.errorMsgList.toString());
				return;
			}
			if (res.params.cardUserNoRegist) {
				location.href = basePath
						+ "register/carduser_register.jsp?cloudContext.vo.username="
						+ res.vo.username;
				return;
			}
			alert('登录成功');
			location.reload();
		},
		error:function(){
			loginOver();
			reloadCheckCode();
			alert('服务器连接失败');
		}
	});
}
function reloadCheckCode(){
	document.getElementById('verifyCode').src='VerifyCode?n='+Math.random();
	document.getElementById('checkCode').focus();
}
function loginLoading(){
	$('#loginLoadingContent').show();
	$('#loginFormContent').hide();
}
function loginOver(){
	$('#loginLoadingContent').hide();
	$('#loginFormContent').show();
}
function validUsername() {
	var val = $('#dialog_username').val();
	var em = $('#dialog_username').siblings('.errorMsg');
	if (!val) {
		em.html("用户名不能为空");
		return false;
	}
	if (val.length > 20) {
		em.html("用户名输入过长");
		return false;
	}
	if (!/^\w{1,20}$/.test(val)) {
		em.html("用户名格式错误组成");
		return false
	}
	em.html('');
	return true;
}
function validPassword() {
	var val = $('#dialog_password').val();
	var em = $('#dialog_password').siblings('.errorMsg');
	if (!val) {
		em.html("密码不能为空");
		return false;
	}
	if (val.length > 30) {
		em.html("密码输入过长");
		return false;
	}
	em.html('');
	return true;
}
function validCheckCode() {
	var val = $('#checkCode').val();
	var em = $('.dialog_error_msg');
	if (!val) {
		em.html("验证码不能为空");
		return false;
	}
	if (val.length > 4) {
		em.html("验证码输入过长");
		return false;
	}
	em.html('');
	return true;
}
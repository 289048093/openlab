$(function() {
			$('#.content_main_title span').mouseover(function() {
						var xz = $(this).index();
						$('#.content_main_title span').css({
									'backgroundImage' : 'url(images/h1_2.gif)',
									'color' : '#4c4c4c'
								});
						$(this).css({
									'backgroundImage' : 'url(images/h1_1.gif)',
									'color' : 'white'
								});
						$('#content_main_list ul').hide();
						$("#content_main_list ul:eq(" + xz + ")").show();
						if(xz==0){
							$("#span_title_more").attr("href","newsManager/news!query.action");
						}else if(xz==1){
							$("#span_title_more").attr("href","newsManager/news!query.action?cloudContext.params.catId="+noticeCatId);
						}else if(xz==2){http:
							$("#span_title_more").attr("href","policyManager/policy!query.action");
						}
					});
			$("#ss_literature").mouseover(function(){
				$('#ss_equipment').css({
					'backgroundImage' : 'url(images/h1_2.gif)',
					'color' : '#4c4c4c'
				});
				$('#ss_literature').css({
					'backgroundImage' : 'url(images/ss_h1_1.png)',
					'color' : 'white'
				});
				$('#select_equipment').hide();
				$('#select_literature').show();
			});
			$("#ss_equipment").mouseover(function(){
				$('#ss_literature').css({
					'backgroundImage' : 'url(images/h1_2.gif)',
					'color' : '#4c4c4c'
				});
				$('#ss_equipment').css({
					'backgroundImage' : 'url(images/ss_h1_1.png)',
					'color' : 'white'
				});
				$('#select_literature').hide();
				$('#select_equipment').show();
			});
		});
		
function set_equipmentCat(id,this_){
	$('#equipment_catId').val(id);
	$('#equipment_cats span a').css(
		{'color' : 'blue','font-weight':'normal'}
	);
	$(this_).css({'color' : 'black','font-weight':'bold'});
}
function set_noequipmentCat(this_){
	$('#equipment_catId').val('');
	$('#equipment_cats span a').css(
		{'color' : 'blue','font-weight':'normal'}
	);
	$(this_).css({'color' : 'black','font-weight':'bold'});
}
/*表单登录验证*/
function jyUsername(){
	var name = $('#username').val();
	if(name.length<1){
		$('#loginError').html('请输入用户名');
		return false;
	}else if(name.length<2){
		$('#loginError').html('用户名输入过短');
		return false;
	}else{
		return true;
	}
}
function jyPassWord(){
	var pass = $('#password').val();
	if(pass.length<1){
		$('#loginError').html('请输入密码');
		return false;
	}else if(pass.length<2){
		$('#loginError').html('密码格式错误');
		return false;
	}else{
		return true;
	}
}
function jyYZM(){
	var code = $('#checkCode').val();
	if(code.length==4){
		return true;
	}else{
		$('#loginError').html('请输入验证码');
		return false;
	}
}
function yzAll(){
	if(jyUsername()&&jyPassWord()&&jyYZM()){
		return true;
	}else{
		return false;
	}
}
$(function(){
	$('.content_list_list_sys_title').click(function(){
		var content = $(this).next();
		if(content.is(":hidden")){
			$('.content_list_list_sys_title_ul').slideUp();
			content.slideDown(function(){
				var ulheigh = content.height();
				var meanbodyheigh = $('.content_body').height();
				var dbheigh = meanbodyheigh-145;
				if(ulheigh>dbheigh){
					content.css("overflow-y","scroll");
					content.css("overflow-x","none");
					content.css("height",dbheigh);
				}
			});
		}else{
			content.slideUp();
		}
	});
});
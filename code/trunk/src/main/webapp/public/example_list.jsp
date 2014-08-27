<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>详情页面-样板</title>
   <link rel="stylesheet" type="text/css" href="css/example_detail.css">
   	<script type="text/javascript">
			$(function(){
				var cl = $('.content_list').height();
				var bl = $('.content_body').height();
				var max = Math.max(cl,bl);
				$('.content_list').height(max);
				$('.content_body').height(max);
			});
	</script>
  </head>
  
  <body>
  		<div class="content_list">
  			<div class="content_list_title">操作列表</div>
  			<div>
  			<ul class="title_listul">
  				<li>
  				<a href="public/example_list.jsp">重点实验室</a>
  				</li>
  				<li>  
		    	<a href="public/example_list.jsp">公共技术服务平台</a>
		    	</li>
  				<li>  
				<a href="public/example_list.jsp">科技文献</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">新闻通知</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">政策法规</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">仪器设备</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">行业检测</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">专家咨询</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">科技成果与技术转移</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">下载中心</a>
  				</li>
  			</ul>
  			</div>
  		</div>
  		<div class="content_detail">
  			<div class="content_detail_title">详细信息</div>
  			<div>
  				<ul class="content_detail_titleul">
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">投资3亿 国家动力电池检验中心在襄阳开工</a>
  					</li>
  				</ul>
  			</div>
</div>
</body>
</html>

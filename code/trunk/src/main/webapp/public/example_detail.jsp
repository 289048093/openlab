<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
  			<div  >
  				<h3 align="center" class="news_title">新闻的标题</h3>
  				<p class="news_content" >&nbsp;&nbsp; 微生物已经在工业、农业、能源、环境、医药等诸多领域发挥着无可替代的作用。
  					筛选获得优良的菌种是提升相关产业技术水平的重要途径。
  					通常，微生物的液体培养筛选需要同时在数十上百个培养瓶或试管中进行。
  					这使得整个筛选过程劳动强度大，效率较低。
  				</p>
  			</div>
  		</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>仪器设备-列表页面</title>
		<link rel="stylesheet" type="text/css" href="css/equipment_detail.css">
	</head>

	<body>
				<div class="content_list">
					<div class="content_list_title">
						<span>服务领域</span>
					</div>
					<div class="content_list_list">
						<table class="content_list_list_table">
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">农业</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">农产品和食品</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">林业</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">生态环境</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">医药</a>
								</td>
							<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">生物医药</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">能源</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">轻工</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">海洋</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">天文</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">计算机</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">编程</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">物理</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">化学</a>
								</td>
							</tr>
							<tr>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">农业</a>
								</td>
								<td>
									<img src="images/arrow1.gif"></img>
									<a href="#">农产品和食品</a>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="content_body">
						<div class="content_body_title">
						<img src="images/dh.gif"></img>
						<span>当前位置：首页 》 行业检测》行业检测预约》上传行业检测预约信息</span>
					</div>
					<div class="content_body_list">
						<form action="industryTestManager/industryTest!upload.action" 
              enctype="multipart/form-data" method="post">
            文件:<input type="file" name="image">
                <input type="submit" value="上传" />
        </form>
					</div>
				</div>
	</body>
</html>

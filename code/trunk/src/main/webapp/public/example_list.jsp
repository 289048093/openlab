<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����ҳ��-����</title>
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
  			<div class="content_list_title">�����б�</div>
  			<div>
  			<ul class="title_listul">
  				<li>
  				<a href="public/example_list.jsp">�ص�ʵ����</a>
  				</li>
  				<li>  
		    	<a href="public/example_list.jsp">������������ƽ̨</a>
		    	</li>
  				<li>  
				<a href="public/example_list.jsp">�Ƽ�����</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">����֪ͨ</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">���߷���</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">�����豸</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">��ҵ���</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">ר����ѯ</a>
				</li>
  				<li>  
				<a href="public/example_list.jsp">�Ƽ��ɹ��뼼��ת��</a> 
				</li>
  				<li>  
				<a href="public/example_list.jsp">��������</a>
  				</li>
  			</ul>
  			</div>
  		</div>
  		<div class="content_detail">
  			<div class="content_detail_title">��ϸ��Ϣ</div>
  			<div>
  				<ul class="content_detail_titleul">
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  					<li>
  						<a href="public/example_detail.jsp">Ͷ��3�� ���Ҷ�����ؼ�����������������</a>
  					</li>
  				</ul>
  			</div>
</div>
</body>
</html>

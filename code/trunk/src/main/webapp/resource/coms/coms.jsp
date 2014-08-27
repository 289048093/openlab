<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>加盟单位</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
$(function() {
	$('#test').load("resource/coms/test_.jsp");
	$('#testDialog').click(function() {
		$.dialog({url:"resource/coms/test_.jsp",title:"新建"});
	});
});
</script>
	</head>

	<body>
		<!-- <input id="testDialog" value="click me" />
		<div id="test" style="display: none"></div> -->
		<div class="introduce">
			一是更新管理理念。立足现有人员，不断加大培训力度，给每个人以合适的岗位。坚持“用人所长，能级匹配”的原则，为各类人才脱颖而出开辟“快车道”。
		</div>
		<div class="set">
			<form id="form1" name="form1" method="post" action="">
				<label>
					<input type="checkbox" name="checkbox" id="checkbox" class="getall" />
					全选
					<input type="checkbox" name="checkbox" id="checkbox" class="getall" />
					反选
				</label>
				<span class="operate"> <input type="button"
						class="addoperate" value="添加" /> <input type="button"
						class="addoperate" value="编辑" /> <input type="button"
						class="addoperate" value="删除" /> </span>
			</form>
		</div>
		<div class="count_table">
			<table>
				<tr>
					<td style="width: 120px;">
						操作
					</td>
					<td style="width: 120px;">
						编号
					</td>
					<td style="width: 120px;">
						名称
					</td>
					<td style="width: 120px;">
						种类
					</td>
					<td style="width: 120px;">
						价格
					</td>
					<td style="width: 120px;">
						数量
					</td>
				</tr>
				<tr>
					<td style="width: 120px;">
						<input type="checkbox" name="checkbox" id="checkbox"
							class="getall" />
					</td>
					<td style="width: 120px;">
						23
					</td>
					<td style="width: 120px;">
						3123
					</td>
					<td style="width: 120px;">
						213类
					</td>
					<td style="width: 120px;">
						价231格
					</td>
					<td style="width: 120px;">
						数 121量
					</td>
				</tr>


			</table>
		</div>
	</body>
</html>

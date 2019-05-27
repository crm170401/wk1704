<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="js/Login.js"></script>
	<script type="text/javascript">
		function yanzheng(){
			$.post("xiugaimima",{
				oldpassword:$("#oldpassword").val(),
				newpassword:$("#newpassword").val()
			},function(res){
				alert(res)
			})
		}
	</script>
</head>
<body>
<div>
	<form id="ff" method="post">   
		<table>
			<tr>
				<td>请输入旧密码:</td>
				<td><input class="easyui-validatebox" id="oldpassword" type="password"/></td>
			</tr>
			<tr>
				<td>请输入新密码:</td>
				<td><input class="easyui-validatebox" id="newpassword" type="password"/></td>
				<td><a id="btn" href="#" class="easyui-linkbutton" onclick="yanzheng()">修改</a></td>
			</tr>
			
		</table>
	</form> 
</div>


</body>
</html>
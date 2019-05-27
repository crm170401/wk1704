<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
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
</head>
<script type="text/javascript">
$(function() {
	
	yzm();
	tijiao();
	

})
function yzm(){
	$("#vimg").on("click", function() {
		var timestamp = (new Date()).valueOf();
		$(this).attr("src", "code?timestamp=" + timestamp);
	});
}


function tijiao() {
	var y = $("[name='y']:checked").val();
	$.post(
					'login',
					{
						verifyCode : $("#verifyCode").val(),
						teachname : $("#teachname").val(),
						teachpassword : $("#teachpassword").val(),
						y:y
					},
					function(res) {
						if(res.match("0")){
							window.location.href="main.jsp"
						}else{
							document.getElementById("InfoMessage").innerHTML = "<font>"+res+"</font>";
						}
					})

}
</script>
<body>
	<div id="win" class="easyui-window" title="CRM登录"
		style="width: 300px; height: 270px;padding: 25px;"
		data-options="iconCls:'icon-save',closable:false,maximizable:false,minimizable:false,collapsible:false">
		<table style="margin: auto;">
			<tr >
				<td>用户名</td>
				<td><input class="inputClass" name="username" type="text" id="teachname" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="inputClass" name="password" type="password" id="teachpassword" /></td>
			</tr>
			<tr>
				<td id="tdText">验证码：</td>
				<td>
				<input class="inputClass" type="text" name="verifyCode" id="verifyCode" />
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="divVerifyCode">
						<img id="vimg" src="code" />
					</div>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;"><input type="checkbox" value="yes" name="y">自动登录</td>
			</tr>
			<tr>
			<td colspan="3" style="text-align: center;"><span id="InfoMessage"></span></td>
			</tr>
			<tr>
			<td colspan="3" style="text-align: center;"><input type="button" id="dl" onclick="tijiao()" value="登录"></td>
			</tr>
		</table>
	</div>
</body>
</html>
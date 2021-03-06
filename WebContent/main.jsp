<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<script type="text/javascript">
	var name = $("#loginname").val();
     
	$(function() {
		$("#tt").tree({
			url : 'getShu',
			method : 'post',
			animate : true,
			queryParams : {
				name : name
			},
			onClick : function(node) {
				var isLeaf = $('#tt').tree('isLeaf', node.target);
				if (isLeaf) {
					Open(node.text, node.path);
				}
			}
		});
		function Open(text, url) {
			if ($("#td").tabs('exists', text)) {
				$('#td').tabs('select', text);
			} else {
				$('#td')
						.tabs(
								'add',
								{
									title : text,
									closable : true,
									content : "<iframe src='"
											+ url
											+ ".jsp' style='width: 100%; height: 600px;'/>"
								});
			}
		}
	});

	function tuichu() {
		$.messager.confirm('确认', '您确认想要退出吗？', function(r) {
			if (r) {
				window.location.href = "Login.jsp";
			}
		});
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false,split:true"
		style="height: 70px; position: relative; z-index: 0; overflow: hidden; border-bottom: 1px #95b8e7 solid; background: url(img/01.jpg) bottom repeat-x;">
		<h1>欢迎登录员工管理系统</h1>
		<input type="text" id="loginname" hidden="true"
			value="<%=session.getAttribute("teachname")%>">
		<div
			style="position: absolute; margin-top: -13px; z-index: 1; right: 5px; top: 0; color: #fff; text-align: right;">
			<p style="color: black; font-size: 20px">
				<strong> <%=session.getAttribute("teacherid")%>,,, <%=session.getAttribute("teachname")%>，欢迎您！
				</strong>
			</p>
			<p style="margin-top: -10px; font-size: 15px">
				<a href="javascript:void(0)" onclick="editPassword()">修改密码</a>|<a
					href="javascript:void(0)" onclick="tuichu()">安全退出</a>
			</p>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'导航应用'"
		style="width: 150px; padding: 10px;">
		<div id="menuTree">
			<ul id="tt" class="easyui-tree"
				data-options="iconCls:'icon-save',collapsible:true"></ul>
		</div>
	</div>
	<div data-options="region:'south',border:false,split:true"
		style="height: 20px; text-align: center; overflow: hidden; background: #e0ecff;">&copy;
		2019 CRM 员工系统</div>
	<div data-options="region:'center'">
		<div id="td" class="easyui-tabs"></div>
	</div>
</body>
</html>
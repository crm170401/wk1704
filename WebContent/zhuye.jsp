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
	$(function() {
		$("#menuTree")
				.tree(
						{
							url : "js/tree.json",
							method : "get",
							onClick : function(node) {
								var flag = $("#tt").tabs('exists', node.text);
								var isLeaf = $('#menuTree').tree('isLeaf',
										node.target); //是否是叶子节点
								if (isLeaf) {//只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
									if (!flag) {
										$('#tt')
												.tabs(
														'add',
														{ //在选项卡中，创建1个选项页
															title : node.text, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
															closable : true,
															content : "<iframe style='width: 99%; height: 440px;'  src='"
																	+ node.id
																	+ ".jsp'/>" //此处做了调整，推荐使用iframe的方式实现
														});
									} else {
										$("#tt").tabs('select', node.text); //直接选中title对应的选项卡
									}
								}
							}
						})

	})

	function qiandao() {
		alert("在签到");
		var id = 1;
		alert(id);
		$.post("updateTE", {
			id : id
		}, function(res) {
			if (res > 0) {
				alert(修改成功);
			} else {
				alert(修改失败);
			}
		}, json)
	}

	function tuichu() {
		$.messager.confirm('确认', '您确认想要退出吗？', function(r) {
			if (r) {
				
				window.location.href = "Login.jsp";//返回至登录页面
			}
		});
	}
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width: 600px; height: 400px;"
		data-options="fit:true">
		<div data-options="region:'north',title:'欢迎来到星星互联网培训中心',split:true"
			style="height: 100px;">
			<span id="yonghu"
				style="text-align: left; display: block; margin-top: 11px; float: float; font-size: 14px;">星星互联网培训中心人事管理系统
				欢迎您 ${teacher.name}</span>
			<button id="qiandao" onclick="qiandao()">签到</button>
		</div>
		<div data-options="region:'south',title:'South Title',split:true"
			style="height: 100px;">
			<span
				style="text-align: left; display: block; margin-top: 10px; float: float; font-size: 14px;"><a
				href="javascript:void(0)" onclick="tuichu()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;安全退出</a></span>
		</div>

		<div data-options="region:'west',title:'数据菜单',split:true"
			style="width: 100px;">
			<ul id="menuTree" class="easyui-tree"></ul>
		</div>
		<div data-options="region:'center',title:'数据菜单'">
			<div data-options="region:'center',title:'学生数据管理'">
				<div id="tt" class="easyui-tabs"></div>
			</div>
		</div>

	</div>
</body>
</html>
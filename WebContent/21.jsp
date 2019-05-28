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
<script type="text/javascript" src="js/Login.js"></script>
<script type="text/javascript">
	$(function() {
		JueseSearch();
	})
	function JueseSearch() {
		$('#juse').datagrid({
			url : 'alljuese',
			method : 'post',
			toolbar : '#JueseTab',
			pagination : true,
			singleSelect : true,
			rownumbers : true,
			columns : [ [ {
				field : 'jeid',
				title : '编号',
				width : 100
			}, {
				field : 'jename',
				title : '名称',
				width : 100
			}, {
				field : 'a',
				title : '操作',
				width : 60,
				formatter : DEL
			}, ] ]

		});
	}
	function addJuese(num) {
		if (num == 1) {
			$("#JueSeTabDiv").window("open");
		} else {
			$.post("insertjuese", {
				jename : $("#jename").val(),
			}, function(res) {
				if (res == 0) {
					$.messager.alert('警告', '不能重复添加角色');

				} else if (res == 1) {
					$.messager.alert('提示信息', '添加成功');

					$('#juse').datagrid('reload');
					$("#JueSeTabDiv").window("close");
				} else {
					$.messager.alert('警告', '添加角色失败');
				}
			})
		}
	}
	function DEL(value, row, index) {
		var jeid = row.jeid;
		return "<button onclick='deletejuese(" + jeid + ")'>删除</button>";
	}
	function deletejuese(jeid) {
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.post("deletejuese", {
					jeid : jeid,
				}, function(res) {
					if (res == 0) {
						$.messager.alert('警告', '不能删除占用角色');

					} else if (res == 1) {
						$.messager.alert('提示信息', '删除成功');
						$('#juse').datagrid('reload');
						$("#JueSeTabDiv").window("close");
					} else {
						$.messager.alert('警告', '删除角色失败');
					}
				})
			}
		});
	}
</script>
</head>
<body>
	<div id="JueseTab">
		<a href="javascript:void(0)" style="float: right;"
			onclick="addJuese(1)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'">添加</a>
	</div>
	<table id="juse"></table>
	<div id="JueSeTabDiv" class="easyui-window" title="添加"
		style="width: 250px; height: 120px"
		data-options="modal:true,closed:true">
		<table>
			<tr>
				<td>角色名称</td>
				<td><input type="text" id="jename"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="button" value="提交" onclick="addJuese(2)"></td>
			</tr>
		</table>
	</div>
</body>
</html>
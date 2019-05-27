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
		jia();
	})

	function jia() {
		$('#huifang').datagrid({
			url : 'showHuiFang',
			menthod : "post",
			pagination : true,
			toolbar : "#biaotou",
			queryParams:{
				huifangren:$('#huifangren').val()
			}
		});
	}
</script>
</head>
<body>

	<table class="easyui-datagrid" id="huifang">
		<thead>
			<tr>
				<th data-options="field:'huifangshiji',width:100">回访时间</th>
				<th data-options="field:'huifangren',width:100">回访人</th>
				<th data-options="field:'kehuyixiang',width:100,align:'right'">回访意向</th>
				<th data-options="field:'kehudengji',width:100,align:'right'">课程</th>
				<th data-options="field:'shifoushangmen',width:100,align:'right'">是否上门</th>
				<th data-options="field:'shangmenqingkuang',width:100,align:'right'">上门情况</th>
			</tr>
		</thead>
	</table>

	<div id="biaotou">
		<form id="ff" method="post">
			     <label for="name">回访人:</label> 
			     <input class="easyui-validatebox" type="text" id="huifangren" />
				
				 <label for="name">回访时间:</label> 
				 <input class="easyui-validatebox" type="text" />
				
				 <label for="name">是否上门:</label> 
				 <input class="easyui-validatebox" type="text" />
				 <a  href="javascript:void(0)" class="easyui-linkbutton" onclick="jia()" data-options="iconCls:'icon-search'">搜索</a>  
		</form>

	</div>
</body>
</html>
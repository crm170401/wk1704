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
			queryParams : {
				huifangren : $('#huifangren').val()
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
			<label for="name">回访ren:</label> <input class="easyui-validatebox"
				type="text" id="huifangren" /> <label for="name">回访时:</label> <input
				class="easyui-validatebox" type="text" /> <label for="name">是否:</label>
			<input class="easyui-validatebox" type="text" /> <a
				href="javascript:void(0)" class="easyui-linkbutton" onclick="jia()"
				data-options="iconCls:'icon-search'">搜索</a> <a
				href="javascript:void(0);" id="btnExport" class="easyui-linkbutton"
				iconCls='icon-print'>导出Excel</a>
		</form>
	</div>
</body>

<script type="text/javascript">
	//导出excel表格
	$("#btnExport").click(function() {
		alert(1561651);
		var rows = $('#huifang').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert("系统信息", "请选择你要导出的数据");
			return;
		}
		//导出所有
		/* var data = JSON.stringify($('#booTab').datagrid('getData').rows); */
		var data = JSON.stringify(rows);
		if (data == '')
			return;
		JSONToCSVConvertor(data, "数据信息", true);
	});
	
	
	//导出方法
	function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
		//如果jsondata不是对象，那么json.parse将分析对象中的json字符串。
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		var CSV = '';

		//在第一行拼接标题
		CSV += ReportTitle + '\r\n\n';

		//产生数据标头
		if (ShowLabel) {
			var row = "";
			//此循环将从数组的第一个索引中提取标签
			for ( var index in arrData[0]) {

				//现在将每个值转换为字符串和逗号分隔
				row += index + ',';
			}

			row = row.slice(0, -1);

			//添加带换行符的标签行
			CSV += row + '\r\n';
		}

		//第一个循环是提取每一行
		for (var i = 0; i < arrData.length; i++) {
			var row = "";

			//2nd loop will extract each column and convert it in string comma-seprated
			for ( var index in arrData[i]) {
				row += '"' + arrData[i][index] + '",';
			}

			row.slice(0, row.length - 1);

			//add a line break after each row
			CSV += row + '\r\n';
		}

		if (CSV == '') {
			alert("Invalid data");
			return;
		}

		//Generate a file name
		var fileName = "网络学生_";
		//this will remove the blank-spaces from the title and replace it with an underscore
		fileName += ReportTitle.replace(/ /g, "_");

		//Initialize file format you want csv or xls
		//var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
		var uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURI(CSV);

		// Now the little tricky part.
		// you can use either>> window.open(uri);
		// but this will not work in some browsers
		// or you will not get the correct file extension    

		//this trick will generate a temp <a /> tag
		var link = document.createElement("a");
		link.href = uri;

		//set the visibility hidden so it will not effect on your web-layout
		link.style = "visibility:hidden";
		link.download = fileName + ".csv";

		//this part will append the anchor tag and remove it after automatic click
		document.body.appendChild(link);
		link.click();
		document.body.removeChild(link);
	}
</script>
</html>
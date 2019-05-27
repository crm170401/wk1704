<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		init();
		showSetColumn();

	})
	function init() {

		$('#booTab').datagrid({
			url : "show",
			method : "post",
			/*  valueField:'uid',    
			 textField:'LoginName', */
			toolbar : "#stutoolbar",
			pagination : true,
			queryParams : {
				sname : $("#sname").val(),
				smtel : $("#smtel").val(),
				zixunshi : $("#zixunshi").val(),
				isPayment : $("#isPayment").combobox("getValue"),
				isEffective : $("#isEffective").combobox("getValue"),
				isVisit : $("#isVisit").combobox("getValue"),
				qq : $("#qq").val(),
			}
		});
		$("#title").form("reset");
	}
	function formatterCaozuo(value, rows, index) {
		return "<a href='javascript:void(0)' onclick='edit(" + index
				+ ")'>编辑</a>  <a href='javascript:void(0)' onclick='del("
				+ index
				+ ")'>删除</a> <a href='javascript:void(0)' onclick='chakan("
				+ index
				+ ")'>查看</a> <a href='javascript:void(0)' onclick='genzong("
				+ index + ")'>跟踪</a>"
	}

	function chakan(index) {
		var row = $("#booTab").datagrid("getData").rows[index];
		$("#chakan-dialog").dialog("open");

		$("#chakan").form("load", row);
	}
	function savechakan() {
		$("#chakan-dialog").dialog("close");
	}
	function closechakan() {
		$("#chakan-dialog").dialog("close");
	}

	/* 编辑 */
	function edit(index) {
		//获取表格当中选中的数据
		var data = $("#booTab").datagrid("getData");
		var row = data.rows[index];
		//填充进表单
		$("#updateForm").form("load", row);

		//打开对话框
		$("#editDialog").dialog("open");
	}
	/* 编辑保存的按钮 */
	function save() {
		//获取表单的值
		//发送异步请求
		$.post("updateStu", {
			sid : $("#sid1").val(),
			sname : $("#sname1").val(),
			ssex : $("#ssex1").val(),
			sage : $("#sage1").val(),
			smtel : $("#smtel1").val(),
			xueli : $("#xueli1").val(),
			zhuangtai : $("#zhuangtai1").val(),
			qudao : $("#qudao1").val(),
			wangzhan : $("#wangzhan1").val(),
			keyword : $("#keyword1").val(),
			sourceParts : $("#sourceParts1").val(),
			consuleName : $("#consuleName1").val(),
			regions : $("#regions1").val(),
			isReport : $("#isReport1").val(),
			kechengfangxiang : $("#kechengfangxiang1").val(),
			isEffective : $("#isEffective1").val(),
			marking : $("#marking1").val(),
			isVisit : $("#isVisit1").val(),
			firstVisitTime : $("#firstVisitTime1").val(),
			isCall : $("#isCall1").val(),
			callTime : $("#callTime1").val(),
			wuxiaoyuanyin : $("#wuxiaoyuanyin1").val(),
			isPayment : $("#isPayment1").val(),
			paymentTime : $("#paymentTime1").val(),
			depositMoney : $("#depositMoney1").val(),
			depositTime : $("#depositTime1").val(),
			follows : $("#follows1").val(),
			qq : $("#qq1").val(),
			weixin : $("#weixin1").val(),
			zixunshi : $("#zixunshi1").val(),
			liruren : $("#liruren1").val()
		}, function(res) {
			if (res > 0) {
				//修改成功
				$("#booTab").datagrid("reload");
				$("#editDialog").dialog("close");
				$.messager.alert("提示：", "修改成功");

			} else {
				//修改失败
				$.messager.alert("提示：", "修改失败");
			}
		}, "json");
	}
	function closeDialog() {
		$("#editDialog").dialog("close");
	}
	/*删除*/
	function del(index) {
		//获取表格当中选中的数据
		var data = $("#booTab").datagrid("getData");
		var row = data.rows[index];
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.post("deleteStu", {
					sid : row.sid
				}, function(res) {
					if (res > 0) {
						//删除成功
						$("#booTab").datagrid("reload");
						$.messager.alert("提示：", "删除成功")

					} else {
						//删除失败
						$.messager.alert("提示：", "删除失败")
					}
				}, "json");
			}
		});

	}

	/*添加*/
	function addStu() {
		//打开对话框
		$("#addDialog").dialog("open");

	}
	function saveadd() {

		$.post("addStu", {

			sname : $("#sname2").val(),
			ssex : $("#ssex2").combobox("getValue"),
			sage : $("#sage2").val(),
			smtel : $("#smtel2").val(),
			xueli : $("#xueli2").combobox("getValue"),
			zhuangtai : $("#zhuangtai2").combobox("getValue"),
			qudao : $("#qudao2").combobox("getValue"),
			wangzhan : $("#wangzhan2").combobox("getValue"),
			keyword : $("#keyword2").val(),
			isReport : $("#isReport2").val(),
			qq : $("#qq2").val(),
			weixin : $("#weixin2").val(),
			beizhu : $("#beizhu2").val(),

		}, function(res) {
			if (res > 0) {
				//添加成功
				$("#booTab").datagrid("reload");
				$("#addDialog").dialog("close");
				$.messager.alert("提示：", "添加成功");
			} else {
				//添加失败
				$.messager.alert("提示：", "添加失败")
			}
		}, "json");
	}
	function closeadd() {
		$("#addDialog").dialog("close");
	}
	function shezhi() {
		$("#showColumn").window("open");
	}
	function showSetColumn() {
		$("#disColumn").find("input[name=check]").change(function(res) {
			if (this.checked == true) {
				$("#booTab").datagrid("showColumn", this.value);
			} else {
				$("#booTab").datagrid("hideColumn", this.value);
			}
		});
	}

	function formatterzixunshi(value, row, index) {
		return value.loginName;
	}
	function formatterSex(value, row, index) {
		return value == 1 ? "男" : "女";
	}
	function formatterZhuangtai(value, row, index) {
		if (row.zhuangtai == 1) {
			return "未知"
		} else if (row.zhuangtai == 2) {
			return "待业"
		} else if (row.zhuangtai == 3) {
			return "在职"
		} else if (row.zhuangtai == 4) {
			return "在读"
		}

	}
	function isReport(value, row, index) {
		return value == 1 ? "是" : "否";
	}
	function isEffective(value, row, index) {
		return value == 1 ? "是" : "否";
	}
	function isVisit(value, row, index) {
		return value == 1 ? "是" : "否";
	}
	function isCall(value, row, index) {
		return value == 1 ? "是" : "否";
	}
	function isPayment(value, row, index) {
		return value == 1 ? "已缴费" : "未缴费";
	}
	function isRefund(value, row, index) {
		return value == 1 ? "已退费" : "未退费";
	}
	function isClass(value, row, index) {
		return value == 1 ? "已进班" : "未进班";
	}
	function isEntroll(value, row, index) {
		return value == 1 ? "已报名" : "未报名";
	}
</script>
</head>

<body>
	<div id="stutoolbar">

		<form class="easy-form" id="title">
			    <a href="javascript:void(0);" id="btnExport" class="easyui-linkbutton" iconCls='icon-print'>导出Excel</a> 
				<a href="javascript:void(0);" id="piliang" class="easyui-linkbutton" iconCls='icon-filter'>批量操作</a>
		</form>
	</div>
	</body>
	<script type="text/javascript">
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
		/**
		 * 选择ID增加单击时间执行方法
		 */
		 
		 
		 
		$("#btnExport").click(function() {
			alert(1561651);
			var rows = $('#booTab').datagrid('getSelections');
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
	</script>
</html>
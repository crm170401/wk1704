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
		$('#mokuai').datagrid({
			url : 'showMokuai',
			menthod : "post",
			pagination : true,
			toolbar : "#mokuaiss"

		});
	}

	function formattercaozuo(value, row, index) {
		return "<a href='javascript:void(0)' onclick='updteMK("
				+ index
				+ ")'>修改</a>   <a href='javascript:void(0)' onclick='deleteStu("
				+ index + ")'>删除</a>"
	}
	//新增模块
	function newMK(index) {
		var arr = $("#mokuai").datagrid("getData");
		var row = arr.rows[index];
		//打开弹窗
		$("#newmokuai").dialog("open")

	}

	function tianjia() {
		$.post("insertMk", {
			mkname : $("#newname").val(),
			mkjiedian : $("#newjiedian").val(),
			jeid : $("#jeid1").val()
		}, function(res) {
			if (res > 0) {
				alert("新增成功");

			}
		}, "json");
		$("#newmokuai").dialog("closed")
	}

	//修改模块
	function updteMK(index) {
		var arr = $("#mokuai").datagrid("getData");
		var row = arr.rows[index];

		//填充表单
		$("#updateform").form("load", row);
		//打开弹窗
		$("#updatemokuai").dialog("open")
	}

	function updatem() {

		$.post("updateMk", {
			mkid : $("#mkid1").val(),
			mkname : $("#mkname1").val()
		}, function(r) {
			if (r > 0) {
				alert("修改成功")
			}
		}, "json");
	}
</script>
</head>
<body>
	<table class="easyui-datagrid" id="mokuai">
		<thead>
			<tr>

				<th data-options="field:'mkid',width:100">模块编号</th>
				<th data-options="field:'mkname',width:100,hidden:'true'">模块名称</th>
				<!-- <th data-options="field:'mkgljeid',width:100,align:'right'">模块所属者</th>
				<th data-options="field:'mkzhixiang',width:100,align:'right'">模块节点</th> -->
				<th
					data-options="field:'caozuo',title:'操作',formatter:formattercaozuo"></th>
			</tr>
		</thead>
	</table>

	<
	<div id="mokuaiss">
		<form id="form" method="post">
			<!-- <label for="name">回访ren:</label> <input class="easyui-validatebox"
				type="text" id="huifangren" /> <label for="name">回访时:</label> <input
				class="easyui-validatebox" type="text" /> <label for="name">是否:</label>
			<input class="easyui-validatebox" type="text" /> <a
				href="javascript:void(0)" class="easyui-linkbutton" onclick="jia()"
				data-options="iconCls:'icon-search'">搜索</a> -->
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="newMK()" data-options="iconCls:'icon-add'">新增</a>
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updteMK()" data-options="iconCls:'icon-edit'">修改</a> -->
		</form>

	</div>


	<div id="newmokuai" class="easyui-window" title="添加"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		<form id="newform">

			<br />模块名称： <input class="easyui-validatebox"
				validType="minLength['3']" type="text" id="newname" /> <br /> <br />
			模块权重： <input class="easyui-validatebox" validType="minLength['3']"
				type="text" id="newjiedian" /> <br /> <br /> 模块所有者： <input
				class="easyui-validatebox" validType="minLength['3']" type="text"
				id="jeid" /> <br /> <br /> <a id="btn1" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="tianjia()"
				data-options="iconCls:'icon-ok'">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a>
		</form>
	</div>



	<div id="updatemokuai" class="easyui-window" title="修改"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		<form id="updateform">
			<br /> 模块编号： <input class="easyui-validatebox"
				validType="minLength['3']" type="text" name="mkid" id="mkid1" /> <br />
			<br /> 模块名称： <input class="easyui-validatebox"
				validType="minLength['3']" type="text" name="mkname" id="mkname1" />
			<br /> <br />
			<!-- 模块权重： <input class="easyui-validatebox" validType="minLength['3']" type="text" name="mkgljeid"id="jeid1" /> <br /> <br />  -->
			<!-- 模块所有者： <input class="easyui-validatebox" validType="minLength['3']"
				type="text" name="mkzhixiang" id="mkjiedian1" /> <br /> <br /> -->
			<a id="btn1" href="javascript:void(0)" class="easyui-linkbutton"
				onclick="updatem()" data-options="iconCls:'icon-ok'">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<!-- <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a> -->
		</form>
	</div>

</body>
</html>
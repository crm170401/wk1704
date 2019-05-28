<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师管理</title>
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
</head>
<script type="text/javascript">
$(function(){
	TeachSearch()
})

	var Insert =<%=session.getAttribute("jsinsert")%>;
	var Delete =<%=session.getAttribute("jsdelete")%>;
	var Update =<%=session.getAttribute("jsupdate")%>;
	var TeachID=<%=session.getAttribute("TeachID")%>;
	function TeachSearch(){
		$('#teacherTab').datagrid({
			url:'teacherData',
			method:'post',
			pagination:true,
			singleSelect:true,
			rownumbers:true,
			toolbar: '#TeachTab',
			columns:[[
				{field:'teachname',title:'姓名',width:100},
				{field:'teachzhuangtai',title:'网络状态',width:100},
				{field:'jename',title:'职位',width:100},
				{field:'teachphone',title:'电话',width:100},
				{field:'teachqiandaoshijian',title:'签到时间',width:100},
				{field:'teachqiandaocishu',title:'签到次数',width:100},
				{field:'teachxueshengshu',title:'学生数量',width:100},
				{field:'1',title:'操作',width:60,formatter:CZ2},
				{field:'2',title:'操作',width:60,formatter:CZ1},
				{field:'3',title:'操作',width:60,formatter:CZ3},
				{field:'4',title:'操作',width:60,formatter:MES},
			]],
			queryParams: {
				teachname:$("#teacherName").val(),
				qxsuoding:$("#QxSuoDing").val()
			}

		}); 
	}
	function MES(value,row,index){
		var name=row.teachname;
		return "<a href='message.jsp?teachname="+name+"'>信息</a>";
	}
	function CZ1(value,row,index){
		if (Delete == 1) {
			return "<button onclick='DEL("+index+")'>删除</button>";
			}else{
				return "权限不足";
			}
	}
	function CZ2(value,row,index){
		if (Update == 1) {
			return "<button onclick='UPDOP("+index+")'>修改</button>";
			}else{
				return "权限不足";
			}
	}
	function CZ3(value,row,index){
		var jename=row.jename;
		var suoding=row.qxsuoding;
		if(jename.match("经理")){
			return "权限不足";
		}else{
			if(suoding==1){
				return "<button onclick='JS("+index+")'>解锁</button>";
			}else{
				return "<button onclick='SD("+index+")'>锁定</button>";
			}
		}
	}
	function CZ4(value,row,index){
		var id=row.teacherid;
		return "<button onclick='QX("+id+")'>权限</button>";
	}
	//权限
	function QX(){
		$('#teacherQxTab').datagrid({
			url:'Alljuse',
			method:'post',
			singleSelect:true,
			columns:[[
				{field:'jename',title:'角色名称',width:100},
				{field:'jeinsert',title:'添加',width:100,formatter:insertupd},
				{field:'jeupdate',title:'修改',width:100,formatter:updateupd},
				{field:'jedelete',title:'删除',width:100,formatter:deleteupd},
			]],
		});
		$("#teacherQxTabUpd").window("open");
	}
	function insertupd(value,row,index){
		var jeinsert=row.jeinsert;
		var jeid=row.jeid;
		if(jeinsert==1){
			return '<input type="checkbox" checked="checked" onclick="tianjiaxiugai('+jeinsert+","+jeid+')">'
		}else{
			return '<input type="checkbox" onclick="tianjiaxiugai('+jeinsert+","+jeid+')">'
		}
	}
	function updateupd(value,row,index){
		var jeupdate=row.jeupdate;
		var jeid=row.jeid;
		if(jeupdate==1){
			return '<input type="checkbox" checked="checked" onclick="xiugaixiugai('+jeupdate+","+jeid+')">'
		}else{
			return '<input type="checkbox" onclick="xiugaixiugai('+jeupdate+","+jeid+')">'
		}
	}
	function deleteupd(value,row,index){
		var jedelete=row.jedelete;
		var jeid=row.jeid;
		if(jedelete==1){
			return '<input type="checkbox" checked="checked" onclick="deletexiugai('+jedelete+","+jeid+')">'
		}else{
			return '<input type="checkbox" onclick="deletexiugai('+jedelete+","+jeid+')">'
		}
	}
	function tianjiaxiugai(jeinsert,jeid){
		alert(jeinsert)
		$.post('juseTianjia',{
			jeinsert:jeinsert,
			jeid:jeid,
			pd:jeinsert,
		},function(res){
			alert(res);
			window.location.reload();
		})
	}
	function xiugaixiugai(jeupdate,jeid){
		$.post('juseXiugai',{
			jeupdate:jeupdate,
			jeid:jeid,
			pd:jeupdate,
		},function(res){
			alert(res);
			window.location.reload();
		})
	}
	function deletexiugai(jedelete,jeid){
		$.post('juseShanchu',{
			jedelete:jedelete,
			jeid:jeid,
			pd:jedelete,
		},function(res){
			alert(res);
			window.location.reload();
		})
	}
	function UPDOP(index){
		var data=$("#teacherTab").datagrid("getData");
		var teachername=document.getElementById('teachername');
		var row=data.rows[index];
		$("#TeacherTabFrom").form("load", row);
//		teachername.disabled='disabled';
		$("#TeacherTabDiv").window("open");
		
	}
	function DEL(index){
		var data=$("#teacherTab").datagrid("getData");
		var row=data.rows[index];
		var id=row.teacherid;
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){
			if (r){
				$.post('deleteTeach',{
					teacherid:id,
				},function(res){
					$.messager.alert('操作提示',res);
					$('#teacherTab').datagrid('reload');
				});
			}
		});
	}
	function JS(index){
		var data=$("#teacherTab").datagrid("getData");
		var row=data.rows[index];
		var id=row.teacherid;
		$.post('JieSuo',{
			teacherid:id,
		},function(res){
			$.messager.alert('操作提示',res);
			$('#teacherTab').datagrid('reload');
		});
	}
	function SD(index){
		var data=$("#teacherTab").datagrid("getData");
		var row=data.rows[index];
		var id=row.teacherid;
		$.post('SuoDing',{
			teacherid:id,
		},function(res){
			$.messager.alert('操作提示',res);
			$('#teacherTab').datagrid('reload');
		});
	}
	function TeachAddInfo(){
		$.post('insertTeach',{
			teachname:$("#teachernameadd").val(),
			teachquanzhong:$("#teacherquanzhongadd").val(),
			teachpassword:$("#teacherpasswordadd").val(),
			teachphone:$("#teacherphoneadd").val(),
		},function(res){
			TeachAddCl();
			$.messager.alert('操作提示',res);
			$('#teacherTab').datagrid('reload');
		});
	}
	function TeachAddOp(){
//		teachername.disabled='';
		$("#TeacherTabDivAdd").window("open");
	}
	function TeachAddCl(){
		$("#TeacherTabDiv").window("close");
	}
	function TeachAddClAdd(){
		$("#TeacherTabDivAdd").window("close");
	}
	function TeachUpdInfo(){
		$.post('updateTeachById',{
			teacherid:$("#teacheridupd").val(),
			teachquanzhong:$("#jename").val(),
			teachpassword:$("#teacherpassword").val(),
			teachphone:$("#teacherphone").val(),
		},function(res){
			window.location.reload();
			$.messager.alert('操作提示',res);
		})
	}
</script>
<body>
<input type="checkbox" checked="checked">
<input type="checkbox" >
	<div id="DeleteData" style="float: left;"></div>
	<div id="UpdateData" style="float: left;"></div>
<div id="TeachTab" style="padding:5px 100px 7px 100px">
<div id="InsertData" style="float: left;"></div>
教师姓名<input type="text" id="teacherName" class="easyui-textbox" >

<select id="QxSuoDing">
<option value="">全体用户</option>
<option value="1">锁定用户</option>
<option value="0">未锁定用户</option>
</select>


<a href="javascript:void(0)" onclick="TeachSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
<a href="javascript:void(0)" style="float: right;" onclick="TeachAddOp()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
<a href="javascript:void(0)" style="float: right;" onclick="QX()" class="easyui-linkbutton">角色权限</a>
</div>
<table id="teacherTab"></table>

<div id="TeacherTabDiv" class="easyui-window" title="修改教师信息" style="width:400px;height:300px;text-align: center;padding-left: 75px" data-options="iconCls:'icon-save',modal:true,closed:true">
<form id="TeacherTabFrom" >
<table>
	<tr>
	<td>编号</td>
	<td><input type="text" name="teacherid" id="teacheridupd" disabled="disabled"></td>
	</tr>
	<tr>
	<td>姓名</td>
	<td><input type="text" name="teachname" id="teachername" disabled="disabled"></td>
	</tr>
	<tr>
	<td>网络状态</td>
	<td><input type="text" name="teachzhuangtai" disabled="disabled"></td>
	</tr>
	<tr>
	<td>职位</td>
	<td>
	<input type="text" name="jename" disabled="disabled">
	<select id="jename">
	<option value="2">网络咨询师</option>
	<option value="3">咨询师</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>密码</td>
	<td><input type="text" name="teachpassword" id="teacherpassword"></td>
	</tr>
	<tr>
	<td>电话</td>
	<td><input type="text" name="teachphone" id="teacherphone"></td>
	</tr>
	<tr>
	<td>签到时间</td>
	<td><input type="text" name="teachqiandaoshijian" disabled="disabled"></td>
	</tr>
	<tr>
	<td>签到次数</td>
	<td><input type="text" name="teachqiandaocishu" disabled="disabled"></td>
	<tr>
	<td>学生数量</td>
	<td><input type="text" name="teachxueshengshu" disabled="disabled"></td>
	</tr>
	<tr>
	<td><a href="javascript:void(0)" onclick="TeachUpdInfo()" class="easyui-linkbutton">确定</a></td>
	<td><a href="javascript:void(0)" onclick="TeachAddCl()" class="easyui-linkbutton">取消</a></td>
	</tr>

</table>

</form>
</div>

<div id="TeacherTabDivAdd" class="easyui-window" title="添加教师信息" style="width:250px;height:200px;text-align: center;" data-options="iconCls:'icon-save',modal:true,closed:true">
<form id="TeacherTabFromAdd">
<table>
	<tr>
	<td>姓名</td>
	<td><input type="text" id="teachernameadd" ></td>
	</tr>

	<tr>
	<td>职位</td>
	<td><input type="text"  id="teacherquanzhongadd"></td>
	</tr>
	
	<tr>
	<td>密码</td>
	<td><input type="text"  id="teacherpasswordadd"></td>
	</tr>
	
	<tr>
	<td>电话</td>
	<td><input type="text"  id="teacherphoneadd"></td>
	</tr>
	
	<tr>
	<td><a href="javascript:void(0)" onclick="TeachAddInfo()" class="easyui-linkbutton">确定</a></td>
	<td><a href="javascript:void(0)" onclick="TeachAddClAdd()" class="easyui-linkbutton">取消</a></td>
	</tr>

</table>
</form>
</div>
<div id="teacherQxTabUpd" class="easyui-window" title="修改权限" style="width:550px;height:300px;text-align: center;" data-options="iconCls:'icon-save',modal:true,closed:true">
<table id="teacherQxTab">
</table>
</div>
</body>
</html>
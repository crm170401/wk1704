<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/icon.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		initEmp();
	})
	function initEmp() {
		var sjiaofei2=$("#sjiaofei").val();
		if(sjiaofei2=="--请选择--"){
			sjiaofei2=null
		}
		$("#tab").datagrid({
			url : 'AllStu',
			method : 'post',
			pagination : true,
			singleSelect : true,
			checked:true,
			toolbar:"#tb",
			queryParams:{
				sname:$("#sname").val(),
				slianxi:$("#slianxi").val(),
				sjiaofei:sjiaofei2,
				sqq:$("#sqq").val()
			}
		
		});
		$("#ff").form("reset");
		/* $("#tab1").datagrid({
			url : 'AllStu',
			method : 'post',
			pagination : true,
			singleSelect : true

		}); */
		
		/* $("#barfrm").form("reset"); */
	}
	function caozuo(value, row, index) {
		return '<a href="javascript:void(0)" onclick="xiangxi('+index+')">查看</a>'
	}
	function huifang(value, row, index) {
		return '<a href="javascript:void(0)" onclick="huifangqingkuang('+index+')">查看</a>'
	}
	function xiangxi(index){
		var arr=$("#tab").datagrid("getData")
		var row=arr.rows[index]
		$("#tab1").datagrid({
			url : 'AllStuqk',
			method : 'post',
			pagination : true,
			singleSelect : true,
			toolbar:"tb2",
			queryParams : {
				sqstuid : row.stuid,
				shijian : $("#shijian").val(),
				timeup : $("#timeup").val(),
				timedown : $("#timedown").val()
			}
		});
		$("#huifang").window("open");
		$("#tb2").window("open");
	}
	function huifangqingkuang(index){
		var arr=$("#tab").datagrid("getData")
		var row=arr.rows[index]
		$("#tab2").datagrid({
			url : 'AllStuhf',
			method : 'post',
			pagination : true,
			singleSelect : true,
			queryParams : {
				hfxueshengid : row.stuid
			}
		});
		
		
		$("#huifang2").window("open");
	}
	
	function suoshu(value, row, index){
		return row.teacher.teachname
	} 
	function kecheng(value, row, index){
		return row.kecheng.kcname
	}  
	function addstu(){
		$("#addstufr").dialog("open")
	}
	/* function shifou(){
		return <input class="easyui-switchbutton" data-options="onText:'Yes',offText:'No'">
	} */
</script>


</head>
<body>
	<table class="easyui-datagrid" id="tab">
		<thead>
			<tr>
				<th data-options="field:'stuid'">学生编号</th>
				<th data-options="field:'sname'">学生姓名</th>
				<th data-options="field:'ssex'">性别</th>
				<th data-options="field:'saddress'">学生地址</th>
				<!-- <th data-options="field:'suoshujiaoshi',formatter:suoshu">学生所属教师</th> -->
				<th data-options="field:'slianxi'">联系方式</th>
				<th data-options="field:'semail'">邮箱</th>
				<th data-options="field:'sweixin'">微信</th>
				<th data-options="field:'sqq'">QQ</th>
				<!-- <th data-options="field:'skecheng',formatter:kecheng">课程</th> -->
<!-- 				<th data-options="field:'sshifouyouxiao'">是否有效</th>
				<th data-options="field:'swuxiaoyuanyin'">无效原因</th> -->
				<th data-options="field:'sjiaofei'">是否缴费</th>
				<th data-options="field:'sjiaofeishijian'">缴费时间</th>
				<th data-options="field:'slururen'">录入人</th>
				<th data-options="field:'sshifouyouxiao'">是否有效</th>
				<th data-options="field:'swuxiaoyuanyin'">无效原因</th>
				<th data-options="field:'suoshujiaoshi',formatter:suoshu">学生所属教师</th>
				<th data-options="field:'skecheng',formatter:kecheng">课程</th>
				<th data-options="field:' ',align:'right',formatter:caozuo">详细信息</th>
				<th data-options="field:'  ',formatter:huifang">回访信息</th>
			</tr>
		</thead>
	</table>
	
	<div id="huifang" class="easyui-window" data-options="title:'详细情况',closed:true">
		<table id="tab1">
		<thead>
			<tr>
				<th data-options="field:'sqid',hidden:'true'">情况id</th>
				<th data-options="field:'sqstuid'">客户编号</th>
				<!-- <th data-options="field:'sqhuifangshjian'">回访时间</th> -->
				<th data-options="field:'sqxueli'">学历</th>
				<th data-options="field:'sqzhiye'">职业</th>
				<th data-options="field:'sqlaiyuan'">来源</th>
				<th data-options="field:'sqguanzhu'">关注</th>
				<th data-options="field:'sqchuangjianshijian'">创建时间</th>
				<th data-options="field:'sqshifoushangmen'">是否上门</th>
				<th data-options="field:'sqshangmenshijian'">上门时间</th>
				<th data-options="field:'sqshoucihuifangshijian'">首次回访时间</th>
				<th data-options="field:'sqjinbanbeizhu'">进班备注</th>
				<th data-options="field:'sqshifoutuifei'">是否退费</th>
				<th data-options="field:'sqtuifeiyuanyin'">退费时间</th>
			</tr>
		</thead>
	</table>
	
	</div>
	
	
	<div id="huifang2" class="easyui-window" data-options="title:'回访情况',closed:true">
		<table id="tab2">
			<thead>
				<tr>
					<th data-options="field:'hfxueshengid'">客户id</th>
					<th data-options="field:'sid',hidden:'true'">回访情况id</th>
					<th data-options="field:'huifangshiji'">回访时间</th>
					<th data-options="field:'huifangren'">回访人</th>
					<th data-options="field:'kehuyixiang'">客户意向</th>
					<th data-options="field:'kehudengji'">客户等级</th>
					<th data-options="field:'shifoushangmen'">是否上门</th>
					<th data-options="field:'shangmenqingkuang'">上门时间</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div id="tb">
		<form id="ff">   
	        <label for="name">姓名:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />   
	        <label for="email">电话:</label>   
        	<input class="easyui-validatebox" id="slianxi" type="text"/>   
	        <label for="email">是否缴费:</label> 
	        <select id="sjiaofei">
	        	<option value="--请选择--" selected = "selected">--请选择--</option>
	        	<option value="是">是</option>
	        	<option value="否">否</option>
	        </select>  
        	<!-- <input class="easyui-validatebox" id="sjiaofei" type="text"/>    -->
	        <label for="email">QQ:</label>   
        	<input class="easyui-validatebox" id="sqq" type="text"/>   
        	<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="initEmp()">搜索</a> 
        	<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addstu()">添加学生</a> 
		</form>  
	</div>
	
	<div id="addstufr" class="easyui-dialog" title="添加学生" data-options="closed:true">
		<form id="addstu">
			<label for="name">姓名:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">性别:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">学生地址:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">联系方式:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" /><br>
			<label for="name">邮箱:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">微信:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">QQ:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">是否缴费:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" /><br>
			<label for="name">缴费时间:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">录入人:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">是否有效:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" /><br>
			<label for="name">无效原因:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">详细信息:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" />
			<label for="name">回访信息:</label>   
	        <input class="easyui-validatebox" id="sname" type="text" /><br>
		</form>
	</div>
	
	<!-- <div class="easyui-dialog" id="tb2" data-options="closed:true" >
		<form id="ff2">
			<select id="shijian">
	        	<option value="--请选择--" selected = "selected">--请选择--</option>
	        	<option value="sqchuangjianshijian">创建时间</option>
	        	<option value="sqchuangjianshijian">上门时间</option>
	        	<option value="sqchuangjianshijian">首次回访时间</option>
	        </select> 
			<label for="name">timeup:</label>   
	        <input class="easyui-datebox" id="sname" type="text" />  
			<label for="name">timedown:</label>   
	        <input class="easyui-datebox" id="sname" type="text" />  
		</form>
	</div> -->
	
</body>
</html>
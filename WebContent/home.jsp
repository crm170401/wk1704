<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<link rel="stylesheet" href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>

</head>
<script type="text/javascript">
$(function(){
	$("#linkbutton a").click(function(){
	                var title=$(this).text();
	                var src=$(this).attr("title");
	                if($("#tt").tabs("exists",title)){
	                	$("#tt").tabs("select",title);
	                } else {
	$('#tt').tabs('add',{   
	    title:title,   
	    content:'<iframe frameborder=0 style=width:100%;height:100% src='+ src +' ></iframe>',   
	    closable:true  
	});  
	 }
	});
	$('#linkbutton a').linkbutton({
	});
	});
</script>

<body>
	<div id="cc" class="easyui-layout" style="width:100%;height:640px;">   
    <div data-options="region:'north',title:'管理主页',split:true" style="height:100px;"></div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
    	<div id="aa" class="easyui-accordion" fit=true>
				<div title="用户管理" id="linkbutton"> 
				
					<a title="teacherAll.jsp">用户列表</a> <br />
				
				 	  <a title="${cxt}user/add">用户功能</a>
				</div>
			</div>
    </div>   
    <div data-options="region:'center',title:'操作提示'" style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs" fit=true>
			
		</div>
    </div>
</body>
</html>
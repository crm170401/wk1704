<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	var websocket = null;
	var sendUser = "${teachname}";
		if ('WebSocket' in window) {			
			websocket = new WebSocket("ws://localhost:8080/crm170401/chatDemo/"+sendUser);
		} else {
			alert('Not support websocket')
		} //连接发生错误的回调方法
		websocket.onerror = function() {
			console.log("WebSocket连接发生错误");
		} //连接成功建立的回调方法	 
		websocket.onopen = function(event) {
			console.log("WebSocket连接成功");
		} //接收到消息的回调方法	    
		websocket.onmessage = function(event) {
			//判断分割是统计人数还是显示消息
			setMessageInnerHTML(event.data);
		}
		//连接关闭的回调方法	         
		websocket.onclose = function() {
			console.log("连接关闭");
		}
		//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。	
		window.onbeforeunload = function() {
			websocket.close();
		}
	
	//将消息显示在网页上		    
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('showMsg').innerHTML += innerHTML;
	} //关闭连接
	function closeWebSocket() {
		websocket.close();
	}
	//发送消息		   
	
		
		
		
		
		function send() {
			var sendUser = "${teachname}";
			<%String ss=request.getParameter("teachname");%>
		   var ss="<%=ss%>";
			
			alert(ss);
			var toUser = ss;
			var message = document.getElementById("message").value;
			var jsonMsg = {
				"sendUser" : sendUser,
				"toUser" : toUser,
				"message" : message
			}
			websocket.send(JSON.stringify(jsonMsg));
			document.getElementById('showMsg').innerHTML += message;

		}
	
</script>
</head>
<body>
	<br /> 消息框:
	<br />
	<textarea rows="5" cols="5" id="showMsg" name="showMsg"
		disabled="disabled" style="width: 302px; height: 111px;"></textarea>
	<br />
	<textarea rows="5" cols="5" id="message" name="sendMsg"
		style="width: 302px; height: 111px;"></textarea>
	<br />
	<input type="button" value="发送" onclick="send()" />
	<input type="button" value="关闭" onclick="closeWebSocket()" />




</body>
</html>
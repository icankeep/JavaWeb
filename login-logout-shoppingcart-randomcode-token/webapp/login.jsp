<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function change(){
			//重新设置<img>元素的src属性
			document.getElementById("randomcodeImg").src="/randomcode?"+new Date().getTime();
		}
	</script>
</head>
<body>
	<%
		session.invalidate();
	%>
	<span style="background-color: red">${error}</span>
	<h3>用户登录</h3>
	<form action="/login" method="post">
		username:<input type="text" name="username" required/><br/>
		password:<input type="password" name="password" required/><br/>
		验证码：<input type="text" name="randomcode" size="8" maxlength="5" required/>
				<img src="/randomcode" id="randomcodeImg" style="cursor: pointer;" onclick="change();"/><br/>
		<input type="submit" value=" login "/>
	</form>
</body>
</html>
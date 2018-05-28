<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/shopping?cmd=save" method="POST">
			商品列表:<select name="name">
					<option>iphone</option>
					<option>ipad</option>
					<option>mac</option>
					<option>iWatch</option>
				</select><br/>
			商品数量<input type="number" name="number" min="1" required/><br/><br/>
			<input type="submit" value="添加到购物车"/>
		</form>
</body>
</html>
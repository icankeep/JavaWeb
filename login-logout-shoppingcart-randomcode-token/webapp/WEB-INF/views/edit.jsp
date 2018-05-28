<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<div align="left" style="background-color:orange;">
		当前用户：${sessionScope.USER_IN_SESSION.username}
	</div>
	<form action="/product?cmd=save" method="post">
		<input type="hidden" name="id" value="${product.id}"/>
		productName:<input type="text" name="productName" value="${product.productName}"/><br/>
		dir_id:		<input type="number" name="dir_id" value="${product.dir_id}"/><br/>
		salePrice:	<input type="number" name="salePrice" value="${product.salePrice}"/><br/>
		cutoff:		<input type="number" name="cutoff" value="${product.cutoff}"/><br/>
		costPrice:	<input type="number" name="costPrice" value="${product.costPrice}"/><br/>
		brand:		<input type="text" name="brand" value="${product.brand}"/><br/>
		supplier:	<input type="text" name="supplier" value="${product.supplier}"/><br/>
		dir:		<select>
						<option ${productDir.dir_id==1?"selected":""}>鼠标</option>
						<option ${productDir.dir_id==2?"selected":""}>有线鼠标</option>
						<option ${productDir.dir_id==3?"selected":""}>无线鼠标</option>
						<option ${productDir.dir_id==4?"selected":""}>游戏鼠标</option>
					</select><br/>
					<input type="submit" value='${product==null?"保存信息":"更新信息"}'/><br/>
	</form>
</body>
</html>
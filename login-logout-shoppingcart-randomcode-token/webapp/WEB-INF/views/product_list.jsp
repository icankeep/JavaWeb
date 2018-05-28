<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
</head>
<body>
	<div align="center" style="background-color:buttonhighlight;">
		当前用户：${sessionScope.USER_IN_SESSION.username} 
		<a href="/login.jsp">注销</a>
	</div>
	<hr/>
	<a href="/product?cmd=edit">添加商品</a>
	<table border="1" width="80%" cellspacing="0" cellpadding="0"> 
		<tr style="background-color: orange;font-family:serif;">
			<th>id</th>
			<th>productName</th>
			<th>dir_id</th>
			<th>salePrice</th>
			<th>cutoff</th>
			<th>costPrice</th>
			<th>brand</th>
			<th>supplier</th>
			<th>operate</th>
		</tr>
		<c:forEach items="${products}" var="product" varStatus="vs">
			<tr style='background-color:${vs.count % 2 == 0 ? "gray":""}'>
			<td>${product.id}</td>
			<td>${product.productName}</td>
			<td>${product.dir_id}</td>
			<td>${product.salePrice}</td>
			<td>${product.cutoff}</td>
			<td>${product.costPrice}</td>
			<td>${product.brand}</td>
			<td>${product.supplier}</td>
			<td><a href="/product?cmd=delete&id=${product.id}">删除</a>|<a href="/product?cmd=edit&id=${product.id}">编辑</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
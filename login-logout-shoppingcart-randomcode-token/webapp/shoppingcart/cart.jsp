<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	<table border="1">
		<tr align="center" style="background-color:buttonface;">
			<td colspan="5"><a href="/shoppingcart/shopping.jsp">go to shopping</a></td>
		</tr>
		<tr>
			<th>id</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>操作</th>
		</tr>
		<c:if test="${not empty SHOPPING_CART.list}">
			<c:forEach items="${SHOPPING_CART.list}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.number}</td>
					<td><a href="/shopping?cmd=delete&id=${item.id}">删除</a></td>
				</tr>			
			</c:forEach>
			<tr align="right">
				<td colspan="5">总金额：${SHOPPING_CART.totalPrice}</td>
			</tr>
		</c:if>
		<c:if test="${empty SHOPPING_CART.list}">
			<tr align="center">
				<td colspan="5">购物车都空啦，快去<a href="/shoppingcart/shopping.jsp">购物</a>吧</td>
			</tr>
		</c:if>
	</table>
</body>
</html>
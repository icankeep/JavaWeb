package com.passer.shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passer.shopping.domain.CartItem;
import com.passer.shopping.domain.ShoppingCart;

/**
*@author passer 
*@version 2018年5月27日下午7:25:14
*/
@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//接收请求参数
		String cmd = req.getParameter("cmd");
		//根据cmd执行操作
		if("save".equals(cmd)) {
			save(req,resp);
		}else if("delete".equals(cmd)) {
			delete(req,resp);
		}else {
			resp.sendRedirect("/shoppingcart/cart.jsp");
		}
	}
	
	protected void save(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//接收请求参数
		CartItem item = new CartItem();
		String name = req.getParameter("name");
		String number = req.getParameter("number");
		if("ipad".equals(name)) {
			item.setId("1");
			item.setPrice(new BigDecimal("999.99"));
		}else if("iphone".equals(name)) {
			item.setId("2");
			item.setPrice(new BigDecimal("888.88"));
		}else if("mac".equals(name)) {
			item.setId("3");
			item.setPrice(new BigDecimal("666.66"));
		}else{
			item.setId("4");
			item.setPrice(new BigDecimal("555.55"));
		}
		item.setName(name);
		item.setNumber(Integer.valueOf(number));
		
		ShoppingCart cart = null;
		if(req.getSession().getAttribute("SHOPPING_CART")==null) {
			cart=new ShoppingCart();
			req.getSession().setAttribute("SHOPPING_CART",cart);
		}else {
			cart=(ShoppingCart) req.getSession().getAttribute("SHOPPING_CART");
		}
		cart.save(item);
		resp.sendRedirect("shoppingcart/cart.jsp");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPING_CART");
		cart.remove(id);
		resp.sendRedirect("shoppingcart/cart.jsp");
	}
}

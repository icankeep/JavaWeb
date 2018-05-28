package com.passer.shopping.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*@author passer 
*@version 2018年5月27日下午4:09:06
*/
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//方式1：通过移除Session中的USER_IN_SESSION属性
		//req.getSession().removeAttribute("USER_IN_SESSION");
		//方式2：通过销毁Session
		//req.getSession().invalidate();
		//方式3：通过在登录界面写Java代码
		/*<%
			session.invalidate();
		%>*/
		//跳转到登录界面
		resp.sendRedirect("/login.jsp");
	}
}

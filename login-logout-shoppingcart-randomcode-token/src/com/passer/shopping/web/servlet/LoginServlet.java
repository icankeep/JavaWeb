package com.passer.shopping.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passer.shopping.dao.IUserDAO;
import com.passer.shopping.dao.impl.UserDAOImpl;
import com.passer.shopping.domain.User;

/**
*@author passer 
*@version 2018年5月27日下午3:11:06
*/
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IUserDAO userDAO;
	
	public void init() throws ServletException {
		userDAO=new UserDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接收请求参数
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String randomcode=req.getParameter("randomcode");
		//调用业务方法处理请求参数
		//获取当前用户名的用户对象
		User user=userDAO.getUserByUsername(username);
		//判断验证码是否正确
		if(!randomcode.equals(req.getSession().getAttribute("RANDOMCODE_IN_SESSION"))) {
			req.setAttribute("error","验证码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		//避免重复提交
		req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");
		//判断用户是否存在
		if(user.getId()==null) {
			req.setAttribute("error", username+"该用户不存在");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		//判断用户名和密码是否配对
		if(!user.getPassword().equals(password)) {
			req.setAttribute("error","账户或密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		//将当前用户对象共享到session中
		req.getSession().setAttribute("USER_IN_SESSION",user);
		resp.sendRedirect("/product");
		//控制页面跳转
	}
}

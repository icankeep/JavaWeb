package com.passer.shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passer.shopping.dao.IProductDAO;
import com.passer.shopping.dao.IProductDirDAO;
import com.passer.shopping.dao.impl.ProductDAOImpl;
import com.passer.shopping.dao.impl.ProductDirDAOImpl;
import com.passer.shopping.domain.Product;
import com.passer.shopping.domain.ProductDir;

/**
 * @author passer
 * @version 2018年5月26日上午11:56:21
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * IProductDAO接口对象
	 */
	private IProductDAO dao;

	/**
	 * 
	 */
	private IProductDirDAO productDirDAO;
	/**
	 * 初始化Product dao对象
	 */
	public void init() throws ServletException {
		dao = new ProductDAOImpl();
		productDirDAO=new ProductDirDAOImpl();
	}
	
	/**
	 * 通过cmd请求参数执行分发操作
	 * cmd="save" 执行保存操作
	 * cmd="edit" 执行保存或者更新操作
	 * cmd="delete" 执行删除操作
	 * cmd为其他值的时候 执行list操作
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		if(req.getSession().getAttribute("USER_IN_SESSION")==null) {
			resp.sendRedirect("/login.jsp");
			return;
		}
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		if("save".equals(cmd)) {
			save(req,resp);
		}else if("edit".equals(cmd)){
			edit(req,resp);
		}else if("delete".equals(cmd)) {
			delete(req,resp);
		}else {
			list(req,resp);
		}
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Long id=Long.valueOf(req.getParameter("id"));
		dao.delete(id);
		resp.sendRedirect("/product");
	}
	
	protected void save(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sid=req.getParameter("id");
		Product product=new Product();
		product.setProductName(req.getParameter("productName"));
		product.setDir_id(Long.valueOf(req.getParameter("dir_id")));
		product.setBrand(req.getParameter("brand"));
		product.setSupplier(req.getParameter("supplier"));
		product.setCostPrice(new BigDecimal(req.getParameter("costPrice")));
		product.setCutoff(new BigDecimal(req.getParameter("cutoff")));
		product.setSalePrice(new BigDecimal(req.getParameter("salePrice")));
		if(hasLength(sid)) {
			product.setId(Long.valueOf(req.getParameter("id")));
			dao.update(product);
		}else {
			System.out.println("save:"+product);
			dao.save(product);
		}
		resp.sendRedirect("/product");
	}
	
	protected void edit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sid=req.getParameter("id");
		if(hasLength(sid)) {
			Product product=dao.get(Long.valueOf(sid));
			ProductDir productDir=productDirDAO.get(product.getDir_id());
			req.setAttribute("product",product);
			req.setAttribute("productDir", productDir);
		}
		req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req,resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("products",dao.list());
		req.getRequestDispatcher("WEB-INF/views/product_list.jsp").forward(req, resp);
	}
	
	private boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}
}






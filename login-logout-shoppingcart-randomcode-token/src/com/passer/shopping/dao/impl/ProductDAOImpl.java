package com.passer.shopping.dao.impl;

import java.util.List;

import com.passer.shopping.dao.IProductDAO;
import com.passer.shopping.domain.Product;
import com.passer.shopping.handler.BeanListResultSetHandler;
import com.passer.shopping.handler.BeanResultSetHandler;
import com.passer.shopping.template.JdbcTemplate;

/**
*@author passer 
*@version 2018年5月26日上午9:53:41
*/
public class ProductDAOImpl implements IProductDAO{

	public void save(Product product) {
		String sql="INSERT INTO t_product (productName,dir_id,salePrice,cutoff,costPrice,brand,supplier) VALUES(?,?,?,?,?,?,?)";
		Object [] params=new Object[] {product.getProductName(),product.getDir_id(),product.getSalePrice(),product.getCutoff(),
				product.getCostPrice(),product.getBrand(),product.getSupplier()};
		JdbcTemplate.update(sql,params);
	}

	public void delete(Long id) {
		String sql="DELETE FROM t_product WHERE id=?";
		JdbcTemplate.update(sql, id);
	}

	public void update(Product product) {
		String sql="UPDATE t_product SET productName=?,dir_id=?,salePrice=?,cutoff=?,costPrice=?,brand=?,supplier=? WHERE id=?";
		Object [] params=new Object[] {product.getProductName(),product.getDir_id(),product.getSalePrice(),product.getCutoff(),
				product.getCostPrice(),product.getBrand(),product.getSupplier(),product.getId()};
		JdbcTemplate.update(sql, params);
	}

	public Product get(Long id) {
		String sql="SELECT * FROM t_product WHERE id=?";
		return JdbcTemplate.query(sql, new BeanResultSetHandler<>(Product.class), id);
	}

	public List<Product> list() {
		String sql="SELECT * FROM t_product";
		return JdbcTemplate.query(sql, new BeanListResultSetHandler<>(Product.class));
	}

	
	private boolean hasLength(String str) {
		return str!=null&&"".equals(str.trim());
	}
}

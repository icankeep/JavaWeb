package com.passer.shopping.dao.impl;

import java.util.List;

import com.passer.shopping.dao.IProductDirDAO;
import com.passer.shopping.domain.ProductDir;
import com.passer.shopping.handler.BeanListResultSetHandler;
import com.passer.shopping.handler.BeanResultSetHandler;
import com.passer.shopping.template.JdbcTemplate;

/**
*@author passer 
*@version 2018年5月26日下午6:56:15
*/
public class ProductDirDAOImpl implements IProductDirDAO{

	public void save(ProductDir productDir) {
		String sql="INSERT INTO t_productDir (name,parent_id) VALUES(?,?)";
		JdbcTemplate.update(sql,productDir.getName(),productDir.getParent_id());
	}

	@Override
	public void delete(Long dir_id) {
		String sql="DELETE FROM t_productDir WHERE dir_id=?)";
		JdbcTemplate.update(sql,dir_id);
		
	}

	@Override
	public void update(ProductDir productDir) {
		String sql="UPDATE t_productDir SET name=?,parent_id=?";
		JdbcTemplate.update(sql, productDir.getName(),productDir.getParent_id());
	}

	@Override
	public ProductDir get(Long id) {
		String sql="SELECT *FROM t_productDir WHERE dir_id=?";
		return JdbcTemplate.query(sql, new BeanResultSetHandler<>(ProductDir.class), id);
	}

	@Override
	public List<ProductDir> list() {
		String sql="SELECT * FROM t_productDir";
		return JdbcTemplate.query(sql, new BeanListResultSetHandler<>(ProductDir.class));
	}
	
}

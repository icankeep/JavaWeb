package com.passer.shopping.handler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.passer.shopping.domain.Product;

/**
*@author passer 
*@version 2018年5月26日下午5:28:07
*/
public class ProductResultSetHandler implements IResultSetHandler{

	@Override
	public List handler(ResultSet rs) throws Exception {
		List<Product> list=new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			list.add(product);
			product.setId(rs.getLong("id"));
			product.setBrand(rs.getString("brand"));
			product.setCostPrice(rs.getBigDecimal("costPrice"));
			product.setCutoff(rs.getBigDecimal("cutoff"));
			product.setDir_id(rs.getLong("dir_id"));
			product.setProductName(rs.getString("productName"));
			product.setSalePrice(rs.getBigDecimal("salePrice"));
			product.setSupplier(rs.getString("supplier"));
		}
		return list;
	}

}

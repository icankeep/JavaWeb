package com.passer.shopping.dao;

import java.util.List;

import com.passer.shopping.domain.Product;
import com.passer.shopping.domain.ProductDir;

/**
*@author passer 
*@version 2018年5月26日下午6:53:19
*/
public interface IProductDirDAO {
	
	void save(ProductDir productDir);

	void delete(Long dir_id);
	
	void update(ProductDir productDir);

	ProductDir get(Long id);

	List<ProductDir> list();
}

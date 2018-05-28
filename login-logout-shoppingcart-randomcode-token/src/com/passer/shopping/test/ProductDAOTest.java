package com.passer.shopping.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.passer.shopping.dao.IProductDAO;
import com.passer.shopping.dao.impl.ProductDAOImpl;
import com.passer.shopping.domain.Product;

/**
*@author passer 
*@version 2018年5月26日上午9:53:21
*/
class ProductDAOTest {

	IProductDAO dao=new ProductDAOImpl();
	@Test
	void testSave() {
		Product product=new Product();
		product.setBrand("brand");
		product.setCostPrice(new BigDecimal("1.99"));
		product.setCutoff(new BigDecimal("1.99"));
		product.setDir_id(2L);
		product.setProductName("productName");
		product.setSalePrice(new BigDecimal("1.99"));
		product.setSupplier("supplier");
		dao.save(product);
	}

	@Test
	void testDelete() {
		dao.delete(11L);
	}

	@Test
	void testUpdate() {
		Product product=new Product();
		product.setBrand("旺仔");
		product.setCostPrice(new BigDecimal("4.50"));
		product.setCutoff(new BigDecimal("1"));
		product.setDir_id(3L);
		product.setId(4L);
		product.setProductName("旺仔牛奶");
		product.setSalePrice(new BigDecimal("4.00"));
		product.setSupplier("supplier");
		dao.update(product);
	}

	@Test
	void testGet() {
		System.out.println(dao.get(4L));
	}

	@Test
	void testList() {
		for(Product pro:dao.list()) {
			System.out.println(pro);
		}
	}

}

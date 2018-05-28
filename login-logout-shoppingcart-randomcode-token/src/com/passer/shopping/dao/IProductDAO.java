package com.passer.shopping.dao;

import java.util.List;

import com.passer.shopping.domain.Product;

/**
 * @author passer
 * @version 2018年5月26日上午9:44:25
 */
public interface IProductDAO {
	/**
	 * 表示保存一个商品对象
	 * @param product 表示要保存的商品对象
	 */
	void save(Product product);

	/**
	 * 表示删除一个商品对象
	 * @param id 需要删除的商品的id
	 */
	void delete(Long id);

	/**
	 * 表示更新一个商品对象的属性
	 * @param newProduct	需要更新成对应的商品对象
	 */
	void update(Product newProduct);

	/**
	 * 表示获取一个指定id的商品对象
	 * @param id 返回对象的id	
	 * @return	  返回对应id的商品对象
	*/
	Product get(Long id);

	/**
	 * 表示获取所有的商品对象
	 * @return 返回装有所有商品对象的list
	 */
	List<Product> list();
}

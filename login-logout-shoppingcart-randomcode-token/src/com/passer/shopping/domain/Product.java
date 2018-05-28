package com.passer.shopping.domain;

import java.math.BigDecimal;

import lombok.Data;


/**
 * Product表示商品类，包括商品的商品名称价格等属性
 *
 */
@Data
public class Product {
	/**
	 * 	表示商品对象的id
	 */
	private Long id;
	
	/**
	 *  表示商品对象的名称
	 */
	private String productName;
	
	/**
	 *  表示商品对象的分类id
	 */
	private Long dir_id;
	
	/**
	 *  表示商品对象的出售价
	 */
	private BigDecimal salePrice;
	
	/**
	 *  表示商品对象的供应商
	 */
	private String supplier;
	
	/**
	 *  表示商品对象的品牌
	 */
	private String brand;
	
	/**
	 *  表示商品对象的折扣
	 */
	private BigDecimal cutoff;
	
	/**
	 *  表示商品对象的成本价
	 */
	private BigDecimal costPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getDir_id() {
		return dir_id;
	}

	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getCutoff() {
		return cutoff;
	}

	public void setCutoff(BigDecimal cutoff) {
		this.cutoff = cutoff;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	
}

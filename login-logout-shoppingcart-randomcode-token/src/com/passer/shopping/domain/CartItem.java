package com.passer.shopping.domain;

import java.math.BigDecimal;

import lombok.Data;


/**
*@author passer 
*@version 2018年5月27日下午5:11:47
*/
@Data
public class CartItem {

	private String id;
	private String name;
	private BigDecimal price;
	private Integer number;
	public CartItem() {}
	public CartItem(String id, String name, BigDecimal price, Integer number) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}

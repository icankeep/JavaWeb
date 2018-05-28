package com.passer.shopping.domain;
/**
*@author passer 
*@version 2018年5月27日下午5:08:57
*/

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingCart {
	//items保存购物车中所有的商品属性，包括价格数量等
	private List<CartItem> items = new ArrayList<>();
	
	//添加商品到购物车
	public void save(CartItem cartItem) {
		for(CartItem item:items) {
			if(item.getId().equals(cartItem.getId())) {
				item.setNumber(item.getNumber()+cartItem.getNumber());
				return;
			}
		}
		items.add(cartItem);
	}
	
	//移除购物车中的商品
	public void remove(String id) {
		Iterator<CartItem> it=items.iterator();
		while(it.hasNext()) {
			if(it.next().getId().equals(id)) {
				it.remove();
				break;
			}
		}
	}
	//获取当前所有的商品
	public List<CartItem> getList(){
		return items;
	}
	
	//计算当前购物车中的总价
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice=BigDecimal.ZERO;
		for(CartItem item:items) {
			totalPrice=totalPrice.add(totalPrice.add(item.getPrice().
					multiply(new BigDecimal(item.getNumber()))));
		}
		return totalPrice;
	}
}

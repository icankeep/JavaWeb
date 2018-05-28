package com.passer.shopping.domain;

import lombok.Data;

/**
*@author passer 
*@version 2018年5月26日下午6:51:30
*/
@Data
public class ProductDir {
	private Long dir_id;
	private String name;
	private Long parent_id;
	public Long getDir_id() {
		return dir_id;
	}
	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
}

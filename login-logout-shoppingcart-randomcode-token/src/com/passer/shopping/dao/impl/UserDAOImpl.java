package com.passer.shopping.dao.impl;

import com.passer.shopping.dao.IUserDAO;
import com.passer.shopping.domain.User;
import com.passer.shopping.handler.BeanResultSetHandler;
import com.passer.shopping.template.JdbcTemplate;

/**
*@author passer 
*@version 2018年5月27日下午3:05:43
*/
public class UserDAOImpl implements IUserDAO{
	
	public User getUserByUsername(String username) {
		String sql="SELECT * FROM t_user WHERE username=?";
		return JdbcTemplate.query(sql, new BeanResultSetHandler<>(User.class),username);
	}
}

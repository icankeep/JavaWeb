package com.passer.shopping.dao;

import com.passer.shopping.domain.User;

/**
*@author passer 
*@version 2018年5月27日下午3:04:31
*/
public interface IUserDAO {
	User getUserByUsername(String username);
}

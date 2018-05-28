package com.passer.shopping.handler;

import java.sql.ResultSet;
import java.util.List;

/**
*@author passer 
*@version 2018年5月26日下午5:25:59
*/
public interface IResultSetHandler<T> {
	T handler(ResultSet rs) throws Exception;
}

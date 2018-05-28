package com.passer.shopping.handler;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

/**
*@author passer 
*@version 2018年5月26日下午5:55:24
*/
public class BeanResultSetHandler <T> implements IResultSetHandler<T>{

	private Class<T> classType;
	public BeanResultSetHandler(Class<T> classType) {
		this.classType=classType;
	}
	
	public T handler(ResultSet rs) throws Exception {
		T obj=classType.newInstance();
		PropertyDescriptor[] pds = Introspector.getBeanInfo(classType,Object.class).getPropertyDescriptors();
		while(rs.next()) {
			for (PropertyDescriptor pd : pds) {
				pd.getWriteMethod().invoke(obj, rs.getObject(pd.getName()));
			}
		}
		return obj;
	}
}

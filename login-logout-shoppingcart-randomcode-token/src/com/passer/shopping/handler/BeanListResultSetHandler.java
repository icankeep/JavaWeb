package com.passer.shopping.handler;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
*@author passer 
*@version 2018年5月26日下午6:11:45
*/
public class BeanListResultSetHandler<T> implements IResultSetHandler<List<T>>{

	private Class<T> classType;
	public BeanListResultSetHandler(Class<T> classType) {
		this.classType=classType;
	}
	public List<T> handler(ResultSet rs) throws Exception {
		T obj;
		List<T> list=new ArrayList<>();
		PropertyDescriptor[] pds = Introspector.getBeanInfo(classType,Object.class).getPropertyDescriptors();
		while(rs.next()) {
			obj=classType.newInstance();
			for (PropertyDescriptor pd : pds) {
				pd.getWriteMethod().invoke(obj,rs.getObject(pd.getName()));
			}
			list.add(obj);
		}
		return list;
	}

}

package com.passer.shopping.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
*@author passer 
*@version 2018年5月26日下午4:56:16
*/
public class JdbcUtil {
	private JdbcUtil() {}
	private static DataSource dataSource=null;
	static {
		try {
			Properties properties=new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			Class.forName(properties.getProperty("driverClassName"));
			dataSource=DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
		} finally {
			try {
				if(st!=null) {
					st.close();
				}
			} catch (Exception e) {
			} finally {
				try {
					if(conn!=null) {
						conn.close();
					}
				} catch (Exception e) {
				} 
			}
		}
	}
}

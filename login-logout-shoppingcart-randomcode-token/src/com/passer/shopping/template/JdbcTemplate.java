package com.passer.shopping.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.passer.shopping.handler.IResultSetHandler;
import com.passer.shopping.util.JdbcUtil;

/**
*@author passer 
*@version 2018年5月26日下午5:13:18
*/


//JDBC操作模板类
public class JdbcTemplate {
	
	public static void update(String sql,Object ...params) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
	}
	
	/**
	 * DQL操作模板 （查询）模板
	 * @param sql			DQL操作中的SQL模板（带有占位符？）
	 * @param params		SQL模板中？对应的参数值
	 * @return				返回list集合
	 */
	public static <T> T query(String sql,IResultSetHandler<T> rsh,Object ...params) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtil.getConnection();
			ps=conn.prepareStatement(sql);
			for(int index=0;index<params.length;index++) {
				ps.setObject(index+1,params[index]);
			}
			return rsh.handler(ps.executeQuery());
		}catch(Exception e) {
		}finally {
			JdbcUtil.close(conn, ps, null);
		}
		return null;
	}
}

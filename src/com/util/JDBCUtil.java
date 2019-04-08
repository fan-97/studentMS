﻿package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {

	private static ComboPooledDataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource(); // 创建数据库连接池实例
	}

	/**
	 * 获取数据库连接池
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void clocloResource(ResultSet rs, Statement st, Connection conn) {
		cloResult(rs);
		cloState(st);
		cloConn(conn);
	}

	public static void cloConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void cloState(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void cloResult(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

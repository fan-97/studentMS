package com.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.AdminDao;
import com.domain.AdminBean;
import com.util.JDBCUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean login(String user, String password) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from admin where account = ? and password = ?";
		try {
			if (runner.query(sql,new BeanHandler<AdminBean>(AdminBean.class),user,password)!=null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

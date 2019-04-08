package com.dao;

public interface AdminDao {
	/**
	 * 管理员登录
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean login(String user,String password);
}

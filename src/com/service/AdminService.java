package com.service;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean login(String user,String password);
}

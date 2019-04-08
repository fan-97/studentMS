package com.service.impl;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean login(String user, String password) {
		AdminDao dao = new AdminDaoImpl();
		return dao.login(user, password);
	}
	
}

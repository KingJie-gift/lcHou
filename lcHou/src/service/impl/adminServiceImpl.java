package service.impl;

import dao.impl.adminDaoImpl;
import entity.admin;
import service.adminService;

public class adminServiceImpl implements adminService {
	 adminDaoImpl dao=new adminDaoImpl();
	@Override
	public admin login(String name, String pwd) {
		return dao.login(name, pwd);
	}

}

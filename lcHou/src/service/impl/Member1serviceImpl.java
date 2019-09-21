package service.impl;

import java.util.List;

import dao.impl.Member1DaoImpl;
import entity.Member1;
import service.Member1service;

public class Member1serviceImpl implements Member1service {
   Member1DaoImpl md=new Member1DaoImpl();
	@Override
	public List<Member1> getMember1sList() {
		// TODO Auto-generated method stub
		return md.getMember1sList();
	}
	@Override
	public int selectid(String name) {
		// TODO Auto-generated method stub
		return md.selectid(name);
	}
	@Override
	public List<Member1> getbyName(int id) {
		// TODO Auto-generated method stub
		return md.getbyName(id);
	}

}

package service.impl;

import java.util.List;

import dao.impl.memberDaoImpl;
import entity.member;
import entity.pag;
import service.memberService;

public class memberServiceImpl implements memberService {
	memberDaoImpl dao=new memberDaoImpl();
	@Override
	public int add(member m) {
		// TODO Auto-generated method stub
		return dao.add(m);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(member m) {
		// TODO Auto-generated method stub
		return dao.update(m);
	}

	@Override
	public member getMember(int id) {
		// TODO Auto-generated method stub
		return dao.getMember(id);
	}

	@Override
	public List<member> query(pag p, String name, int cid) {
		// TODO Auto-generated method stub
		return dao.query(p, name, cid);
	}

	@Override
	public int count(String name, int cid) {
		// TODO Auto-generated method stub
		return dao.count(name, cid);
	}

	@Override
	public List<member> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public member selectMem(String name) {
		// TODO Auto-generated method stub
		return dao.selectMem(name);
	}

}

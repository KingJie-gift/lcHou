package service.impl;

import java.util.List;

import dao.impl.ClassTalkDaoImpl;
import entity.ClassTalk;
import entity.Page1;
import service.ClassTalkservice;

public class ClassTalkserviceImpl implements ClassTalkservice {
ClassTalkDaoImpl ctd=new ClassTalkDaoImpl();
	@Override
	public int insert(ClassTalk ct) {
		// TODO Auto-generated method stub
		return ctd.insert(ct);
	}

	@Override
	public List<ClassTalk> select(int id) {
		// TODO Auto-generated method stub
		return ctd.select(id);
	}

	@Override
	public List<ClassTalk> getByName(String name) {
		// TODO Auto-generated method stub
		return ctd.getByName(name);
	}

	
	@Override
	public int getAllCount(int count, int id) {
		// TODO Auto-generated method stub
		return ctd.getAllCount(count, id);
	}

	@Override
	public List<ClassTalk> weekById(Page1 p, int count, int id) {
		// TODO Auto-generated method stub
		return ctd.weekById(p, count, id);
	}

	@Override
	public int checkTalk(String name) {
		// TODO Auto-generated method stub
		return ctd.checkTalk(name);
	}

	@Override
	public int update(ClassTalk ct) {
		// TODO Auto-generated method stub
		return ctd.update(ct);
	}

	@Override
	public List<ClassTalk> jree(String name) {
		// TODO Auto-generated method stub
		return ctd.jree(name);
	}



}

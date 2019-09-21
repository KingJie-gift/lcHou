package service.impl;

import java.util.List;

import dao.impl.studentDaoImpl;
import entity.Page;
import entity.student;
import service.studentService;

public class studentServiceImpl implements studentService {
studentDaoImpl dao=new studentDaoImpl();
	@Override
	public List<student> getList(int cid) {
		// TODO Auto-generated method stub
		return dao.getList(cid);
	}

	@Override
	public student getStu(int id) {
		// TODO Auto-generated method stub
		return dao.getStu(id);
	}

	@Override
	public List<student> getStudentSelect() {
		// TODO Auto-generated method stub
		return dao.getStudentSelect();
	}

	@Override
	public int getStudentdelete(int id) {
		// TODO Auto-generated method stub
		return dao.getStudentdelete(id);
	}

	@Override
	public int getStudnetupdate(student st) {
		// TODO Auto-generated method stub
		return dao.getStudnetupdate(st);
	}

	@Override
	public student getStudentId(int id) {
		// TODO Auto-generated method stub
		return dao.getStudentId(id);
	}

	@Override
	public int getStudentinsert(student st) {
		// TODO Auto-generated method stub
		return dao.getStudentinsert(st);
	}

	@Override
	public List getPageList(Page p,String name,int id) {
		return dao.getPageList(p,name,id);
	}

	@Override
	public int count(String name,int id) {
		return dao.count(name,id);
	}

	@Override
	public List<student> getsName(int id) {
		// TODO Auto-generated method stub
		return dao.getsName(id);
	}

}

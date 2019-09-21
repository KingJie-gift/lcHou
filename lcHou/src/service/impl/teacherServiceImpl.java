package service.impl;

import java.util.List;

import dao.impl.teacherDaoImpl;
import entity.Page;
import entity.teacher;
import service.teacherService;

public class teacherServiceImpl implements teacherService {
teacherDaoImpl dao=new teacherDaoImpl();
	@Override
	public teacher selectTea(String name, String pwd) {
		return dao.selectTea(name, pwd);
	}
	@Override
	public List<teacher> getTeacherselect() {
		// TODO Auto-generated method stub
		return dao.getTeacherselect();
	}
	@Override
	public int getTeacherdelete(int id) {
		// TODO Auto-generated method stub
		return dao.getTeacherdelete(id);
	}
	@Override
	public int getTeacherinsert(teacher ta) {
		// TODO Auto-generated method stub
		return dao.getTeacherinsert(ta);
	}
	@Override
	public int getTeacherupdate(teacher ta) {
		// TODO Auto-generated method stub
		return dao.getTeacherupdate(ta);
	}
	@Override
	public teacher getTeacher(int id) {
		// TODO Auto-generated method stub
		return dao.getTeacher(id);
	}
	@Override
	public List getPageList(Page p,String name) {
		// TODO Auto-generated method stub
		return dao.getPageList(p,name);
	}
	@Override
	public int count(String name) {
		// TODO Auto-generated method stub
		return dao.count(name);
	}
	@Override
	public int setea(String name) {
		// TODO Auto-generated method stub
		return dao.setea(name);
	}

}

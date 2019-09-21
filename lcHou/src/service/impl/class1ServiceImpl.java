package service.impl;

import java.util.List;

import dao.impl.class1DaoImpl;
import entity.Page;
import entity.class1;
import service.class1Service;

public class class1ServiceImpl implements class1Service {

	class1DaoImpl dao=new class1DaoImpl();
	public List<class1> getList() {
		return dao.getList();
	}

	@Override
	public class1 getClass(int id) {
		return dao.getClass(id);
	}

	@Override
	public List<class1> getbyTea(int teaid) {
		return dao.getbyTea(teaid);
	}

	@Override
	public List<class1> getClassSelect() {
		// TODO Auto-generated method stub
		return dao.getClassSelect();
	}

	@Override
	public int getClassdelete(int id) {
		// TODO Auto-generated method stub
		return dao.getClassdelete(id);
	}

	@Override
	public int getClassUpdate(class1 cs) {
		// TODO Auto-generated method stub
		return dao.getClassUpdate(cs);
	}

	@Override
	public class1 getByClassId(int id) {
		// TODO Auto-generated method stub
		return dao.getByClassId(id);
	}

	@Override
	public int getClassinsert(class1 cs) {
		// TODO Auto-generated method stub
		return dao.getClassinsert(cs);
	}

	@Override
	public List getPageList(Page p) {
		// TODO Auto-generated method stub
		return dao.getPageList(p);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public class1 getclass(int id) {
		// TODO Auto-generated method stub
		return dao.getclass(id);
	}

	@Override
	public List<class1> getclassList(int id) {
		// TODO Auto-generated method stub
		return dao.getclassList(id);
	}

	@Override
	public class1 getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<class1> getClassname(int id) {
		// TODO Auto-generated method stub
		return dao.getClassname(id);
	}

}

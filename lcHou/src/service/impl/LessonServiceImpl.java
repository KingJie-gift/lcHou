package service.impl;

import java.util.List;

import dao.impl.LessonDaoImpl;
import entity.lesson;
import service.LessonService;

public class LessonServiceImpl implements LessonService {
 LessonDaoImpl le=new LessonDaoImpl();
	@Override
	public int insert(lesson l) {
		// TODO Auto-generated method stub
		return le.insert(l);
	}

	@Override
	public List<lesson> getlessList() {
		// TODO Auto-generated method stub
		return le.getlessList();
	}

	@Override
	public int checklesson(int classid, int none, String week) {
		// TODO Auto-generated method stub
		return le.checklesson(classid, none, week);
	}

	@Override
	public List<lesson> getById(int id) {
		// TODO Auto-generated method stub
		return le.getById(id);
	}

	@Override
	public List<lesson> getbyName(int id) {
		// TODO Auto-generated method stub
		return le.getbyName(id);
	}

}

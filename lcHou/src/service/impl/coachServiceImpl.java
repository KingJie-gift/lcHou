package service.impl;

import java.util.List;

import dao.impl.coachDaoImpl;
import entity.coach;
import service.coachService;

public class coachServiceImpl implements coachService {
	coachDaoImpl dao=new coachDaoImpl();
	@Override
	public coach getCoach(int id) {
		// TODO Auto-generated method stub
		return dao.getCoach(id);
	}

	@Override
	public List<coach> getCoachSelect() {
		// TODO Auto-generated method stub
		return dao.getCoachSelect();
	}

	@Override
	public coach getCoachID(int id) {
		// TODO Auto-generated method stub
		return dao.getCoachID(id);
	}

}

package service.impl;

import java.util.List;

import dao.impl.interviewDaoImpl;
import entity.interview;
import entity.pag;
import service.interviewService;

public class interviewServiceImpl implements interviewService {
interviewDaoImpl dao=new interviewDaoImpl();
	@Override
	public int add(interview inter) {
		// TODO Auto-generated method stub
		return dao.add(inter);
	}

	 

	@Override
	public List<interview> selectStu(pag p,int id) {
		// TODO Auto-generated method stub
		return dao.selectStu(p,id);
	}

	@Override
	public List<interview> lastWeek(pag p,int id) {
		// TODO Auto-generated method stub
		return dao.lastWeek(p,id);
	}

	 

	@Override
	public int getlastAllount(int id) {
		// TODO Auto-generated method stub
		return dao.getlastAllount(id);
	}

	 

	@Override
	public List<interview> month(pag p, int id) {
		// TODO Auto-generated method stub
		return dao.month(p, id);
	}

	@Override
	public int month(int id) {
		// TODO Auto-generated method stub
		return dao.month(id);
	}

	@Override
	public List<interview> getChart(int id) {
		// TODO Auto-generated method stub
		return dao.getChart(id);
	}

	@Override
	public List<interview> selectNow(pag p, int mem) {
		// TODO Auto-generated method stub
		return dao.selectNow(p, mem);
	}

	@Override
	public int selectNow(int mem) {
		// TODO Auto-generated method stub
		return dao.selectNow(mem);
	}

	@Override
	public List<interview> queryOne(pag p, int cid, int stuid, String time) {
		// TODO Auto-generated method stub
		return dao.queryOne(p, cid, stuid, time);
	}

	@Override
	public int queryOne(int cid, int stuid, String time) {
		// TODO Auto-generated method stub
		return dao.queryOne(cid, stuid, time);
	}



	@Override
	public List<interview> query( int cid, int stuid, String time) {
		// TODO Auto-generated method stub
		return dao.query(cid, stuid, time);
	}



	@Override
	public int getAllount(int cid, int stuid, String time) {
		// TODO Auto-generated method stub
		return dao.getAllount(cid, stuid, time);
	}



	@Override
	public List<interview> queryPeo(int stuid,String time) {
		// TODO Auto-generated method stub
		return dao.queryPeo(stuid,time);
	}



	@Override
	public int update(interview inter) {
		// TODO Auto-generated method stub
		return dao.update(inter);
	}



	@Override
	public int check(int id) {
		// TODO Auto-generated method stub
		return dao.check(id);
	}
	
}



	 

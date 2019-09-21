package service;

import java.util.List;

import entity.interview;
import entity.pag;



public interface interviewService {
	//个人展示
	int check(int id); 
	List<interview> queryPeo(int stuid,String time);
	int update(interview inter);
	
	List<interview> selectNow(pag p,int mem);
	int selectNow(int mem);
	
	int add(interview inter);
	List<interview> queryOne(pag p,int cid,int stuid,String time);
	int queryOne(int cid,int stuid,String time);
	List<interview> selectStu(pag p,int id);
	List<interview> lastWeek(pag p, int id);
	int getlastAllount(int id);
	List<interview> month(pag p, int id);
	int month(int id);
	List<interview> getChart(int id);
	List<interview> query(int cid,int stuid,String time);
	int getAllount(int cid,int stuid,String time);
}

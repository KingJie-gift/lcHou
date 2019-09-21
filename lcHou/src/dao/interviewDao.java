package dao;

import java.util.List;

import entity.interview;
import entity.pag;



public interface interviewDao {
	int add(interview inter);
	int check(int id);
	int update(interview inter);
	//
	List<interview> queryPeo(int stuid,String time);
	
	List<interview> queryOne(pag p,int cid,int stuid,String time);
	int queryOne(int cid,int stuid,String time);
	List<interview> selectNow(pag p,int mem);
	int selectNow(int mem);
	List<interview> selectStu(pag p,int id);
	List<interview> lastWeek(pag p, int id);
	List<interview> query(int cid,int stuid,String time);
	int getAllount(int cid,int stuid,String time);
	List<interview> month(pag p, int id);
	int month(int id);
	int getlastAllount(int id);
	
	//报表展示的信息(近一个月)
	List<interview> getChart(int id);

	
}

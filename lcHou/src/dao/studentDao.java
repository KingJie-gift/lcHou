package dao;

import java.util.List;

import entity.Page;
import entity.student;

public interface studentDao {

	List<student> getList(int cid);
	student getStu(int id);
	student selectStu(String account,String pwd);
	//学员基础操作
	
	List<student> getStudentSelect();
	int getStudentdelete(int id);
	
	int getStudnetupdate(student st);
	student getStudentId(int id);
	
	int getStudentinsert(student st);
	 List getPageList(Page p,String name,int id);
	    int count(String name,int id);
	    
	  //小演講查詢學生名字
		List<student> getsName(int id);
}

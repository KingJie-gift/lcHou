package dao;

import java.util.List;

import entity.Page;
import entity.student;

public interface studentDao {

	List<student> getList(int cid);
	student getStu(int id);
	student selectStu(String account,String pwd);
	//ѧԱ��������
	
	List<student> getStudentSelect();
	int getStudentdelete(int id);
	
	int getStudnetupdate(student st);
	student getStudentId(int id);
	
	int getStudentinsert(student st);
	 List getPageList(Page p,String name,int id);
	    int count(String name,int id);
	    
	  //С���v��ԃ�W������
		List<student> getsName(int id);
}

package service;

import java.util.List;

import entity.Page;
import entity.teacher;

public interface teacherService {
	teacher selectTea(String name,String pwd);
	
	
	//教师基础操作

	List<teacher> getTeacherselect();
	int getTeacherdelete(int id);
	int getTeacherinsert(teacher ta);
	int getTeacherupdate(teacher ta);
	teacher getTeacher(int id);
	 List getPageList(Page p,String name);
	    int count(String name);

	    
		  //小演讲登录
		    int setea(String name);

}

package dao;

import java.util.List;

 


import entity.Page;
import entity.class1;
import entity.pag;

public interface class1Dao {

	List<class1> getList();
	class1 getClass(int id);
	List<class1> getbyTea(int teaid);
	
	
	//班级基础操作
	List<class1> getClassSelect();
	int getClassdelete(int id);
	int getClassUpdate(class1 cs);
    class1 getByClassId(int id);
    int getClassinsert(class1 cs);
    List getFen(pag p);
    List getPageList(Page p);
    int count();
    
    //小演讲方法
    class1 getclass(int id);
    List<class1> getclassList(int id);
    class1 getById(int id);
    List<class1> getClassname(int id);
   
}

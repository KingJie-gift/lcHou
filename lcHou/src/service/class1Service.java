package service;

import java.util.List;

import entity.Page;
import entity.class1;

public interface class1Service {

	List<class1> getList();
	class1 getClass(int id);
	List<class1> getbyTea(int teaid);
	
	
	//�༶��������
	List<class1> getClassSelect();
	int getClassdelete(int id);
	int getClassUpdate(class1 cs);
    class1 getByClassId(int id);
    int getClassinsert(class1 cs);
    
    List getPageList(Page p);
    int count();

  //С�ݽ�����
    class1 getclass(int id);
    List<class1> getclassList(int id);
    class1 getById(int id);
    List<class1> getClassname(int id);
}

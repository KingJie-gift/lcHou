package dao;

import java.util.List;

 


import entity.Page;
import entity.teacher;

public interface teacherDao {
	teacher selectTea(String name,String pwd);
List<teacher> getList();


//��ʦ��������

List<teacher> getTeacherselect();
int getTeacherdelete(int id);
int getTeacherinsert(teacher ta);
int getTeacherupdate(teacher ta);
teacher getTeacher(int id);
List getPageList(Page p,String name);
int count(String name);


//С�ݽ���¼
int setea(String name);
}

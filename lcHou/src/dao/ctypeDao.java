package dao;

import java.util.List;

import entity.Ctype;

public interface ctypeDao {
	List<Ctype>  getCtypeList();
	Ctype getCtypeID(int id);
	
	
	

}

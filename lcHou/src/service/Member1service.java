package service;

import java.util.List;

import entity.Member1;

public interface Member1service {
	List<Member1> getMember1sList();
	int selectid(String name);
	
	List<Member1> getbyName(int id);
}

package service;

import java.util.List;

import entity.member;
import entity.pag;

public interface memberService {
	member selectMem(String name);
	
	List<member> list();
	int add(member m);
	int delete(int id);
	int update(member m);
	member getMember(int id);
    List<member> query(pag p,String name,int cid);
    int count(String name,int cid);
}

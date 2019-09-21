package service.impl;

import java.util.List;

import dao.impl.CtypeDaoimpl;
import entity.Ctype;
import service.ctypeService;

public class ctypeServiceImpl implements ctypeService {
	CtypeDaoimpl dao=new CtypeDaoimpl();
	@Override
	public List<Ctype> getCtypeList() {
		// TODO Auto-generated method stub
		return dao.getCtypeList();
	}

	@Override
	public Ctype getCtypeID(int id) {
		// TODO Auto-generated method stub
		return dao.getCtypeID(id);
	}

}

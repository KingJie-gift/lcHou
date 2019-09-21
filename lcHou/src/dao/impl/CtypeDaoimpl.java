package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ctypeDao;
import entity.Ctype;

public class CtypeDaoimpl extends BaseDao implements ctypeDao {

	@Override
	public List<Ctype> getCtypeList() {
		List<Ctype> list=new ArrayList<Ctype>();
		String sql="SELECT * FROM classtype";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				Ctype ct=new Ctype();
				ct.setTypeid(rs.getInt("typeid"));
				ct.setTypename(rs.getString("typename"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
	}
		return list;
	}

	@Override
	public Ctype getCtypeID(int id) {
		Ctype ct=null;
		String sql="SELECT * FROM classtype WHERE typeid=?";
		super.executeQuery(sql,id);
		try {
			while(rs.next()){
				 ct=new Ctype();
				ct.setTypeid(rs.getInt("typeid"));
				ct.setTypename(rs.getString("typename"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
	}
		return ct;
	}
	

}

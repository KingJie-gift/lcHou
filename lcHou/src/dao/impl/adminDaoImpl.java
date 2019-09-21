package dao.impl;

import java.sql.SQLException;

import dao.BaseDao;
import dao.adminDao;
import entity.admin;

public class adminDaoImpl extends BaseDao implements adminDao {

	@Override
	public admin login(String name, String pwd) {
		String sql="SELECT * FROM admin WHERE NAME =? AND pwd=md5(?)";
		super.executeQuery(sql, name,pwd);
		admin admin=null;
		try {
			while(rs.next()){
				admin=new admin();
				admin.setName(rs.getString("name"));
				admin.setPwd(rs.getString("pwd"));
				admin.setType(rs.getInt("type"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return admin;
	}

}

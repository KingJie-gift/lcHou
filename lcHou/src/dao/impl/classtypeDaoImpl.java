package dao.impl;

import java.sql.SQLException;

import dao.BaseDao;
import dao.classtypeDao;
import entity.classtype;

public class classtypeDaoImpl extends BaseDao implements classtypeDao {

	@Override
	public classtype getType(int typeid) {
		String sql="SELECT * FROM class WHERE typeid=?";
		super.executeQuery(sql, typeid);
		classtype c=new classtype();
		try {
			while(rs.next()){
				c.setTypeid(rs.getInt("typeid"));
				c.setTypename(rs.getString("typename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return c;
	}

}

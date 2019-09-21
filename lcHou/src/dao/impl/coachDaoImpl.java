package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.coachDao;
import entity.coach;
import entity.teacher;

public class coachDaoImpl extends BaseDao implements coachDao {

	@Override
	public coach getCoach(int id) {
		String sql="SELECT * FROM coach WHERE id=?";
		super.executeQuery(sql,id);
		coach t=new coach();
		try {
			while(rs.next()){
				t.setAccount(rs.getString("account"));
				t.setDis(rs.getInt("dis"));
				t.setIntro(rs.getString("intro"));
				t.setMotto(rs.getString("motto"));
				t.setName(rs.getString("name"));
				t.setPhone(rs.getString("phone"));
				t.setPwd(rs.getString("pwd"));
				t.setImage(rs.getString("image"));
				t.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return t;
	}
	
	
	
	
	@Override
	public List<coach> getCoachSelect() {
		List<coach> list=new ArrayList<coach>();
		String sql="SELECT * FROM coach";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				coach ca=new coach();
				ca.setAccount(rs.getString("account"));
				ca.setDis(rs.getInt("dis"));
				ca.setImage(rs.getString("image"));
				ca.setIntro(rs.getString("intro"));
				ca.setMotto(rs.getString("motto"));
				ca.setName(rs.getString("name"));
				ca.setId(rs.getInt("id"));
				ca.setPhone(rs.getString("phone"));
				ca.setPwd(rs.getString("pwd"));
				list.add(ca);
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
	public coach getCoachID(int id) {
		coach ca=null;
		String sql="SELECT * FROM coach WHERE id=?";
		super.executeQuery(sql,id);
		try {
			while(rs.next()){
				 ca=new coach();
				ca.setAccount(rs.getString("account"));
				ca.setDis(rs.getInt("dis"));
				ca.setImage(rs.getString("image"));
				ca.setIntro(rs.getString("intro"));
				ca.setMotto(rs.getString("motto"));
				ca.setName(rs.getString("name"));
				ca.setPhone(rs.getString("phone"));
				ca.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
	}
		return ca;
	}

}

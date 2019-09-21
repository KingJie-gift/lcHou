package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.teacherDao;
import entity.Page;
import entity.teacher;

public class teacherDaoImpl extends BaseDao implements teacherDao {

	public teacher selectTea(String name, String pwd) {
		String sql="SELECT * FROM teacher WHERE name=? AND pwd=md5(?)";
		super.executeQuery(sql,name,pwd);
		teacher t=new teacher();
		try {
			while(rs.next()){
				t.setAccount(rs.getString("account"));
				t.setDis(rs.getInt("dis"));
				t.setMotto(rs.getString("motto"));
				t.setName(rs.getString("name"));
				t.setPhone(rs.getString("phone"));
				t.setPwd(rs.getString("pwd"));
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
	public List<teacher> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<teacher> getTeacherselect() {
		List<teacher> list=new ArrayList<teacher>();
		String sql="SELECT * FROM teacher";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				teacher ta=new teacher();
				ta.setAccount(rs.getString("account"));
				ta.setDis(rs.getInt("dis"));
				ta.setId(rs.getInt("id"));
				ta.setMotto(rs.getString("motto"));
				ta.setPhone(rs.getString("phone"));
				ta.setPwd(rs.getString("pwd"));
				ta.setName(rs.getString("name"));
				list.add(ta);
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
	public int getTeacherdelete(int id) {
		String sql="DELETE FROM teacher WHERE id=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int getTeacherinsert(teacher ta) {
		String sql="INSERT INTO teacher ( NAME, account, pwd, phone, motto,dis) VALUES(?,?,md5(?),?,?,?)";
		return super.executeUpdate(sql, ta.getName(),ta.getAccount(),ta.getPwd(),ta.getPhone(),ta.getMotto(),0);
	}
	@Override
	public int getTeacherupdate(teacher ta) {
		 String sql="UPDATE teacher SET name=?, phone = ?, motto = ?, dis =?  WHERE id = ? ";
          return super.executeUpdate(sql,ta.getName(),ta.getPhone(),ta.getMotto(),ta.getDis(),ta.getId());
	}

	@Override
	public teacher getTeacher(int id) {
		teacher ta=null;
		String sql="SELECT * FROM teacher where id=?";
		super.executeQuery(sql,id);
		try {
			while(rs.next()){
				 ta=new teacher();
				ta.setAccount(rs.getString("account"));
				ta.setDis(rs.getInt("dis"));
				ta.setName(rs.getString("name"));
				ta.setId(rs.getInt("id"));
				ta.setMotto(rs.getString("motto"));
				ta.setPhone(rs.getString("phone"));
				ta.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return ta;
	}

	@Override
	public List getPageList(Page p,String name) {
		List list=new ArrayList();
		String sql="SELECT * FROM teacher WHERE  1=1  ";
		if (!name.equals("")) {
			sql+=" and NAME LIKE '%"+name+"%' ";
		}
		sql+=" GROUP BY id DESC  limit ?,? ";
		super.executeQuery(sql,(p.getPageIndex()-1)*p.getPageSize(),p.getPageSize());
		try {
			while(rs.next()){
				teacher ta=new teacher();
				ta.setAccount(rs.getString("account"));
				ta.setDis(rs.getInt("dis"));
				ta.setId(rs.getInt("id"));
				ta.setMotto(rs.getString("motto"));
				ta.setPhone(rs.getString("phone"));
				ta.setPwd(rs.getString("pwd"));
				ta.setName(rs.getString("name"));
				list.add(ta);
			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public int count(String name) {
		int count=0;
		String sql="SELECT count(*) FROM teacher WHERE  1=1  ";
		if (!name.equals("")) {
			sql+=" and NAME LIKE '%"+name+"%' ";
		}
		super.executeQuery(sql);
		try {
			while(rs.next()){
				 count= rs.getInt(1);
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
	}
		return count;
	}

	@Override
	public int setea(String name) {
		int id=0;
		String sql="SELECT id FROM teacher WHERE name=?";
		super.executeQuery(sql,name);
		try {
			while (rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return id;
	}

}

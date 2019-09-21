package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.memberDao;
import entity.interview;
import entity.member;
import entity.pag;
import entity.teacher;

public class memberDaoImpl extends BaseDao implements memberDao {

	@Override
	public int add(member m) {
		String sql="INSERT INTO member(NAME,classid,course,motto,phone,tag)VALUES(?,?,?,?,?,?)";
		return super.executeUpdate(sql, m.getName(),m.getClassid(),m.getCourse(),m.getMotto(),m.getPhone(),0);
	}

	@Override
	public int delete(int id) {
		String sql="delete from  member where id=?";
		return super.executeUpdate(sql,id);
	}

	@Override
	public int update(member m) {
		String sql="update member set NAME=?,classid=?,course=?,motto=?,phone=?,tag=?  where id=?";
		return super.executeUpdate(sql, m.getName(),m.getClassid(),m.getCourse(),m.getMotto(),m.getPhone(),m.getTag(), m.getId());
	}

	@Override
	public member getMember(int id) {
		member m=null;
		String sql="SELECT * FROM member where id=?";
		super.executeQuery(sql,id);
		try {
			while(rs.next()){
				 m=new member();
				 m.setC(new class1DaoImpl().getByClassId(rs.getInt("classid")));
				 m.setClassid(rs.getInt("classid"));
				 m.setPhone(rs.getString("phone"));
				 m.setCourse(rs.getInt("course"));
				 m.setId(rs.getInt("id"));
				 m.setTag(rs.getInt("tag"));
				 m.setMotto(rs.getString("motto"));
				 m.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return m;
	}

	@Override
	public List<member> query(pag p, String name, int cid) {
		List<member> list=new ArrayList<member>();
		String sql="SELECT * FROM member WHERE  1=1  ";
		if (!name.equals("")) {
			sql+=" and NAME LIKE '%"+name+"%' ";
		}
		if(cid != -1){
			sql += "     and classid = "+cid;
		}
		sql+=" GROUP BY id DESC  limit ?,? ";
		super.executeQuery(sql,(p.getIndex()-1)*p.getCount(),p.getCount());
		try {
			while(rs.next()){
				member m=new member();
				 m.setC(new class1DaoImpl().getByClassId(rs.getInt("classid")));
				 m.setClassid(rs.getInt("classid"));
				 m.setCourse(rs.getInt("course"));
				 m.setId(rs.getInt("id"));
				 m.setTag(rs.getInt("tag"));
				 m.setPhone(rs.getString("phone"));
				 m.setMotto(rs.getString("motto"));
				 m.setName(rs.getString("name"));
				list.add(m);
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
	public int count(String name, int cid) {
		int count=0;
		String sql="SELECT * FROM member WHERE  1=1  ";
		if (!name.equals("")) {
			sql+=" and NAME LIKE '%"+name+"%' ";
		}
		if(cid != -1){
			sql += "     and classid = "+cid;
		}
		super.executeQuery(sql);
		try {
			while(rs.next()){
				member m=new member();
				 m.setC(new class1DaoImpl().getByClassId(rs.getInt("classid")));
				 m.setClassid(rs.getInt("classid"));
				 m.setCourse(rs.getInt("course"));
				 m.setId(rs.getInt("id"));
				 m.setTag(rs.getInt("tag"));
				 m.setPhone(rs.getString("phone"));
				 m.setMotto(rs.getString("motto"));
				 m.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return count;
	}

	@Override
	public List<member> list() {
		List<member> list=new ArrayList<member>();
		String sql="SELECT * FROM member ";
		 
		super.executeQuery(sql);
		try {
			while(rs.next()){
				member m=new member();
				 m.setC(new class1DaoImpl().getByClassId(rs.getInt("classid")));
				 m.setClassid(rs.getInt("classid"));
				 m.setCourse(rs.getInt("course"));
				 m.setId(rs.getInt("id"));
				 m.setTag(rs.getInt("tag"));
				 m.setPhone(rs.getString("phone"));
				 m.setMotto(rs.getString("motto"));
				 m.setName(rs.getString("name"));
				list.add(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public member selectMem(String name) {
		member m=null;
		String sql="SELECT * FROM member where name=?";
		super.executeQuery(sql,name);
		try {
			while(rs.next()){
				 m=new member();
				 m.setC(new class1DaoImpl().getByClassId(rs.getInt("classid")));
				 m.setClassid(rs.getInt("classid"));
				 m.setPhone(rs.getString("phone"));
				 m.setCourse(rs.getInt("course"));
				 m.setId(rs.getInt("id"));
				 m.setTag(rs.getInt("tag"));
				 m.setMotto(rs.getString("motto"));
				 m.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return m;
	}

}

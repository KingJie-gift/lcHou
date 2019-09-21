package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.Member1Dao;
import entity.Member1;

public class Member1DaoImpl extends BaseDao implements Member1Dao {

	@Override
	public Member1 getMember(int id) {
		Member1 m=null;
		String sql="SELECT * FROM member WHERE id=?";
		super.executeQuery(sql, id);
		try {
			while (rs.next()) {
				m=new Member1();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("NAME"));
				m.setClassid(rs.getInt("classid"));
				m.setPhone(rs.getString("phone"));
				
				m.setCourse(rs.getInt("course"));
				m.setMotto(rs.getString("motto"));
				m.setTag(rs.getInt("tag"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return m;
	}

	@Override
	public List<Member1> getMember1sList() {
		List<Member1> list=new ArrayList<Member1>();
		String sql="SELECT * FROM member";
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				Member1 m=new Member1();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setClassid(rs.getInt("classid"));
				m.setCourse(rs.getInt("course"));
				m.setMotto(rs.getString("motto"));
				m.setPhone(rs.getString("phone"));
				m.setTag(rs.getInt("tag"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return list;
	}

	@Override
	public int selectid(String name) {
		int id=0;
		String sql="SELECT id FROM member WHERE NAME=?";
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

	@Override
	public List<Member1> getbyName(int id) {
		List<Member1> list=new ArrayList<Member1>();
		String sql="SELECT * FROM member WHERE course=?";
		super.executeQuery(sql,id);
		try {
			while (rs.next()) {
				Member1 m=new Member1();
				m.setClassid(rs.getInt("classid"));
				m.setCourse(rs.getInt("course"));
				m.setId(rs.getInt("id"));
				m.setPhone(rs.getString("phone"));
				m.setMotto(rs.getString("motto"));
				m.setName(rs.getString("name"));
				m.setTag(rs.getInt("tag"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return list;
	}

	
}

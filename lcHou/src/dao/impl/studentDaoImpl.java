package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.studentDao;
import entity.Page;
import entity.class1;
import entity.student;

public class studentDaoImpl extends BaseDao implements studentDao {

	@Override
	/*
	 * 根据cid找到某班级的全部同学
	 * (non-Javadoc)
	 * @see dao.studentDao#getList(int)
	 */
	
	public List<student> getList(int cid) {
		String sql=" SELECT * FROM student WHERE cid=?";
		super.executeQuery(sql, cid);
		List<student> list=new ArrayList<student>();
		try {
			while(rs.next()){
				student s=new student();
				class1DaoImpl cDao=new class1DaoImpl();
				class1 class1=cDao.getClass(rs.getInt("cid"));
				s.setStuid(rs.getInt("stuid"));
				s.setStuname(rs.getString("stuname"));
				s.setCid(rs.getInt("cid"));
				s.setClass1(class1);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return list;
	}

	@Override
	public student getStu(int id) {
		String sql=" SELECT * FROM student WHERE stuid=?";
		super.executeQuery(sql, id);
		student s=new student();
		try {
			while(rs.next()){
				class1DaoImpl cDao=new class1DaoImpl();
				class1 class1=cDao.getClass(rs.getInt("cid"));
				s.setStuid(rs.getInt("stuid"));
				s.setStuname(rs.getString("stuname"));
				s.setCid(rs.getInt("cid"));
				s.setClass1(class1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return s;
	}

	
	
	//基础
	
	public List<student> getStudentSelect() {
		List<student> list=new ArrayList<student>();
		String sql="SELECT  * FROM student";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				student sd=new student();
				sd.setCid(rs.getInt("cid"));
				sd.setStuid(rs.getInt("stuid"));
				sd.setStuname(rs.getString("stuname"));
				
				class1DaoImpl cdi=new class1DaoImpl();
				class1 ca=cdi.getByClassId(rs.getInt("cid"));
				sd.setClass1(ca);
				list.add(sd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public int getStudentdelete(int id) {
		String sql="DELETE FROM student WHERE stuid=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int getStudnetupdate(student st) {
		String sql="UPDATE student SET   stuname = ? , cid = ? WHERE stuid =? ;";
		return super.executeUpdate(sql, st.getStuname(),st.getCid(),st.getStuid());
	}

	@Override
	public student getStudentId(int id) {
		student sd=null;
		String sql="SELECT  * FROM student;";
		super.executeQuery(sql);
		try {
			while(rs.next()){
			     sd=new student();
				sd.setCid(rs.getInt("cid"));
				sd.setStuid(rs.getInt("stuid"));
				sd.setStuname(rs.getString("stuname"));
				class1DaoImpl cdi=new class1DaoImpl();
				class1 ca=cdi.getByClassId(rs.getInt("cid"));
				sd.setClass1(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return sd;
	}

	@Override
	public int getStudentinsert(student st) {
		String sql="INSERT INTO student (stuname, cid) VALUES ( ?, ?)";
		return super.executeUpdate(sql, st.getStuname(),st.getCid());
	}

	@Override
	public List getPageList(Page p,String name,int id) {
		List list=new ArrayList();
		String sql="SELECT  * FROM student  where 1=1";
		if(name != ""){
			sql += "     and stuname like '%"+name+"%'";
		}
		if(id != -1){
			sql += "     and cid = "+id;
		}
		sql += "   ORDER BY stuid desc limit ?,?";
		super.executeQuery(sql,(p.getPageIndex()-1)*p.getPageSize(),p.getPageSize());
		try {
			while(rs.next()){
				student sd=new student();
				sd.setCid(rs.getInt("cid"));
				sd.setStuid(rs.getInt("stuid"));
				sd.setStuname(rs.getString("stuname"));
				class1DaoImpl cdi=new class1DaoImpl();
				class1 ca=cdi.getByClassId(rs.getInt("cid"));
				sd.setClass1(ca);
				list.add(sd);
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
	public int count(String name,int id) {
		int count=0;
		String sql = "select count(*) from student where 1=1";
		if(name != ""){
			sql += " and stuname like '%"+name+"%'";
		}
		if(id != -1){
			sql += "  and cid = "+id;
		}
		super.executeQuery(sql);
		try {
			while(rs.next()){
			count=rs.getInt(1);
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return count;
	}

	@Override
	public student selectStu(String account, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<student> getsName(int id) {
		List<student> list=new ArrayList<student>();
		String sql="SELECT * FROM student WHERE  cid=?";
		super.executeQuery(sql, id);
		try {
			while(rs.next()){
				student sd=new student();
				sd.setCid(rs.getInt("cid"));
				sd.setStuid(rs.getInt("stuid"));
				sd.setStuname(rs.getString("stuname"));
				
				class1DaoImpl cdi=new class1DaoImpl();
				class1 ca=cdi.getByClassId(rs.getInt("cid"));
				sd.setClass1(ca);
				list.add(sd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}
}

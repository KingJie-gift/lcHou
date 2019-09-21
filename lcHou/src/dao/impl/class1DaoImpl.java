package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.class1Dao;
import entity.Ctype;
import entity.Page;
import entity.class1;
import entity.coach;
import entity.pag;
import entity.teacher;

public class class1DaoImpl extends BaseDao implements class1Dao {

	public List<class1> getList() {
		String sql = "SELECT * FROM class ";
		super.executeQuery(sql);
		List<class1> list = new ArrayList<class1>();
		try {
			while (rs.next()) {
				class1 c = new class1();
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCoachid(rs.getInt("coachid"));
				c.setCount(rs.getInt("count"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setTypeid(rs.getInt("typeid"));
				//c.setImg(rs.getString("img"));
				list.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	public class1 getClass(int id) {
		String sql = "SELECT * FROM class WHERE classid=?";
		super.executeQuery(sql,id);
		class1 c = new class1();
		try {
			while (rs.next()) {
			
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCoachid(rs.getInt("coachid"));
				c.setCount(rs.getInt("count"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setTypeid(rs.getInt("typeid"));
				//c.setImg(rs.getString("img"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return c;
	}

	@Override
	public List<class1> getbyTea(int teaid) {
		String sql = "SELECT * FROM class WHERE teaid=?";
		super.executeQuery(sql,teaid);
		List<class1> list = new ArrayList<class1>();
		try {
			while (rs.next()) {
				class1 c = new class1();
				c.setCtype(new CtypeDaoimpl().getCtypeID(rs.getInt("classid")));
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCoachid(rs.getInt("coachid"));
				c.setCount(rs.getInt("count"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setTypeid(rs.getInt("typeid"));
				 
				
				
				coachDaoImpl cDao=new coachDaoImpl();
				coach coach=cDao.getCoach(rs.getInt("coachid"));
				c.setCoach(coach);
				list.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	
	//°à¼¶»ù´¡²Ù×÷
	
	public List<class1> getClassSelect() {
		List<class1> list=new ArrayList<class1>();
		String sql="SELECT * FROM class";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				class1 cas=new class1();
				cas.setClassid(rs.getInt("classid"));
				cas.setClassname(rs.getString("classname"));
			    cas.setCount(rs.getInt("count"));
			    cas.setMotto(rs.getString("motto"));
			    cas.setCoachid(rs.getInt("coachid"));
			    cas.setTeaid(rs.getInt("teaid"));
			    cas.setTypeid(rs.getInt("typeid"));
			    coachDaoImpl  cdi=new coachDaoImpl();
			    coach cah=cdi.getCoachID(rs.getInt("coachid"));
			    cas.setCoach(cah);
			    
			    teacherDaoImpl tdi=new teacherDaoImpl();
			    teacher thr=tdi.getTeacher(rs.getInt("teaid"));
			    cas.setTea(thr);
			    
			    CtypeDaoimpl  cyi=new CtypeDaoimpl();
			    Ctype cpe=cyi.getCtypeID(rs.getInt("typeId"));
			    cas.setCtype(cpe);
			    
			    list.add(cas);
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
	public int getClassdelete(int id) {
		String sql="DELETE  FROM class WHERE classid=? ";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int getClassUpdate(class1 cs) {
		String sql="UPDATE class SET classname = ? , typeid = ? , COUNT = ? , teaid = ? , coachid = ? , motto = ? WHERE classid = ?";
		return super.executeUpdate(sql, cs.getClassname(),cs.getTypeid(),cs.getCount(),cs.getTeaid(),cs.getCoachid(),cs.getMotto(),cs.getClassid());
	}

	@Override
	public class1 getByClassId(int id) {
		class1 cas=null;
		String sql="SELECT * FROM class where classid=?";
		super.executeQuery(sql,id);
		try {
			while(rs.next()){
				 cas=new class1();
				cas.setClassid(rs.getInt("classid"));
				cas.setClassname(rs.getString("classname"));
			    cas.setCount(rs.getInt("count"));
			    cas.setMotto(rs.getString("motto"));
			    cas.setCoachid(rs.getInt("coachid"));
			    cas.setTeaid(rs.getInt("teaid"));
			    cas.setTypeid(rs.getInt("typeid"));
			    
			    coachDaoImpl  cdi=new coachDaoImpl();
			    coach cah=cdi.getCoachID(rs.getInt("coachid"));
			    cas.setCoach(cah);
			    
			    teacherDaoImpl tdi=new teacherDaoImpl();
			    teacher thr=tdi.getTeacher(rs.getInt("teaid"));
			    cas.setTea(thr);
			    
			    CtypeDaoimpl  cyi=new CtypeDaoimpl();
			    Ctype cpe=cyi.getCtypeID(rs.getInt("typeId"));
			    cas.setCtype(cpe);
			    
			  
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
	}
		return cas;
	}

	@Override
	public int getClassinsert(class1 cs) {
		String sql="INSERT INTO class ( classname, typeid, COUNT, teaid, coachid, motto)VALUES( ?, ?, ?, ?, ?, ?)";
		return super.executeUpdate(sql, cs.getClassname(),cs.getTypeid(),cs.getCount(),cs.getTeaid(),cs.getCoachid(),cs.getMotto());
	}

	@Override
	public List getFen(pag p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPageList(Page p) {
		List list=new ArrayList();
		String sql="SELECT * FROM class  GROUP BY classid DESC limit ?,?";
		super.executeQuery(sql,(p.getPageIndex()-1)*p.getPageSize(),p.getPageSize());
		try {
			while(rs.next()){
				class1 cas=new class1();
				cas.setClassid(rs.getInt("classid"));
				cas.setClassname(rs.getString("classname"));
			    cas.setCount(rs.getInt("count"));
			    cas.setMotto(rs.getString("motto"));
			    cas.setCoachid(rs.getInt("coachid"));
			    cas.setTeaid(rs.getInt("teaid"));
			    cas.setTypeid(rs.getInt("typeId"));
			    
			    coachDaoImpl  cdi=new coachDaoImpl();
			    coach cah=cdi.getCoachID(rs.getInt("coachid"));
			    cas.setCoach(cah);
			    
			    teacherDaoImpl tdi=new teacherDaoImpl();
			    teacher thr=tdi.getTeacher(rs.getInt("teaid"));
			    cas.setTea(thr);
			    
			    CtypeDaoimpl  cyi=new CtypeDaoimpl();
			    Ctype cpe=cyi.getCtypeID(rs.getInt("typeId"));
			    cas.setCtype(cpe);
			    
			    list.add(cas);
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
	public int count() {
		int count=0;
		String sql="SELECT count(*) FROM class ";
		super.executeQuery(sql);
		try {
			while(rs.next()){
				count=rs.getInt(1);
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
	public class1 getclass(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<class1> getclassList(int id) {
		List<class1> list=new ArrayList<class1>();
		String sql="SELECT * FROM class where 1=1";
		if (id!=0) {
			sql+=" and  teaid="+id;
		}
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				class1 c=new class1();
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCount(rs.getInt("COUNT"));
				c.setTypeid(rs.getInt("typeid"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setCoachid(rs.getInt("coachid"));
				list.add(c);
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
	public class1 getById(int id) {
		class1 c=null;
		String sql="SELECT * FROM class where classid=?";
		super.executeQuery(sql,id);
		try {
			while (rs.next()) {
				c=new class1();
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCount(rs.getInt("COUNT"));
				c.setTypeid(rs.getInt("typeid"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setCoachid(rs.getInt("coachid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return c;
	}

	@Override
	public List<class1> getClassname(int id) {
		List<class1> list=new ArrayList<class1>();
		String sql="SELECT * FROM class where classid=?";
		super.executeQuery(sql, id);
		try {
			while (rs.next()) {
			    class1	c=new class1();
				c.setClassid(rs.getInt("classid"));
				c.setClassname(rs.getString("classname"));
				c.setCount(rs.getInt("COUNT"));
				c.setTypeid(rs.getInt("typeid"));
				c.setMotto(rs.getString("motto"));
				c.setTeaid(rs.getInt("teaid"));
				c.setCoachid(rs.getInt("coachid"));
				list.add(c);
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

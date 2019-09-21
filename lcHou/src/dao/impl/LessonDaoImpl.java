package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.mail.handlers.message_rfc822;

import dao.BaseDao;
import dao.LessonDao;
import entity.Member1;
import entity.class1;
import entity.lesson;

public class LessonDaoImpl extends BaseDao implements LessonDao {

	@Override
	public int insert(lesson l) {
		String sql="INSERT lesson (classid,WEEK,NONE,lesson,memberid,ltime,talkTime) VALUES (?,?,?,?,?,?,date(now()))";
		return super.executeUpdate(sql, l.getClassid(),l.getWeek(),l.getNone(),l.getLesson(),l.getMemberid(),l.getTalkTime());
	}

	@Override
	public List<lesson> getlessList() {
		List<lesson> list=new ArrayList<lesson>();
		String sql="SELECT * FROM lesson";
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				lesson l=new lesson();
				l.setId(rs.getInt("id"));
				l.setClassid(rs.getInt("classid"));
				l.setWeek(rs.getString("week"));
				l.setNone(rs.getInt("none"));
				l.setLesson(rs.getString("lesson"));
				l.setTalkTime(rs.getString("talkTime"));
				l.setMemberid(rs.getInt("memberid"));
				l.setLtime(rs.getString("ltime"));
				class1DaoImpl c=new class1DaoImpl();
				class1 cl=c.getClass(rs.getInt("classid"));
				Member1DaoImpl m=new Member1DaoImpl();
				Member1 me=m.getMember(rs.getInt("memberid"));
				l.setMember(me);
				l.setClass1(cl);
				list.add(l);
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
	public int checklesson(int classid, int none, String week) {
		int count=0;
		String sql="SELECT COUNT(*) FROM lesson WHERE  classid =? AND NONE =? AND WEEK=?";
		super.executeQuery(sql,classid,none,week);
		try {
			while (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return count;
	}

	@Override
	public List<lesson> getById(int id) {
		List<lesson> list=new ArrayList<lesson>();
	String sql="SELECT * FROM lesson WHERE id=?";
	super.executeQuery(sql,id);
	try {
		while (rs.next()) {
			lesson l=new lesson();
			l.setId(rs.getInt("id"));
			l.setClassid(rs.getInt("classid"));
			l.setWeek(rs.getString("week"));
			l.setNone(rs.getInt("none"));
			l.setLesson(rs.getString("lesson"));
			l.setMemberid(rs.getInt("memberid"));
			l.setTalkTime(rs.getString("talkTime"));
			l.setLtime(rs.getString("ltime"));
			class1DaoImpl c=new class1DaoImpl();
			class1 cl=c.getClass(rs.getInt("classid"));
			Member1DaoImpl m=new Member1DaoImpl();
			Member1 me=m.getMember(rs.getInt("memberid"));
			l.setMember(me);
			l.setClass1(cl);
			list.add(l);
			
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
	public List<lesson> getbyName(int id) {
		List<lesson> list=new ArrayList<lesson>();
		String sql="SELECT *  FROM lesson WHERE DATE(talkTime)<=DATE_SUB(DATE(NOW()),INTERVAL -1 DAY) AND DATE(talkTime)>=DATE(NOW())";
		sql+="  AND memberid=?";
		super.executeQuery(sql,id);
		try {
			while (rs.next()) {
				lesson l=new lesson();
				l.setId(rs.getInt("id"));
				l.setClassid(rs.getInt("classid"));
				l.setWeek(rs.getString("week"));
				l.setNone(rs.getInt("none"));
				l.setLesson(rs.getString("lesson"));
				l.setMemberid(rs.getInt("memberid"));
				l.setTalkTime(rs.getString("talkTime"));
				l.setLtime(rs.getString("ltime"));
				class1DaoImpl c=new class1DaoImpl();
				class1 cl=c.getClass(rs.getInt("classid"));
				Member1DaoImpl m=new Member1DaoImpl();
				Member1 me=m.getMember(rs.getInt("memberid"));
				l.setMember(me);
				l.setClass1(cl);
				list.add(l);
				
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

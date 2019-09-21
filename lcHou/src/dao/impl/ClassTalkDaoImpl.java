package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ClassTalkDao;
import entity.ClassTalk;
import entity.Member1;
import entity.Page1;
import entity.class1;

public class ClassTalkDaoImpl extends BaseDao implements ClassTalkDao {

	@Override
	public int insert(ClassTalk ct) {
		String sql = "INSERT classtalk (sname,cid,TIME,taifeng,smooth,active,content,SUM,evaluate,talktime,memberid)VALUES (?,?,?,?,?,?,?,?,?,NOw(),?)";
		return super.executeUpdate(sql, ct.getSname(), ct.getCid(),
				ct.getTime(), ct.getTaifeng(), ct.getSmooth(), ct.getActive(),
				ct.getContent(),ct.getSum(),ct.getEvaluate(),
				ct.getMemberid());
	}

	@Override
	public List<ClassTalk> select(int id) {
		List<ClassTalk> list = new ArrayList<ClassTalk>();
		String sql = "SELECT * FROM classtalk WHERE cid=?";		
		super.executeQuery(sql,id);
		try {
			while (rs.next()) {
				ClassTalk ct=new ClassTalk();
				ct.setId(rs.getInt("id"));
				ct.setSname(rs.getString("sname"));
				ct.setCid(rs.getInt("cid"));
				ct.setTime(rs.getShort("TIME"));
				ct.setTaifeng(rs.getInt("taifeng"));
				ct.setSmooth(rs.getInt("smooth"));
				ct.setActive(rs.getInt("active"));
				ct.setContent((rs.getInt("content")));
				ct.setSum(rs.getInt("sum"));
				ct.setEvaluate(rs.getString("evaluate"));
				ct.setTalktime(rs.getString("talktime"));
				ct.setMemberid(rs.getInt("memberid"));
				Member1DaoImpl md=new Member1DaoImpl();
				Member1 m=md.getMember(rs.getInt("memberid"));
				
				class1DaoImpl ad=new class1DaoImpl();
				class1 c=ad.getclass(rs.getInt("cid"));
				ct.setMember1(m);
				ct.setClass1(c);
				list.add(ct);
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
	public List<ClassTalk> getByName(String name) {
		List<ClassTalk> list = new ArrayList<ClassTalk>();
		String sql = "SELECT * FROM classtalk WHERE sname=?";
		sql+=" ORDER BY talktime desc";
		super.executeQuery(sql,name);
		try {
			while (rs.next()) {
				ClassTalk ct=new ClassTalk();
				ct.setId(rs.getInt("id"));
				ct.setSname(rs.getString("sname"));
				ct.setCid(rs.getInt("cid"));
				ct.setTime(rs.getShort("TIME"));
				ct.setTaifeng(rs.getInt("taifeng"));
				ct.setSmooth(rs.getInt("smooth"));
				ct.setActive(rs.getInt("active"));
				ct.setContent(rs.getInt("content"));
				ct.setSum(rs.getInt("sum"));
				ct.setEvaluate(rs.getString("evaluate"));
				ct.setTalktime(rs.getString("talktime"));
				ct.setMemberid(rs.getInt("memberid"));
				Member1DaoImpl md=new Member1DaoImpl();
				Member1 m=md.getMember(rs.getInt("memberid"));
				
				class1DaoImpl ad=new class1DaoImpl();
				class1 c=ad.getclass(rs.getInt("cid"));
				ct.setMember1(m);
				ct.setClass1(c);
				list.add(ct);
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
	public List<ClassTalk> weekById(Page1 p,int count,int id) {
		List<ClassTalk> list = new ArrayList<ClassTalk>();
		String sql = "SELECT * FROM classtalk WHERE 1=1";
		if(count!=-1&&count==1){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(talktime)";
		}else if(count!=-1&&count==2){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 14 DAY)<=DATE(talktime)";
		}else if(count!=-1&&count==3){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 1 MONTH)<=DATE(talktime)";
		}
		sql+=" and cid="+id;
		sql += "  ORDER BY talktime desc  limit ?,?";
		super.executeQuery(sql,(p.getPageIndex()-1)*p.getPageSize(),p.getPageSize());
		try {
			while (rs.next()) {
				ClassTalk ct=new ClassTalk();
				ct.setId(rs.getInt("id"));
				ct.setSname(rs.getString("sname"));
				ct.setCid(rs.getInt("cid"));
				ct.setTime(rs.getShort("TIME"));
				ct.setTaifeng(rs.getInt("taifeng"));
				ct.setSmooth(rs.getInt("smooth"));
				ct.setActive(rs.getInt("active"));
				ct.setContent(rs.getInt("content"));
				ct.setSum(rs.getInt("sum"));
				ct.setEvaluate(rs.getString("evaluate"));
				ct.setTalktime(rs.getString("talktime"));
				ct.setMemberid(rs.getInt("memberid"));
				Member1DaoImpl md=new Member1DaoImpl();
				Member1 m=md.getMember(rs.getInt("memberid"));
				
				class1DaoImpl ad=new class1DaoImpl();
				class1 c=ad.getclass(rs.getInt("cid"));
				ct.setMember1(m);
				ct.setClass1(c);
				list.add(ct);
			}
			p.setList(list);
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
	public int getAllCount(int count,int id) {
		int num=0;
		String sql = "SELECT count(*) FROM classtalk WHERE 1=1";
		if(count!=-1&&count==1){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(talktime)";
		}else if(count!=-1&&count==2){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 14 DAY)<=DATE(talktime)";
		}else if(count!=-1&&count==3){
			sql+=" and DATE_SUB(CURDATE(),INTERVAL 1 MONTH)<=DATE(talktime)";
		}
		sql+=" and cid="+id;
		super.executeQuery(sql);
		try {
			while (rs.next()) {
			num=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return num;
	}

	@Override
	public int checkTalk(String name) {
		int count=0;
		String sql = "SELECT COUNT(*) FROM classtalk WHERE DATE(talktime)=DATE(NOW())";
		sql+=" and sname=?";
		super.executeQuery(sql,name);
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
	public int update(ClassTalk ct) {
		String sql="UPDATE classtalk SET TIME=?,taifeng=?,smooth=?,active=?,content=?,SUM=?,evaluate=? WHERE sname=? AND DATE(talktime)=DATE(NOW())";
		return super.executeUpdate(sql, ct.getTime(),ct.getTaifeng(),ct.getSmooth(),ct.getActive(),ct.getContent(),ct.getSum(),ct.getEvaluate(),ct.getSname());
	}

	@Override
	public List<ClassTalk> jree(String name) {
		List<ClassTalk> list=new ArrayList<ClassTalk>();
		String sql="SELECT * FROM classtalk WHERE sname=?";
		sql+=" and DATE_SUB(CURDATE(),INTERVAL  1 MONTH)<=DATE(talktime) GROUP BY talktime";
		super.executeQuery(sql,name);
		try {
			while (rs.next()) {
				ClassTalk ct=new ClassTalk();
				ct.setId(rs.getInt("id"));
				ct.setSname(rs.getString("sname"));
				ct.setCid(rs.getInt("cid"));
				ct.setTime(rs.getShort("TIME"));
				ct.setTaifeng(rs.getInt("taifeng"));
				ct.setSmooth(rs.getInt("smooth"));
				ct.setActive(rs.getInt("active"));
				ct.setContent(rs.getInt("content"));
				ct.setSum(rs.getInt("sum"));
				ct.setEvaluate(rs.getString("evaluate"));
				ct.setTalktime(rs.getString("talktime"));
				ct.setMemberid(rs.getInt("memberid"));
				Member1DaoImpl md=new Member1DaoImpl();
				Member1 m=md.getMember(rs.getInt("memberid"));
				
				class1DaoImpl ad=new class1DaoImpl();
				class1 c=ad.getclass(rs.getInt("cid"));
				ct.setMember1(m);
				ct.setClass1(c);
				list.add(ct);
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

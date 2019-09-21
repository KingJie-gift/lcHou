package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.interviewDao;
import entity.class1;
import entity.interview;
import entity.member;
import entity.pag;
import entity.student;

public class interviewDaoImpl extends BaseDao implements interviewDao {

	@Override
	public int add(interview inter) {
		String sql = "INSERT INTO interview (stuid, cid, jieshao, problem, SUM, evalute,DATE,time,mem)VALUES(?, ?, ?, ?, ?,?,NOW(),?,?)";
		return super.executeUpdate(sql, inter.getStuid(), inter.getCid(),
				inter.getJieshao(), inter.getProblem(), inter.getSum(),
				inter.getEvalute(), inter.getTime(), inter.getMem());
	}

	@Override
	/*
	 * 所有信息
	 */
	public List<interview> query(int cid,int stuid,String time) {
		String sql = "SELECT * FROM interview where 1=1 ";
		if (time.equals("")) {
			sql+="  and DATE_SUB(CURDATE(),INTERVAL 7 DAY)<=DATE(DATE)";
			if (cid != 0) {
				sql += "  and cid=" + cid;
			}
			if (stuid!=-1) {
				sql+="  AND stuid="+stuid;
			}
		}else{
			sql+="  AND DATE(DATE)='"+time+"'";
			if (cid != 0) {
				sql += "  and cid=" + cid;
			}
			if (stuid!=-1) {
				sql+="  AND stuid="+stuid;
			}
			
		}
		super.executeQuery(sql);
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setTime(rs.getInt("time"));
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public List<interview> selectStu(pag p, int id) {
		String sql = "SELECT * FROM interview WHERE 1=1";
		if (id > 0) {
			sql += " and cid=" + id;
		}
		sql += " GROUP BY (DATE) DESC  limit ?,?";
		super.executeQuery(sql, (p.getIndex() - 1) * p.getCount(), p.getCount());
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setTime(rs.getInt("time"));
				i.setStu(stu);
		
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);

			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	// 上个星期
	public List<interview> lastWeek(pag p, int id) {
		String sql = "SELECT * FROM interview WHERE 1=1   ";

		if (id != -1) {
			sql += " and cid=" + id;
		}
		sql += "  AND YEARWEEK(DATE_FORMAT(DATE,'%Y-%m-%d'))=YEARWEEK(NOW())-1  GROUP BY (DATE) DESC";
		sql += "  limit ?,?";
		super.executeQuery(sql, (p.getIndex() - 1) * p.getCount(), p.getCount());
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setTime(rs.getInt("time"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public int getAllount(int cid,int stuid,String time) {
		String sql = "SELECT count(*) FROM interview where 1=1 ";
		if (time.equals("")) {
			sql+="  and DATE_SUB(CURDATE(),INTERVAL  DAY)<=DATE(DATE)";
			
		}else{
			sql+="  AND DATE(DATE)='"+time+"'";
			if (cid != 0) {
				sql += "  and cid=" + cid;
			}
			if (stuid!=-1) {
				sql+="  AND stuid="+stuid;
			}
			
		}
		 
		int count = 0;
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getlastAllount(int id) {
		String sql = "SELECT count(*) FROM interview WHERE 1=1   ";
		if (id > 0) {
			sql += " and cid=" + id;
		}
		sql += "   AND YEARWEEK(DATE_FORMAT(DATE,'%Y-%m-%d'))=YEARWEEK(NOW())-1 ";
		int count = 0;
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	// 近半个月
	public List<interview> month(pag p, int id) {
		String sql = "SELECT * FROM interview WHERE 1=1   ";

		if (id != -1) {
			sql += " and cid=" + id;
		}
		sql += "   and YEARWEEK(DATE_FORMAT(DATE,'%Y-%m-%d'))=YEARWEEK(NOW())  GROUP BY (DATE) DESC";
		sql += "  limit ?,?";
		super.executeQuery(sql, (p.getIndex() - 1) * p.getCount(), p.getCount());
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setTime(rs.getInt("time"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public int month(int id) {
		String sql = "SELECT count(*) FROM interview WHERE 1=1   ";
		if (id > 0) {
			sql += " and cid=" + id;
		}
		sql += "  and YEARWEEK(DATE_FORMAT(DATE,'%Y-%m-%d'))=YEARWEEK(NOW())";
		int count = 0;
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	// 报表信息（近一个月的趋势）
	public List<interview> getChart(int id) {
		String sql = "SELECT * FROM interview WHERE 1=1   ";

		if (id != -1) {
			sql += " and stuid=" + id;
		}
		sql += "   and DATE_SUB(CURDATE(),INTERVAL 30 DAY)<DATE(DATE) GROUP BY DATE ";
		super.executeQuery(sql);
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setTime(rs.getInt("time"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public List<interview> selectNow(pag p, int mem) {
		String sql = "SELECT * FROM interview WHERE DATE(DATE)=DATE(NOW())";
		if (mem != -1) {
			sql += "  and mem=" + mem;

		}
		sql+="   ORDER BY id DESC   limit ?,?";
		super.executeQuery(sql, (p.getIndex() - 1) * p.getCount(), p.getCount());
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setTime(rs.getInt("time"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public int selectNow(int mem) {
		String sql = "SELECT COUNT(*) FROM interview WHERE   DATE(DATE)=DATE(NOW())";
		if (mem != -1) {
			sql += "  and mem=" + mem;

		}
		super.executeQuery(sql);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;
	}

	@Override
	public List<interview> queryOne(pag p, int cid, int stuid, String time) {
		String sql = "  SELECT * FROM interview WHERE 1=1 ";
		if (cid != 0) {
			sql += "  and cid=" + cid;
		}
		if (stuid!=-1) {
			sql+="  AND stuid="+stuid;
		}
		if (!time.equals("") || time!=null) {
			sql+="  AND DATE(DATE)='"+time+"'";
		}
		sql += " GROUP BY (DATE) DESC limit ?,?";
		super.executeQuery(sql, (p.getIndex() - 1) * p.getCount(), p.getCount());
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setTime(rs.getInt("time"));
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
			p.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public int queryOne(int cid, int stuid, String time) {
		String sql = "SELECT count(*) FROM interview WHERE 1=1   ";
		if (cid > 0) {
			sql += " and cid=" + cid;
		}
		if (stuid!=-1) {
			sql+="  AND stuid="+stuid;
		}
		if (!time.equals("")) {
			sql+="  AND DATE(DATE)='"+time+"'";
		}
		int count = 0;
		super.executeQuery(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return count;
	}

	@Override
	public List<interview> queryPeo(int stuid,String time) {
		String sql=" select * from interview WHERE 1=1 ";
		if (stuid!=-1) {
			sql+="  and stuid="+stuid;
		}
		if (!time.equals("")) {
			sql+="  AND DATE(DATE)='"+time+"'";
		}
		sql += "     GROUP BY (DATE) DESC";
		super.executeQuery(sql);
		List<interview> list = new ArrayList<interview>();
		try {
			while (rs.next()) {
				interview i = new interview();
				class1DaoImpl dao = new class1DaoImpl();
				class1 c = dao.getClass(rs.getInt("cid"));// 班级对象
				i.setCid(rs.getInt("cid"));
				i.setDate(rs.getString("date"));
				i.setEvalute(rs.getString("evalute"));
				i.setId(rs.getInt("id"));
				i.setJieshao(rs.getInt("jieshao"));// 自我介绍
				studentDaoImpl stuDao = new studentDaoImpl();
				student stu = stuDao.getStu(rs.getInt("stuid"));// 学员对象
				i.setStuid(rs.getInt("stuid"));
				i.setProblem(rs.getInt("problem"));// 人事问题
				i.setSum(rs.getInt("sum"));
				i.setStu(stu);
				i.setTime(rs.getInt("time"));
				i.setClass1(c);
				memberDaoImpl mDao = new memberDaoImpl();
				member m = mDao.getMember(rs.getInt("mem"));
				i.setMem(rs.getInt("mem"));
				i.setMember(m);
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public int update(interview inter) {
		String sql="UPDATE interview SET cid=?,stuid=?,jieshao=?,problem=?,TIME=?,evalute=? WHERE id=?";
		return super.executeUpdate(sql, inter.getCid(),inter.getStuid(),inter.getJieshao(),inter.getProblem(),inter.getTime(),inter.getEvalute(),inter.getId()
				);
	}

	@Override
	public int check(int id) {
		String sql="SELECT COUNT(*) FROM interview WHERE DATE(now()) AND stuid=? ";
		 
		super.executeQuery(sql,id);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;
	}
}

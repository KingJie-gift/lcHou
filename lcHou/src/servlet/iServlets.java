package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.LessonServiceImpl;
import service.impl.Member1serviceImpl;
import service.impl.adminServiceImpl;
import service.impl.class1ServiceImpl;
import service.impl.interviewServiceImpl;
import service.impl.memberServiceImpl;
import service.impl.studentServiceImpl;
import service.impl.teacherServiceImpl;

import com.alibaba.fastjson.JSON;

import entity.admin;
import entity.class1;
import entity.interview;
import entity.lesson;
import entity.member;
import entity.pag;
import entity.student;
import entity.teacher;

public class iServlets extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		interviewServiceImpl ser = new interviewServiceImpl();
		class1ServiceImpl cSer = new class1ServiceImpl();
		teacherServiceImpl tSer = new teacherServiceImpl();
		studentServiceImpl stuSer = new studentServiceImpl();
		adminServiceImpl loginSer = new adminServiceImpl();
		memberServiceImpl mSer = new memberServiceImpl();
		LessonServiceImpl ls=new LessonServiceImpl();
		Member1serviceImpl ms=new Member1serviceImpl();
		PrintWriter out = response.getWriter();
		teacher teacherAll = null;
		member memberAll = null;
		admin a = null;
		if (op == null || op.equals("interQuery")) {

		} else if (op.equals("to")) {
			List<member> mlist = mSer.list();
			request.setAttribute("mlist", mlist);
			List<class1> clist = cSer.getList();
			request.setAttribute("clist", clist);
			Integer mem = Integer.parseInt(request.getParameter("mem"));
			request.setAttribute("mem", mem);
			Integer index = Integer.parseInt(request.getParameter("index"));
			pag p = new pag();
			p.setCount(12);
			p.setTotalData(ser.selectNow(mem));
			p.setIndex(index);
			p.setList(ser.selectNow(p, mem));
			request.setAttribute("p", p);
			request.getRequestDispatcher("interInsert.jsp").forward(request,
					response);

		} else if (op.equals("add")) {
			Integer time = Integer.parseInt(request.getParameter("time"));
			Integer cid = Integer.parseInt(request.getParameter("cid"));
			Integer mem = Integer.parseInt(request.getParameter("mem"));
			Integer stuid = Integer.parseInt(request.getParameter("name"));
			Integer zi = Integer.parseInt(request.getParameter("zi"));
			Integer pro = Integer.parseInt(request.getParameter("pro"));
			String evalute = request.getParameter("evalute");
			evalute = new String(evalute.getBytes("iso-8859-1"), "utf-8");
			interview i = new interview();
			i.setCid(cid);
			i.setStuid(stuid);
			i.setTime(time);
			i.setEvalute(evalute);
			i.setJieshao(zi);
			i.setProblem(pro);
			i.setSum(zi + pro);
			i.setMem(mem);
			request.getSession().setAttribute("mem", mem);
			int re = ser.add(i);
			out.print("{\"re\":\"" + re + "\"}");
			// 老师登录
		} else if (op.equals("login")) {
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			teacher t = tSer.selectTea(name, pwd);
			if (t == null) {
				request.setAttribute("error", "亲，您的账号或密码错误");
				request.getRequestDispatcher("teacher-login.jsp").forward(
						request, response);
				return;
			} else {
				List<class1> list = cSer.getbyTea(t.getId());
				request.getSession().setAttribute("t", t);
				request.setAttribute("clist", list);
				request.getRequestDispatcher("login-success.jsp").forward(
						request, response);
			}
			// 获取指定班级的学员面试信息----->绑定学生下拉框
		} else if (op.equals("stuinfo")) {
			Integer cid = Integer.parseInt(request.getParameter("id"));
			List<student> stulist = stuSer.getList(cid);
			String json = JSON.toJSONString(stulist);
			out.print(json);
			// 指定班级的面试列表
		} else if (op.equals("info")) {
			//班级cid
			Integer cid = Integer.parseInt(request.getParameter("cid"));
			request.getSession().setAttribute("cid", cid);
			//学员列表
			List<student> stuList = stuSer.getList(cid);
			request.setAttribute("stuList", stuList);
			//学员id
			String name = request.getParameter("name");
			name = name == null ? "-1" : name;
			Integer stuid = Integer.parseInt(name);
			request.setAttribute("stuid", stuid);
			//查询时间
			String time = request.getParameter("times");
			time = time == null ? "" : time;
			request.setAttribute("time", time);
			List<interview> list=ser.query(cid, stuid, time);// 本班的学员面试信息
			request.setAttribute("list", list);
			request.getRequestDispatcher("interFen2.jsp").forward(request,
					response);
		} else if (op.equals("thisWeek")) {
			Integer id = Integer.parseInt(request.getParameter("id"));

			// class1 c = cSer.getClass(id);
			pag p = new pag();
			p.setCount(2);
			p.setTotalData(ser.month(id));
			p.setIndex(Integer.parseInt(request.getParameter("index")));
			ser.month(p, id);
			String json = JSON.toJSONString(p);
			out.print(json);

		}   else if (op.equals("check")) {
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			Integer type = Integer.parseInt(request.getParameter("type"));
			a = loginSer.login(name, pwd);
			if (a == null) {
				request.setAttribute("error", "亲，您的账号或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
				return;
			} else {

				// 部员0 教师1
				if (type == 1) {
					teacherAll = tSer.selectTea(name, pwd);
					request.getSession().setAttribute("a", a);
					request.getSession().setAttribute("teacherAll", teacherAll);
					request.getRequestDispatcher("main.jsp").forward(request,
							response);
					//return;
				} else if (type == 0) {
					memberAll = mSer.selectMem(name);
					int id=ms.selectid(a.getName());
					List<lesson> l=ls.getbyName(id);
					
				    request.setAttribute("less", l);
					request.getSession().setAttribute("a", a);
					request.getSession().setAttribute("memberAll", memberAll);
					request.getRequestDispatcher("main.jsp").forward(request,
							response);
					//return;
				}

			}
//教师查看
		} else if (op.equals("selectNow")) {
			Integer teaid = Integer.parseInt(request.getParameter("id"));
			List<class1> list = cSer.getbyTea(teaid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("interFen1.jsp").forward(request,
					response);

		} else if (op.equals("look")) {
			Integer cid = Integer.parseInt(request.getParameter("cid"));
			String name = request.getParameter("name");
			name = name == null ? "-1" : name;
			Integer stuid = Integer.parseInt(name);
			request.setAttribute("stuid", stuid);
			String time = request.getParameter("time");
			time = time == null ? "" : time;
			request.setAttribute("time", time);
			pag p = new pag();
			p.setCount(10);
			p.setTotalData(ser.queryOne(cid, stuid, time));
			p.setIndex(Integer.parseInt(request.getParameter("index")));

			ser.queryOne(p, cid, stuid, time);// 本班的学员面试信息
			request.setAttribute("p", p);

			 
			request.getRequestDispatcher("interFen2.jsp").forward(request,
					response);

		}else if (op.equals("people")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			student stu=stuSer.getStudentId(id);
			request.getSession().setAttribute("stu", stu);
			String time = request.getParameter("times");
			time = time == null ? "" : time;
			request.setAttribute("time", time);
			List<interview> list=ser.queryPeo(id,time);
			request.getSession().setAttribute("list", list);
			request.getRequestDispatcher("interFen3.jsp").forward(request,
					response);
		}else if (op.equals("toUpdate")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer cid = Integer.parseInt(request.getParameter("cid"));
			Integer stuid = Integer.parseInt(request.getParameter("stuid"));
			Integer time = Integer.parseInt(request.getParameter("time"));
			Integer zi = Integer.parseInt(request.getParameter("zi"));
			Integer pro = Integer.parseInt(request.getParameter("pro"));
			String evalute=request.getParameter("evalute");
			evalute=new String(evalute.getBytes("iso-8859-1"),"utf-8");
			interview inter=new interview();
			inter.setCid(cid);
			inter.setEvalute(evalute);
			inter.setId(id);
			inter.setJieshao(zi);
			inter.setProblem(pro);
			inter.setStuid(stuid);
			inter.setTime(time);
			int re=ser.update(inter);
			out.print("{\"re\":\""+re+"\"}");
		}else if (op.equals("checkname")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			int re=ser.check(id);
			out.print("{\"re\":\""+re+"\"}");
		}
		if (a!=null) {
			request.getServletContext().setAttribute("a", a);
			RequestDispatcher rd=request.getRequestDispatcher("/lcServlet");
			try{
				
				rd.forward(
					request, response);
			return;
			}catch(Exception e){
				
			}
		}

		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

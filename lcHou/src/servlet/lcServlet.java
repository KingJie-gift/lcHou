package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.ClassTalkserviceImpl;
import service.impl.LessonServiceImpl;
import service.impl.Member1serviceImpl;
import service.impl.class1ServiceImpl;
import service.impl.studentServiceImpl;
import service.impl.teacherServiceImpl;
import util.MyServletUtil;

import com.alibaba.fastjson.JSON;

import entity.ClassTalk;
import entity.LineChartDemo1;
import entity.Member1;
import entity.Page1;
import entity.admin;
import entity.class1;
import entity.lesson;
import entity.student;

public class lcServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ClassTalkserviceImpl cts = new ClassTalkserviceImpl();
		class1ServiceImpl cs = new class1ServiceImpl();
		Member1serviceImpl ms=new Member1serviceImpl();
		teacherServiceImpl ts=new teacherServiceImpl();
		studentServiceImpl ss=new studentServiceImpl();
		LessonServiceImpl ls=new LessonServiceImpl();
		String op = request.getParameter("op");
		//主页面小演讲表查询
		if (op.equals("select")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			class1 c=cs.getById(id);
			request.setAttribute("c", c);
			Integer pageIndex=Integer.parseInt(request.getParameter("index"));
			
			String weekn = request.getParameter("week");
			
			Integer week=weekn==null?-1:Integer.parseInt(weekn);
			
			request.setAttribute("week", week);
			
			Page1 p=new Page1();
			p.setPageSize(8);
			p.setDataCount(cts.getAllCount(week,id));
			p.setPageIndex(pageIndex);
			p.setList(cts.weekById(p, week, id));
		    request.setAttribute("pa", p);
			request.getRequestDispatcher("classTalk-select.jsp").forward(
				request, response);
			//查询班级名称
		} else if (op.equals("toselect")) {
			List<class1> clist = cs.getclassList(0);
			request.getSession().setAttribute("clist", clist);
			request.getRequestDispatcher("lesson-insert.jsp").forward(
					request, response);
			//通过id查找集合 详细信息
		} else if (op.equals("selectName")) {
			String sname=request.getParameter("name");
		    sname=new String(sname.getBytes("iso-8859-1"),"utf-8");
			//折线图
			String image=(String)request.getServletContext().getAttribute("image");
			request.setAttribute("image", image);
			
			
			List<ClassTalk> nameList = cts.getByName(sname);
			request.getSession().setAttribute("nlist", nameList);
			request.getSession().setAttribute("sname", sname);
			request.getRequestDispatcher("classtalk-selectnameList.jsp").forward(
					request, response);
			//查找插入时 查找  学员姓名
		} else if (op.equals("selectToinsert")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			class1 c=cs.getById(id);
			request.setAttribute("c", c);
			List<Member1> m=ms.getMember1sList();
			request.setAttribute("mlist", m);
			List<student> list =ss.getsName(id); 
			request.setAttribute("list", list);
		
			request.getRequestDispatcher("classTalk-insert.jsp").forward(
					request, response);
			//小演讲插入方法
		} else if (op.equals("talkInsert")) {
			String name = request.getParameter("name");
			Integer cid = Integer.parseInt(request.getParameter("cid"));
			Integer time = Integer.parseInt(request.getParameter("time"));
			Integer taifeng = Integer.parseInt(request.getParameter("taifeng"));
			Integer smooth = Integer.parseInt(request.getParameter("smooth"));
			Integer active = Integer.parseInt(request.getParameter("active"));
			Integer content = Integer.parseInt(request.getParameter("content"));
			Integer sum = Integer.parseInt(request.getParameter("sum"));
			String evaluate = request.getParameter("evaluate");
			Integer memberid = Integer.parseInt(request.getParameter("memberid"));
			int result1=cts.checkTalk(name);
			int result;
			ClassTalk cl = new ClassTalk();
			if(result1>=1){
				cl.setSname(name);
				cl.setTime(time);
				cl.setTaifeng(taifeng);
				cl.setSmooth(smooth);
				cl.setActive(active);
				cl.setContent(content); 
				cl.setSum(sum);
				cl.setEvaluate(evaluate);
				result=cts.update(cl);
				out.print("{\"result\":\""+result+"\"}");
			}else{
			cl.setCid(cid);
			cl.setSname(name);
			cl.setTime(time);
			cl.setTaifeng(taifeng);
			cl.setSmooth(smooth);
			cl.setActive(active);
			cl.setContent(content); 
			cl.setSum(sum);
			cl.setEvaluate(evaluate);
			cl.setMemberid(memberid);
			result= cts.insert(cl);
			out.print("{\"result\":\""+result+"\"}");
			}
		} else if (op.equals("talktoinsert")){
			admin a=(admin)request.getServletContext().getAttribute("a");
			List<class1> clist = null;
			
			if (a.getType()==1) {
				int id=ts.setea(a.getName());
				clist = cs.getclassList(id);	
			}else{
				clist = cs.getclassList(0);
			}
		 
			request.setAttribute("a", a);
			Integer va=Integer.parseInt(request.getParameter("va"));
			request.getSession().setAttribute("va", va);
			request.getSession().setAttribute("clist", clist);
			request.getRequestDispatcher("classTalk-toindex.jsp").forward(
					request, response);	
	   }else if(op.equals("meminfo")){
		   Integer id=Integer.parseInt(request.getParameter("id"));
		   List<Member1> m=ms.getbyName(id);
		   String json = JSON.toJSONString(m);
		   out.print(json);
		   
	   }else if(op.equals("lessInsert")){
		   Integer id=Integer.parseInt(request.getParameter("classid"));
		   String week=request.getParameter("week");
		   Integer none=Integer.parseInt(request.getParameter("none"));
		   String lessonid=request.getParameter("lesson");
		   Integer memberid=Integer.parseInt(request.getParameter("memberid"));
		   String talkTime=request.getParameter("birthday");
		   lesson l=new lesson();
		   l.setTalkTime(talkTime);
		   l.setClassid(id);
		   l.setWeek(week);
		   l.setNone(none);
		   l.setLesson(lessonid);
		   l.setMemberid(memberid);
		   int result=ls.insert(l);
		   if (result>0) {
			request.getSession().setAttribute("rr","添加成功");
			request.getRequestDispatcher("lesson-insert.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("rr","添加失敗");
			request.getRequestDispatcher("lesson-insert.jsp").forward(request, response);
		}
		   
	   }else if(op.equals("lessSelect")){
		   List<lesson> llist=ls.getlessList();
		   request.setAttribute("llist",llist);
		   request.getRequestDispatcher("lesson-select.jsp").forward(request, response);
	   }else if(op.equals("checklesson")){
		   Integer classid=Integer.parseInt(request.getParameter("classid"));
		   Integer none=Integer.parseInt(request.getParameter("none"));
		   String week=request.getParameter("week");
		   int result=ls.checklesson(classid, none, week);
		   out.print("{\"result\":\""+result+"\"}");
		   
	   }else if(op.equals("image")){
		   
			ClassTalkserviceImpl ct=new ClassTalkserviceImpl();
			//String sname=(String)request.getServletContext().getAttribute("sname");
			String sname=request.getParameter("name");
			sname=new String(sname.getBytes("iso-8859-1"),"utf-8");
			List<ClassTalk> jlist=ct.jree(sname);
			// 在项目WebRoot下创建的存放报表图片的文件夹名
			String folderName = "DisplayChart";
			String imgPath = this.getServletContext().getRealPath("/"+folderName);
			
			//保存图片 返回图片文件名
			String filename = MyServletUtil.save(LineChartDemo1.createDemoPanel(jlist), 1000, 400,imgPath); 

			//拼接<img src="  " =u/>
			String image=  "<img src='" + folderName + "/"
			            + filename 
			            + "'width=1000 height=400 border=0 usemap='#" 
			            + filename + "'/>";   
			// 把生成的图片节点放入request中
			request.setAttribute("image", image);
			request.getRequestDispatcher("classtalk-selectnameList.jsp").forward(request, response);
	   }
//		else if(op.equals("loginquest")){ 
//		   admin a=(admin)request.getServletContext().getAttribute("a");
//		
//			List<lesson> l=null;
//			if (a.getType()==0) {
//				int id=ms.selectid(a.getName());
//				l=ls.getByName(id);
		
//		
//			request.getSession().setAttribute("less", l);
//			request.setAttribute("a", a);
//			request.getRequestDispatcher("main.jsp").forward(
//					request, response);	
//			}
//	   }
//			if (sname!=null) {
//				request.getServletContext().setAttribute("sname", sname);
//				RequestDispatcher rd=request.getRequestDispatcher("/TestServler");
//				try{
//					
//					rd.forward(
//						request, response);
//				return;
//				}catch(Exception e){
//					
//				}
//			}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

}

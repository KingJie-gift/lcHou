package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import service.impl.class1ServiceImpl;
import service.impl.coachServiceImpl;
import service.impl.ctypeServiceImpl;
import service.impl.memberServiceImpl;
import service.impl.studentServiceImpl;
import service.impl.teacherServiceImpl;
import entity.Ctype;
import entity.Page;
import entity.class1;
import entity.coach;
import entity.member;
import entity.pag;
import entity.student;
import entity.teacher;

public class clServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String op=request.getParameter("op");
		teacherServiceImpl tsi=new teacherServiceImpl();
		class1ServiceImpl csi=new class1ServiceImpl();
		ctypeServiceImpl  cri=new ctypeServiceImpl();
		coachServiceImpl ceri=new coachServiceImpl();
		memberServiceImpl memSer=new memberServiceImpl();
		studentServiceImpl ssi=new studentServiceImpl();
		if(op.equals("Teacherselect")){
			List<teacher> list=tsi.getTeacherselect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("teaFen.jsp").forward(request, response);
		}else if(op.equals("Teacherfen")){
			String name=request.getParameter("name");
			name = name==null?"":name;
			  Page p=new Page();
			  p.setPageSize(9);
			  p.setDataCount(tsi.count(name));
			  p.setPageIndex(Integer.parseInt(request.getParameter("index")));
			  tsi.getPageList(p, name);
			  request.setAttribute("p", p);
			  request.getRequestDispatcher("teaFen.jsp").forward(request, response);
		}else if(op.equals("teacherdel")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			Integer result=tsi.getTeacherdelete(id);
			out.print("{\"result\":\""+result+"\"}");
		}else if(op.equals("Teacheradd")){
			String name=request.getParameter("name");
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			String phone=request.getParameter("phone");
			String motto=request.getParameter("motto");
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			motto=new String(motto.getBytes("iso-8859-1"),"utf-8");
			teacher ta=new teacher();
			ta.setAccount(account);
			ta.setMotto(motto);
			ta.setName(name);
			ta.setPhone(phone);
			ta.setPwd(pwd);
			int re=tsi.getTeacherinsert(ta);
			 
			out.print("{\"re\":\""+re+"\"}");
		}else if(op.equals("Teacherupdate")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			String phone=request.getParameter("phone");
			String motto=request.getParameter("motto");
			String name=request.getParameter("name");
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			motto=new String(motto.getBytes("iso-8859-1"),"utf-8");
			Integer dis=Integer.parseInt(request.getParameter("dis"));
			teacher ta=new teacher();
			ta.setName(name);
			ta.setId(id);
			ta.setMotto(motto);
			ta.setDis(dis);
			ta.setPhone(phone);
			int re=tsi.getTeacherupdate(ta);
			 out.print("{\"re\":\""+re+"\"}");
			 
		}else if(op.equals("Classselect")){
			List<class1> list=csi.getClassSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("ClassSelect.jsp").forward(request, response);
		}else if(op.equals("Classfen")){
			
			List<Ctype> typeist=cri.getCtypeList();
			request.setAttribute("typeist", typeist);
			
			List<coach> coacthist=ceri.getCoachSelect();
			request.setAttribute("coacthist", coacthist);
			
			List<teacher> teachist=tsi.getTeacherselect();
			request.setAttribute("teachist", teachist);
		  Page p=new Page();
		  p.setPageSize(6);
		  p.setDataCount(csi.count());
		  p.setPageIndex(Integer.parseInt(request.getParameter("index")));
		  p.setList(csi.getPageList(p));
		  request.setAttribute("p", p);
		  request.getRequestDispatcher("Classfen.jsp").forward(request, response);
		}else if(op.equals("Classdel")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			Integer result=csi.getClassdelete(id);
			out.print("{\"result\":\""+result+"\"}");
		  
		}else if(op.equals("Classadd")){
			String name=request.getParameter("name");
			int gradeId=Integer.parseInt(request.getParameter("typeName"));
			int count=Integer.parseInt(request.getParameter("counts"));
			int teacher=Integer.parseInt(request.getParameter("TeacherName"));
			int CoachName=Integer.parseInt(request.getParameter("CoachName"));
			String motto=request.getParameter("motto");
			motto=new String(motto.getBytes("iso-8859-1"),"utf-8");
			
			class1 cs=new class1();
			cs.setClassname(name);
			cs.setCoachid(CoachName);
			cs.setTeaid(teacher);
			cs.setTypeid(gradeId);
			cs.setMotto(motto);
			cs.setCount(count);
			int re=csi.getClassinsert(cs);
			out.print("{\"re\":\""+re+"\"}");
		 
		}else if(op.equals("Classtodate")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			class1 p=csi.getByClassId(id);
			request.setAttribute("p", p);
			List<Ctype> typeist=cri.getCtypeList();
			request.setAttribute("typeist", typeist);
			
			List<coach> coacthist=ceri.getCoachSelect();
			request.setAttribute("coacthist", coacthist);
			
			List<teacher> teachist=tsi.getTeacherselect();
			request.setAttribute("teachist", teachist);
			
			request.getRequestDispatcher("ClassUpdate.jsp").forward(request, response);
		}else if(op.equals("Classupdate")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int gradeId=Integer.parseInt(request.getParameter("typeName"));
			int count=Integer.parseInt(request.getParameter("count"));
			int teacher=Integer.parseInt(request.getParameter("TeacherName"));
			int CoachName=Integer.parseInt(request.getParameter("CoachName"));
			String motto=request.getParameter("motto");
			
			class1 cs=new class1();
			cs.setClassid(id);
			cs.setClassname(name);
			cs.setCoachid(CoachName);
			cs.setTeaid(teacher);
			cs.setTypeid(gradeId);
			cs.setMotto(motto);
			cs.setCount(count);
			int result=csi.getClassUpdate(cs);
			if(result>0){
				out.print("<script>alert('更新成功');location.href='ClassSelect.jsp'</script>");
			}else{
				out.print("<script>alert('更新失败');location.href='ClassSelect.jsp'</script>");
			}
		}else if(op.equals("Stdentselect")){
			List<student> list=ssi.getStudentSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("StudentSelect.jsp").forward(request, response);
		}else if(op.equals("Stdentfen")){
			//获取name
			String name=request.getParameter("name");
			name=name==null?"":name;
			//获取下拉框
			String cid=request.getParameter("cid");
			cid=cid==null?"-1":cid;
			Integer id=Integer.parseInt(cid);
			request.setAttribute("name", name);
			request.setAttribute("id", id);
			  //绑定下拉框
			List<class1> clist=csi.getClassSelect();
			 request.setAttribute("clist", clist);
			 //分页数据
			  Page p=new Page();
			  p.setPageSize(9);
			  p.setDataCount(ssi.count(name,id));
			  p.setPageIndex(Integer.parseInt(request.getParameter("index")));
			  ssi.getPageList(p, name, id);
			  request.setAttribute("p", p);
			  request.getRequestDispatcher("Stufen.jsp").forward(request, response);
		}else if(op.equals("Studentdel")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			Integer result=ssi.getStudentdelete(id);
			out.print("{\"result\":\""+result+"\"}");
		}else if(op.equals("Studenttoadd")){
			List<class1> clist=csi.getClassSelect();
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("Stufen.jsp").forward(request, response);
		}else if(op.equals("Studentadd")){
			String name=request.getParameter("name");
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			int ClassName=Integer.parseInt(request.getParameter("cid"));
			student st=new student();
			st.setStuname(name);
			st.setCid(ClassName);
			int re=ssi.getStudentinsert(st);
			out.print("{\"re\":\""+re+"\"}");
		}else if (op.equals("memAdd")) {
			Integer cid=Integer.parseInt(request.getParameter("cid"));
			String motto=request.getParameter("motto");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			Integer course=Integer.parseInt(request.getParameter("course"));
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			motto=new String(motto.getBytes("iso-8859-1"),"utf-8");
			member m=new member();
			m.setClassid(cid);
			m.setCourse(course);
			m.setMotto(motto);
			m.setPhone(phone);
			m.setName(name);
			int re=memSer.add(m);
			out.print("{\"re\":\""+re+"\"}");
		}else if (op.equals("memUpdate")) {
			Integer cid=Integer.parseInt(request.getParameter("cid"));
			Integer id=Integer.parseInt(request.getParameter("id"));
			String motto=request.getParameter("motto");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			Integer course=Integer.parseInt(request.getParameter("course"));
			String tagname=request.getParameter("tag");
			tagname=tagname==null?"0":tagname;
			Integer tag=Integer.parseInt(tagname);
			//编码
			name=new String(name.getBytes("iso-8859-1"),"utf-8");
			motto=new String(motto.getBytes("iso-8859-1"),"utf-8");
			//赋值
			member m=new member();
			m.setClassid(cid);
			m.setId(id);
			m.setPhone(phone);
			m.setCourse(course);
			m.setMotto(motto);
			m.setName(name);
			m.setTag(tag);
			int re=memSer.update(m);
			out.print("{\"re\":\""+re+"\"}");
		}else if (op.equals("del")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			int re=memSer.delete(id);
			out.print("{\"re\":\""+re+"\"}");
		}else if (op.equals("memFen")) {
			//获取name
			String name=request.getParameter("name");
			name=name==null?"":name;
			//获取下拉框
			String cid=request.getParameter("cid");
			cid=cid==null?"-1":cid;
			Integer id=Integer.parseInt(cid);
			request.setAttribute("name", name);
			request.setAttribute("id", id);
			  //绑定下拉框
			List<class1> clist=csi.getClassSelect();
			 request.setAttribute("clist", clist);
			 //分页数据
			 pag p=new pag();
			  p.setCount(10);
			  p.setTotalData(memSer.count(name, id));
			  p.setIndex(Integer.parseInt(request.getParameter("index")));
			  memSer.query(p, name, id);
			  request.setAttribute("p", p);
			  request.getRequestDispatcher("memFen.jsp").forward(request, response);
		}
		out.flush();
		out.close();

}
}

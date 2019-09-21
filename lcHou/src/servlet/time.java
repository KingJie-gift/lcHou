package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class time extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		if(op.equals("timeAA")){
			String time = request.getParameter("time");
			out.print("<script>alert(time)</script>");
		}
		
		
		out.flush();
		out.close();
	}

}

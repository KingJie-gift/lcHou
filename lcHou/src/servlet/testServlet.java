package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.LineChartDemo;
import entity.interview;
import service.impl.interviewServiceImpl;
import util.MyServletUtil;

public class testServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		interviewServiceImpl ser=new interviewServiceImpl();
		int stuid =Integer.parseInt(request.getParameter("id"));
		List<interview> list=ser.getChart(stuid);
		
		// 在项目WebRoot下创建的存放报表图片的文件夹名
		String folderName = "DisplayChart";
		String imgPath = this.getServletContext().getRealPath("/"+folderName);
		// 获取数据集合
		//保存图片 返回图片文件名
		String filename = MyServletUtil.save(LineChartDemo.createDemoPanel(list), 600, 400,imgPath); 

		//拼接<img src="  "  />
		String image=  "<img src='" + folderName + "/"
		            + filename 
		            + "' width=600 height=400 border=0 usemap='#" 
		            + filename + "'/>";   
		// 把生成的图片节点放入request中
		request.setAttribute("image", image);
		request.getRequestDispatcher("interFen3.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

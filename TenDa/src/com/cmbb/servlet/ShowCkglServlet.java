package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.GetPage;
import com.cmbb.bean.Login;
import com.cmbb.bean.ShowCk;
import com.cmbb.service.CkxxService;

public class ShowCkglServlet extends HttpServlet {
	/*CkglDao dao = new CkglDao();*/
	/**
	 * Constructor of the object.
	 */
	public ShowCkglServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CkxxService ckxxservice = new CkxxService();
		
		String nowdayPage =request.getParameter("nowdayPage") ;
		if(nowdayPage==null)
		{
			nowdayPage = "1";
		}
		int nowdayPage1 = Integer.valueOf(nowdayPage);
		GetPage page = ckxxservice.selectPage(nowdayPage1);
		request.setAttribute("page", page);
		
		RequestDispatcher rd= request.getRequestDispatcher("../ckxx/ckgl.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

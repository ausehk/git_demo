package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Motorcade;
import com.cmbb.dao.MotorcadeDao;

public class cdtjServlet extends HttpServlet {
	private MotorcadeDao dao;
	/**
	 * Constructor of the object.
	 */
	public cdtjServlet() {
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
		
		this.doPost(request, response);
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
		PrintWriter out = response.getWriter();
		String motorcadeNum=dao.getMotorcadeNum();
		String motorcadeName=request.getParameter("motorcadeName");
		
		String chargeId=new String(request.getParameter("chargeId").getBytes("iso-8859-1"),"utf-8");
	
			
		Motorcade motorcade=new Motorcade();
		motorcade.setMotorcadeNum(motorcadeNum);
		motorcade.setMotorcadeName(motorcadeName);
		motorcade.setChargeId(chargeId);
		if(dao.addMotorcade(motorcade)){
			request.getRequestDispatcher("cdglServlet").forward(request, response);
		}else{
			out.print("<script>alert('����ʧ�ܣ�');history.go(-1);</script>");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		dao=new MotorcadeDao();
	}

}

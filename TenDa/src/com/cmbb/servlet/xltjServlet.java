package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.DedicatedLine;
import com.cmbb.dao.DedicatedLineDao;

public class xltjServlet extends HttpServlet {
	private DedicatedLineDao dao;
	/**
	 * Constructor of the object.
	 */
	public xltjServlet() {
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
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String lineStart=new String(request.getParameter("LineStart").getBytes("iso-8859-1"),"utf-8");
		String lineDestination=new String(request.getParameter("LineDestination").getBytes("iso-8859-1"),"utf-8");
		String lineThrough=new String(request.getParameter("LineThrough").getBytes("iso-8859-1"),"utf-8");
		String lineRemark=new String(request.getParameter("LineRemark").getBytes("iso-8859-1"),"utf-8");
		DedicatedLine Line=new DedicatedLine();
		Line.setDedicatedLineStart(lineStart);
		Line.setDedicatedLineDestination(lineDestination);
		Line.setDedicatedLineThrough(lineThrough);
		Line.setDedicatedLineRemark(lineRemark);
		if(dao.addDedicatedLine(Line)){
			request.getRequestDispatcher("xlglServlet").forward(request, response);
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
		dao=new DedicatedLineDao();
	}

}

package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cmbb.bean.WareHouse;
import com.cmbb.service.CkxxService;

public class UpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
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
		PrintWriter out = response.getWriter();
		WareHouse warehouse = new WareHouse();
		String WareHouseAdd =  request.getParameter("wareHouseAdd");
		String ChargeId = request.getParameter("chargeId");
		String WareHouseNumber = request.getParameter("wareHouseNumber");
		String WareHouseName = request.getParameter("wareHouseName");
		
		warehouse.setWareHouseNumber(WareHouseNumber);
		warehouse.setWareHouseName(WareHouseName);
		warehouse.setWareHouseAdd(WareHouseAdd);
		warehouse.setChargeId(ChargeId);
		CkxxService ckxxservice = new CkxxService();
		boolean updateck = ckxxservice.updateCk(warehouse);
		if(updateck)
		{
			RequestDispatcher rd= request.getRequestDispatcher("../ckxx/ShowCkglServlet");
			rd.forward(request, response);
		}else{
			out.write("�޸�ʧ��");
		}
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

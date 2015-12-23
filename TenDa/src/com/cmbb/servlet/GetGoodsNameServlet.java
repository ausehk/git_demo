package com.cmbb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Login;
import com.cmbb.bean.ShowGoodsComboBox;
import com.cmbb.service.CkxxService;

public class GetGoodsNameServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetGoodsNameServlet() {
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
		
		CkxxService ckxxService = new CkxxService();	
		List<Login> LoginName=ckxxService.selectLogin();
		List<ShowGoodsComboBox> GoodsName = ckxxService.selectGoodsName();
		List<ShowGoodsComboBox> GoodsTypeName = ckxxService.selectGoodsTypeName();
		request.getSession().setAttribute("LoginName", LoginName);
		request.getSession().setAttribute("GoodsName", GoodsName);
		request.getSession().setAttribute("GoodsTypeName", GoodsTypeName);
		request.getRequestDispatcher("addEntryStore.jsp").forward(request, response);
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

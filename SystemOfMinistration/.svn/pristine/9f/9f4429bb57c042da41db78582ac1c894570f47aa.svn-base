package com.zrgk.clientinfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.clientinfo.model.Customers;
import com.zrgk.clientinfo.service.UsersServiceInter;
import com.zrgk.clientinfo.service.impl.UsersServiceImpl;

public class LookUserServlet extends HttpServlet{

	private static final long serialVersionUID = -9186621817285024678L;

	UsersServiceInter usersService=new UsersServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置request的编码格式 
		response.setContentType("text/html;charset=utf-8");//设置response的编码格式 
		String cid=request.getParameter("id");
		Customers u=usersService.queryUsersByCid(Integer.parseInt(cid));
		//向request存Users的详细信息，以便在页面展示用
		request.setAttribute("loo", u);
		request.getRequestDispatcher("jsp/jsp_clientinfo/customer-look.jsp").forward(request, response);
	}
	
}

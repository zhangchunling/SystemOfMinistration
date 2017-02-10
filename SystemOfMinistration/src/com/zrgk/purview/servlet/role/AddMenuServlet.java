package com.zrgk.purview.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;

public class AddMenuServlet extends HttpServlet {

	MenuServiceInter menuService = new MenuServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		 
	 
		request.setAttribute("menulist", menuService.addQueryAll(null));
		
		request.getRequestDispatcher("jsp/jsp_purview/addRole.jsp").forward(
				request, response);
	}


	}

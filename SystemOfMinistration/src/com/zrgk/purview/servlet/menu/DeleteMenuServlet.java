package com.zrgk.purview.servlet.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Menu;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class DeleteMenuServlet extends HttpServlet {
	
	MenuServiceInter menuService = new MenuServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		 
		
		String mid =request.getParameter("mid");
		
		Menu menu= new Menu();
		
		menu.setMid(Integer.parseInt(mid));
		
		
		 menuService.deleteMenu(menu);
		
		
		request.getRequestDispatcher("queryAllMenu.Servlet").forward(request, response);
		
		
	}
}

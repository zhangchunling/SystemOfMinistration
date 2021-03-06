package com.zrgk.purview.servlet.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.model.Menu;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class QueryByMidServlet extends HttpServlet {

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

		String 	mid = request.getParameter("mid");
		System.out.println("mid="+mid);
		
		int parentId=0;
		Menu menu = new Menu();

		 
		
		menu.setParentId( parentId);
		
		menu.setMid(Integer.parseInt(mid));
		
		List<Menu> menus=menuService.QueryByMid(menu);

		List<Menu> list=menuService.addQueryAll(menu);

	if (menus!=null&&list!=null){
		
		request.setAttribute("menu", menus.get(0));
		request.setAttribute("addmenu", list);
		request.getRequestDispatcher("jsp/jsp_purview/updateMenu.jsp").forward(
				request, response);
	}


	}
}
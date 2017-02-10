package com.zrgk.purview.servlet.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Menu;
import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;


public class InsertMenuServlet extends HttpServlet {

	
	
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

		String menuPath = request.getParameter("menuPath");
		System.out.println("menuPath="+menuPath);
		
		 
		String menuNum= request.getParameter("menuNum");
		System.out.println("menuNum="+menuNum);
		
		String menuName = request.getParameter("menuName");
		System.out.println("menuName="+menuName);
		
		String parentId = request.getParameter("parentId");
		
		System.out.println("parentId="+parentId);
		 
		String remark = request.getParameter("remark");
		System.out.println("remark="+remark);
		  
		int state=1;
		
		
		Menu menu= new Menu(); 
		
		menu.setMenuName (menuName); 
		
		menu.setMenuNum(menuNum) ; 
		
		menu.setParentId(Integer.parseInt(parentId));
		
		menu.setRemark(remark);
		
		menu.setMenuPath(menuPath); 
		
		menu.setState(state);
		
		
		menuService.insertMenu(menu);
		
		request.getRequestDispatcher("queryAllMenu.Servlet").forward(request, response);
		
	}	
}

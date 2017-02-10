package com.zrgk.purview.servlet.menu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.Menu;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class UpdateMenuServlet extends HttpServlet {

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

		String menuNum= request.getParameter("menuNum");
		
		System.out.println("menuNum="+menuNum);
		 
  
		String  menuName= request.getParameter("menuName");
		System.out.println("menuName=" + menuName);
 

		String parentId= request.getParameter("parentId");
		System.out.println("parentId=" + parentId);
		
		

		String menuPath= request.getParameter("menuPath");
		System.out.println("menuPath=" + menuPath);
		
		String remark = request.getParameter("remark");
		System.out.println("remark=" +remark);

		String mid=request.getParameter("mid");
		 
		System.out.println("mid=" +mid);

		Menu menu = new Menu();


		menu.setMid(Integer.parseInt(mid));
		
		menu.setMenuNum(menuNum);

		menu.setMenuName(menuName);

		menu.setParentId (Integer.parseInt(parentId));
		
		menu.setMenuPath(menuPath);
		
		
		menu.setRemark(remark);

		 
		 
		if (menu!=null) {
			
			menuService.UpdateMenu(menu);
			request.getRequestDispatcher("queryAllMenu.Servlet").forward(request,
					response);
		}


	}
}
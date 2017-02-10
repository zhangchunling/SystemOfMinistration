package com.zrgk.purview.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.MenuServiceImpl;
import com.zrgk.purview.service.MenuServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class LookRoleServlet extends HttpServlet {

	RoleServiceImpl roleService = new RoleServiceImpl();
	
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
		
		String rid = request.getParameter("rid");
		
		System.out.println("rid="+rid);
		Role role= new Role();
		
		role.setRid(Integer.parseInt(rid));
		Role  roles = roleService.QueryByRid(role);

		 
		 
		request.setAttribute("role", roles);
		

		request.setAttribute("menulist", menuService.addQueryAll(null));
		request.getRequestDispatcher("jsp/jsp_purview/lookRole.jsp").forward(
				request, response);

	}
}
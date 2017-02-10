package com.zrgk.purview.servlet.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Menu;
import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.RoleServiceImpl;
import com.zrgk.purview.service.RoleServiceInter;

public class QueryEmployeeAllRoleServlet extends HttpServlet {

	RoleServiceInter roleService = new RoleServiceImpl();

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

		 
		
		 
		List<Role> list = roleService.QueryAllEmployee(null); 

		
		request.setAttribute("addRole", list);
		 
		
		request.getRequestDispatcher("jsp/jsp_purview/addEmployee.jsp").forward(
				request, response);
	}
}

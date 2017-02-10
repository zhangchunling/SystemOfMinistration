package com.zrgk.purview.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class DeleteRoleServlet extends HttpServlet {
	
	RoleServiceImpl roleService = new RoleServiceImpl();
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
		
		 
		
		String rid =request.getParameter("rid");
		
		System.out.println("rid="+rid);
		Role role= new Role();
		
		role.setRid(Integer.parseInt(rid));
		
		
		 roleService.deleteRole(role);
		
		
		request.getRequestDispatcher("queryAllRole.Servlet").forward(request, response);
		
		
	}
}

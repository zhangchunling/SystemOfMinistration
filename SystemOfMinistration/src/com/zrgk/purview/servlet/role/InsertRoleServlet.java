package com.zrgk.purview.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Menu;
import com.zrgk.purview.model.RidAndMid;
import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.RoleServiceImpl;


public class InsertRoleServlet extends HttpServlet {

	
	
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
		
		String menus = request.getParameter("menus");
		System.out.println("menus="+menus);
		
		 
		String roleNum= request.getParameter("roleNum");
		System.out.println("roleNum="+roleNum);
		
		String roleName = request.getParameter("roleName");
		System.out.println("roleName="+roleName);
		
		String state = request.getParameter("state");
		
		System.out.println("state="+state);
		 
		String remark = request.getParameter("remark");
		System.out.println("remark="+remark);
		  
		RidAndMid rm= new RidAndMid();
		
		Role role= new Role(); 
		
		role.setRoleNum(roleNum); 
		
		role.setRoleName(roleName); 
		
		role.setState(Integer.parseInt(state));
		
		role.setMenus(menus);
		
		role.setRemark(remark);
		
		int rid=roleService.QueryByMenus(role);
		
		if (rid >0) {

			rm.setR_id(rid);
			roleService.deleteByRidAndMid(rm);

		}
		
		
		
		roleService.insertRole(role);
		 
		
		
		
		
		String[]  menuArr=menus.split(",");
		for (int i = 0; i <menuArr.length; i++) {
				
			  
			 rm.setR_id(roleService.QueryByMenus(role));
			 
			 System.out.println("rid="+roleService.QueryByMenus(role));
			 rm.setM_id(Integer.parseInt(menuArr[i]));
			 roleService.addRidAndMid(rm);
		}
		
		
		request.getRequestDispatcher("queryAllRole.Servlet").forward(request, response);
		
	}	
}

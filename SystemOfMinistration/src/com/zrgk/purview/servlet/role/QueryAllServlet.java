package com.zrgk.purview.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.Role;
import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.RoleServiceImpl;

public class QueryAllServlet extends HttpServlet {

	RoleServiceImpl roleService = new RoleServiceImpl();

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

		String keyword = request.getParameter("keyword");

		System.out.println("keyword=" + keyword);

		String currentPage = request.getParameter("currentPage");
		Role role = new Role();

		if (keyword != null && !"".equals(keyword.trim())) {
			role.setRoleName(keyword);
			HttpSession session =request.getSession();
			
			session.setAttribute("keyRole",keyword);

		}
		
		if (currentPage != null && !"".equals(currentPage.trim())) {
			role.setCurrentPage(Integer.parseInt(currentPage));
		}

		role.setTotalSize(roleService.totalSize(role));

		
		List<Role> list = roleService.QueryAll(role);

		request.setAttribute("role", role);
		request.setAttribute("list", list);

		request.getRequestDispatcher("jsp/jsp_purview/role.jsp").forward(
				request, response);
	}
}

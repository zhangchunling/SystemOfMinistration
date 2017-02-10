package com.zrgk.purview.servlet.role;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.RidAndMid;
import com.zrgk.purview.model.Role;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.purview.service.RoleServiceImpl;

public class UpdateRoleServlet extends HttpServlet {

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

		RidAndMid rm = new RidAndMid();
		
		
		String roleNum = request.getParameter("roleNum");

		System.out.println("roleNum=" + roleNum);

		String roleName = request.getParameter("roleName");
		System.out.println("roleName=" + roleName);

		String state = request.getParameter("state");
		System.out.println("state=" + state);

		String rid = request.getParameter("rid");

		System.out.println("rid=" + rid);

		if (rid != null) {

			rm.setR_id(Integer.parseInt(rid));
			roleService.deleteByRidAndMid(rm);

		}

		String menus = request.getParameter("menus");
		System.out.println("menus=" + menus);

		if (menus!=null) {
			
			String[] menuArr = menus.split(",");
			for (int i = 0; i < menuArr.length; i++) {

				rm.setR_id(Integer.parseInt(rid));

				rm.setM_id(Integer.parseInt(menuArr[i]));
				roleService.addRidAndMid(rm);
			}
		}

		String remark = request.getParameter("remark");
		System.out.println("remark=" + remark);


		Role role = new Role();

		if (rid != null) {

			role.setRid(Integer.parseInt(rid));
		}

		role.setRoleNum(roleNum);

		role.setRoleName(roleName);

		if (state != null) {

			role.setState(Integer.parseInt(state));
		}

		role.setMenus(menus);

		role.setRemark(remark);

		if (role != null) {

			roleService.UpdateRole(role);

			request.getRequestDispatcher("queryAllRole.Servlet").forward(
					request, response);
		}

	}
}
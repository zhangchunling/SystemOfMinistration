package com.zrgk.purview.servlet.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;

public class LookEmployeeServlet extends HttpServlet {

	EmployeeServiceInter employeeService = new EmployeeServiceImpl();

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

		String eid = request.getParameter("eid");
		
		
		Employee em= new Employee();
		
		em.setEid(Integer.parseInt(eid));
		Employee  empl =( Employee) employeeService.QueryByEid(em);

		 
		HttpSession session = request.getSession();

		session.setAttribute("empl", empl);
		
		
		request.getRequestDispatcher("jsp/jsp_purview/lookEmployee.jsp").forward(
				request, response);

	}
}
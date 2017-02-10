package com.zrgk.purview.servlet.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;

public class DeleteEmployeeServlet extends HttpServlet {
	
	
	EmployeeServiceInter employeeService = new EmployeeServiceImpl();
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
	
		
		String eid =request.getParameter("eid");
		
		Employee em= new Employee();
		
		em.setEid(Integer.parseInt(eid));
		
		
		employeeService.deleteEmployee(em);
		
		
		request.getRequestDispatcher("queryAll.Servlet").forward(request, response);
		
		
	}
}

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

public class QueryAllServlet extends HttpServlet {

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

		
		Employee em = new Employee();
		
		
		String keyword = request.getParameter("keyword");

		System.out.println("keyword=" + keyword);
		 
 
		String currentPage = request.getParameter("currentPage");
 
		String time = request.getParameter("time");

		System.out.println("time=" + time);

		

		if (time != null && !"".equals(time.trim())) {
			em.setAddTime(time);

		}

		if (keyword != null&& !"".equals(keyword.trim())) {
			em.setName(keyword);
			em.setTel(keyword);
			
			HttpSession session =request.getSession();
			
			session.setAttribute("key",keyword);
		}

		// 分页用到的

		if (currentPage != null && !"".equals(currentPage.trim())) {
			em.setCurrentPage(Integer.parseInt(currentPage));
		}

		em.setTotalSize(employeeService.totalSize(em));

		List<Employee> list = employeeService.QueryAll(em);

		request.setAttribute("employee", em);
		request.setAttribute("list", list);

		request.getRequestDispatcher("jsp/jsp_purview/employee.jsp").forward(
				request, response);

	}
}

package com.zrgk.myinfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.myinfo.model.Employee;
import com.zrgk.myinfo.service.ProServiceInter;
import com.zrgk.myinfo.service.impl.ProServiceImpl;
/**
 * 查询人员信息的servlet
 * @author samson
 * 2015-06-03
 */
//通过继承HttpServlet将这个普通类变成servlet类
public class QueryEmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 7117526835523907130L;
	//实例化service
	ProServiceInter pro=new ProServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//设置request的编码格式
				request.setCharacterEncoding("utf-8");
				//设置response编码格式
				response.setContentType("text/html;charset=utf-8");
				
				String empName=request.getParameter("username");
				Employee emp=new Employee();
				
				if(empName!=null&&!"".equals(empName.trim()))
					emp.setUsername(empName);
				request.setAttribute("list",pro.queryEmployees(emp));
				
				request.getRequestDispatcher("jsp/jsp_myinfo/demand.jsp").forward(request, response);
	}
	
	
}

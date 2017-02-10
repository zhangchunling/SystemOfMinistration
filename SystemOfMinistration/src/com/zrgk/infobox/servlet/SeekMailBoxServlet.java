package com.zrgk.infobox.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.infobox.model.MailBox;
import com.zrgk.infobox.service.MailBoxServiceInter;
import com.zrgk.infobox.service.impl.MailBoxServiceImpl;
import com.zrgk.purview.model.Employee;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
/**
 查询数据库表里发信息的所有的内容servlet 
 * @author 樊丙富
 *2015-06-19
 */
public class SeekMailBoxServlet extends HttpServlet {

	EmployeeServiceInter employeeService = new EmployeeServiceImpl();	//实例化
		
		@Override//doget方法
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request ,response);//必须经过doPost这个方法

		}

		@Override//dopost方法
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
			
					request.setCharacterEncoding("utf-8");//返回值代码处理 (页面显示代码处理和数据库写入代码处理)
					response.setContentType("text/html;charset=utf-8");
			
					String UserName = request.getParameter("UserName");
					
					List<Employee> QueryAll = employeeService.QueryAll(new Employee());
					request.setAttribute("QueryAll", QueryAll);
							
							
							
							String reply = request.getParameter("reply");
						
							List<Employee> list = new ArrayList<Employee>();
							
							if (reply!=null&&!"".equals(reply)) {
								Employee empl=new Employee();
								Employee check = employeeService.QueryByEid(empl);

								
								list.add(check);
								request.setAttribute("QueryAll", list);
							}
					//发信息
					request.getRequestDispatcher("jsp/jsp_mailbox/message_seed.jsp")
					.forward(request, response);
				}
			}

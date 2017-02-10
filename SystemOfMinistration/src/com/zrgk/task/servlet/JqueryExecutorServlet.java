package com.zrgk.task.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.task.model.Employee;
import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.task.service.impl.TaskServiceImpl;

/**
 * @function: 任务管理servlet层对状态的jquery异步——JqueryStatusServlet.java
 * @author: 刘淼
 * @time: 2015-6-13
 * */
public class JqueryExecutorServlet extends HttpServlet {

	TaskServiceInter taskService = new TaskServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置request、response的编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 得到流的对象

		// task_add.jsp页面的状态——调用任务表
		List<Employee> list =taskService.queryAllEmployee();
	 
		
		if (list!=null) {
			
			request.setAttribute("name", list);
			request.getRequestDispatcher("jsp/jsp_task/task_add.jsp").forward(request, response);
		}

		
		
		 
	}
}
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
 * @function: 任务管理servlet层的按id查询所有任务信息——QueryByIdTaskServlet.java
 * @author: 刘淼
 * @time: 2015-6-8
 * */
public class QueryByIdTaskServlet extends HttpServlet{
	
	TaskServiceInter taskService=new TaskServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//设置request的编码格式 
		response.setContentType("text/html;charset=utf-8");//设置response的编码格式
		
		String tid=request.getParameter("tid");
	 
		
		if (tid!=null) {
			
			List<Task> list=(ArrayList<Task>)taskService.queryByIdTask(Integer.parseInt(tid));
			//向request存Task的详细信息，以便在页面展示用
				List<Employee> lists =taskService.queryAllEmployee();
				request.setAttribute("name", lists);
			
			
			
			request.setAttribute("task", list.get(0));
			request.getRequestDispatcher("jsp/jsp_task/task_edit.jsp").forward(request, response);
		}
	}
}
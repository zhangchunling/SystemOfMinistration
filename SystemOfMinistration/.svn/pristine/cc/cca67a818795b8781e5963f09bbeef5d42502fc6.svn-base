package com.zrgk.task.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.task.dao.TaskDaoInter;
import com.zrgk.task.dao.impl.TaskDaoImpl;
import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.task.service.impl.TaskServiceImpl;

/**
 * @function: 任务管理servlet层的按任务标题查询所有任务信息——QueryplanOptionTaskServlet.java
 * @author: 刘淼
 * @time: 2015-6-8
 * */
public class QueryplanOptionTaskServlet extends HttpServlet{
	
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
		
		//planOption任务标题
		String planOption=request.getParameter("planOption");			
		Task task=taskService.queryplanOptionTask(planOption);
		request.setAttribute("planOption", planOption);
		request.getRequestDispatcher("jsp/jsp_task/task.jsp").forward(request, response);
	}
}
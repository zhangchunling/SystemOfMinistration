package com.zrgk.task.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.task.service.impl.TaskServiceImpl;

/**
 * @function: 任务管理servlet层的更新所有任务信息——UpdateTaskServlet.java
 * @author: 刘淼
 * @time: 2015-6-8
 * */
public class UpdateByTidTaskServlet extends HttpServlet{
	
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
		
		
		
		
		String tid = request.getParameter("tid");
		
		
		System.out.println(tid);
		Task task=new Task();//实例化Task实体类
		
		if (tid!=null) {
			task.setTid(Integer.parseInt(tid));
			
			taskService.updateStartTask(task);
			
			
			request.getRequestDispatcher("taskServlet").forward(request, response);
		}
	}
}
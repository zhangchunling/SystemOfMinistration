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
 * @function: 任务管理servlet层的删除任务信息——deleteTaskServlet.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public class DeleteTaskServlet extends HttpServlet{
	
	TaskServiceInter taskService = new TaskServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//设置request、response的编码格式 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		//获取id
		String id =request.getParameter("id");
		//实例化Task
		Task task=new Task();
		
		String[] idArr=id.split(",");
		for (int i = 0; i < idArr.length; i++) {
			task.setTid(Integer.parseInt(idArr[i]));
			taskService.deleteTask(task );		
			System.out.println("22222222");
		}
		 
		//调转页面并回写信息
		request.getRequestDispatcher("taskServlet").forward(request, response);		
	}	
}
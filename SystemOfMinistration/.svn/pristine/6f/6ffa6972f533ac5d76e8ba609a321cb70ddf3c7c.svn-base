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
 * @function: 任务管理servlet层的查询所有任务信息——QueryAllTasksServlet.java
 * @author: 刘淼
 * @time: 2015-6-7
 * */
public class QueryAllTasksServlet extends HttpServlet{
	
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
		
		Task task=new Task();//实例化Task实体类
		taskService.queryAllTasks(task);
		request.setAttribute("task", task);
				
		//分页要用到的信息 得到jsp页传过来的当前页
		/*String currentPage=request.getParameter("currentPage");
		if(currentPage!=null&&!"".equals(currentPage.trim())){
			u.setCurrentPage(Integer.parseInt(currentPage));
		}*/
		
		//request.setAttribute("currentPage", u.getCurrentPage());
		//request.setAttribute("totalSize", usersService.totalSize(u));
		/*u.setTotalSize(TaskService.totalSize(u));
		request.setAttribute("user", u);*/
		
		/*request.setAttribute("list", TaskService.queryUsers(u));*/
			
		request.getRequestDispatcher("jsp/jsp_task/task.jsp").forward(request, response);
	}
}

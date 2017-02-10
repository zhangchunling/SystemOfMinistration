package com.zrgk.task.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.task.model.Employee;
import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.task.service.impl.TaskServiceImpl;

/**
 * @function: 任务管理servlet层——>主页面的查询
 * @author: 刘淼
 * @time: 2015-6-9
 * */
public class TaskServlet extends HttpServlet {

	
	TaskServiceInter taskService = new TaskServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置request、response的编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 实例化service接口
		TaskServiceInter task = new TaskServiceImpl();
		Task t = new Task();

		// 得到页面点搜索时提交表单的参数（查询条件、关键字、排序）
		String keyword = request.getParameter("keyword");
		String orderby = request.getParameter("orderby");
		 String currentPage=request.getParameter("currentPage");
		 
		 
		 
		System.out.println("keyword="+keyword);
		HttpSession session = request.getSession();
		
		session.setAttribute("key", keyword);
		 
		// 建立session

		// 点搜索时走的if：当页面有参数传来时， 赋进session
		if (keyword != null && !"".equals(keyword.trim())) {
			t.setPlanOption(keyword); // 关键字的session没值的时侯，为其赋值
			/*t.setExecutor(Integer.parseInt(keyword));
			t.setStatus(Integer.parseInt(keyword));*/
		}

		// 点搜索时，如果排序值为0,则不需要给javabean的排序属性赋值
		if (orderby != null && !"".equals(orderby.trim())) {
			t.setBeginTime(orderby);
		}	
		 

		// 分页信息
		  // 得到jsp页传过来的当前页数
		if (currentPage != null && !"".equals(currentPage.trim())) {
			t.setCurrentPage(Integer.parseInt(currentPage)); // 将得到的当前页数封装到对象t里
		}
		// 调用返回总数据条数方法，并封装到t对象里，只有一封装，就会在Page类里计算出总页数，调用查询方法时再用
		request.setAttribute("task", t);
		
		
		
		t.setTotalSize(task.totalSize(t));
		System.out.println("总条数="+task.totalSize(t));
		
		
		
		request.setAttribute("task", t);
		List<Task> list =task.queryAllTasks(t);
		if (list!=null) {
			
			
			List<Employee> lists =taskService.queryAllEmployee();
			 
			request.setAttribute("name", lists);
			
			
			// 查回所有数据
			request.setAttribute("list", list);
			
			// 将封装有总页数、当前页数的task赋给request，当跳到jsp查询页面时，可取当前页数等等			
			request.getRequestDispatcher("jsp/jsp_task/task.jsp").forward(request,
					response);
		}		
	}
}
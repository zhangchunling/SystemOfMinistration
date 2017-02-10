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
public class UpdateTaskServlet extends HttpServlet {

	TaskServiceInter taskService = new TaskServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 设置request的编码格式
		response.setContentType("text/html;charset=utf-8");// 设置response的编码格式

		String pid = request.getParameter("pid");// 参考位置第一级id
		String nid = request.getParameter("nid");// 参考位置第二级id

		// 输出任务表的id
		String tid = request.getParameter("tid");// 参考位置第二级id

		int status = 1;

		System.out.println("pid=" + pid);

		System.out.println("nid=" + nid);
		// 任务表的name
		String planOption = request.getParameter("planOption");
		System.out.println("planOption=" + planOption);

		String beginTime = request.getParameter("beginTime");
		System.out.println("beginTime=" + beginTime);

		String endTime = request.getParameter("endTime");
		System.out.println("endTime=" + endTime);

		String executor = request.getParameter("executor");
		System.out.println("executor=" + executor);

		String grade = request.getParameter("grade");
		System.out.println("grade=" + grade);

		String detailExplain = request.getParameter("detailExplain");
		System.out.println("detailExplain=" + detailExplain);

		// 实例化任务表
		Task task = new Task();
		task.setReferenceSite(pid + "," + nid);// 连接第一级与第二级的id并用逗号分隔输出
		task.setPlanOption(planOption);
		task.setBeginTime(beginTime);
		task.setEndTime(endTime);
		if (executor != null) {

			task.setExecutor(Integer.parseInt(executor));
		}
		if (grade != null) {

			task.setGrade(Integer.parseInt(grade));
		}
		task.setDetailExplain(detailExplain);
		task.setStatus(status);
		if (tid != null) {

			task.setTid(Integer.parseInt(tid));
		}

		// 调转页面并回写信息
		if (task != null) {

			taskService.updateTask(task);
			request.getRequestDispatcher("taskServlet").forward(request,
					response);
		}
	}
}
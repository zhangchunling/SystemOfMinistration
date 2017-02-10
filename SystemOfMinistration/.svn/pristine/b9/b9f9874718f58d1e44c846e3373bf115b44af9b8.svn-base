package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
/**
 * 
 * @function: 基本信息管理-->查看详情的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Basic_LookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获得数据库所有信息，并赋进request
		int id=Integer.parseInt(request.getParameter("id"));
		Basicer ba=new Basicer();
		BasicerServiceInter basicerService=new BasicerServiceImpl();
		ba=basicerService.queryBasicerById(id);
		request.setAttribute("basicer", ba);
		request.getRequestDispatcher("jsp/jsp_project/project-base-look.jsp").forward(request, response);
	}
	
}

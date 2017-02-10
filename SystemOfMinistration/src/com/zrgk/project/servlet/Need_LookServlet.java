package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;
/**
 * 
 * @function: 基本信息管理-->查看详情的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Need_LookServlet extends HttpServlet{

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
		
		//获得页面传来的id
		int id=Integer.parseInt(request.getParameter("id"));
		
		//根据传来的id去找project_id
		Needer ne=new Needer();
		NeederServiceInter neederService=new NeederServiceImpl();
		ne=neederService.queryNeederById(id);
		int proId=ne.getProject_id();
		
		//根据获得的project_id去查项目名称
		Basicer ba=new Basicer();
		BasicerServiceInter baserv=new BasicerServiceImpl();
		ba=baserv.queryBasicerById(proId);
		String name=ba.getProjectName();
		
		//将项目名称赋给ne
		ne.setProName(name);
		
		request.setAttribute("needer", ne);
		request.getRequestDispatcher("jsp/jsp_project/project-need-look.jsp").forward(request, response);
	}
	
}
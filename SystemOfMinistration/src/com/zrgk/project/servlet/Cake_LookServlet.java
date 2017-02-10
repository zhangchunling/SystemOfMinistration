package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Caker;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.CakeServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.project.service.impl.CakerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;
/**
 * 
 * @function: 基本信息管理-->查看详情的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Cake_LookServlet extends HttpServlet{

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
		int id=Integer.parseInt(request.getParameter("cid"));
		//根据传来的id去找need_id
		Caker caker=new Caker();
		CakeServiceInter CakeService=new CakerServiceImpl();
		caker=CakeService.queryCakerById(id);
		int needId=caker.getNeed_id();
		
		//根据need_id去查project_id
		Needer needer=new Needer();
		NeederServiceInter neederService=new NeederServiceImpl();
		needer=neederService.queryNeederById(needId);
		int project_id=needer.getProject_id();	
		//将需求标题赋给caker
		caker.setNeedName(needer.getPtitle());
		
		//根据获得的project_id去查项目名称
		Basicer ba=new Basicer();
		BasicerServiceInter baserv=new BasicerServiceImpl();
		ba=baserv.queryBasicerById(project_id);
		String name=ba.getProjectName();		
		//将项目名称赋给caker
		caker.setProName(name);
		System.out.println(caker.getCakeName());
		System.out.println(caker.getProName());
		System.out.println(caker.getNeedName());
		
		request.setAttribute("caker", caker);
		request.getRequestDispatcher("jsp/jsp_project/project-model-look.jsp").forward(request, response);
	}
	
}

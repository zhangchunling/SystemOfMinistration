package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Caker;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.CakeServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.CakerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;

public class Cake_EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		//1.处理回写
		String cid=request.getParameter("cid");		//得到主页面点编辑时传来的参数,都变成字符串
		CakeServiceInter cakerService=new CakerServiceImpl();
		Caker cakerEdit=new Caker();
		int cidNum=1000;//赋初值
		if(cid!=null&&!"".equals(cid)){
			cidNum=Integer.parseInt(cid);					//解析得到模块的id					
		}
		
		cakerEdit=cakerService.queryCakerById(cidNum);	//通过传来的Id得到Caker对象	
		Needer neederEdit=new Needer();
		NeederServiceInter needeService=new NeederServiceImpl();
		int need_id=cakerEdit.getNeed_id();					//得到need_id
		neederEdit=needeService.queryNeederById(need_id);	//通过need_id得到Needer对象
		int pid=neederEdit.getProject_id();					//通过Needer对象得到项目id
		
		request.setAttribute("projectId",pid);				//将项目id存进request	
		request.setAttribute("caker",cakerEdit);			//将Caker对象存进request
		
		request.getRequestDispatcher("jsp/jsp_project/project-model-edit.jsp").forward(request, response);
	}
}

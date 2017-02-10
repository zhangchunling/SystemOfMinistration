package com.zrgk.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * @function: 模块管理——>获取项目的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Cake_ChoiceServlet extends HttpServlet{

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
		
		//初始化模块
		List<Caker> list=new ArrayList<Caker>();
		Caker cake=new Caker();
		CakeServiceInter cakes=new CakerServiceImpl();
		list=cakes.queryAllCaker(cake);
		
		//初始化项目
		Basicer basic=new Basicer();
		BasicerServiceInter bass=new BasicerServiceImpl();
		
		//初始化需求
		Needer need=new Needer();
		NeederServiceInter needs=new NeederServiceImpl();
		
		//遍历并赋值		
		for(Caker ne:list){
			int nid=ne.getNeed_id();
			need=needs.queryNeederById(nid);
			ne.setNeedName(need.getPtitle());		//将需求名称，并赋进Caker的javabean属性（需求名称）里
			int pid=need.getProject_id();
			basic=bass.queryBasicerById(pid);
			ne.setProName(basic.getProjectName());	//获得项目名称，并赋进Caker的javabean属性（项目名称）里
			
		}
		
		//存进request
		request.setAttribute("list",list);
		request.getRequestDispatcher("/jsp/jsp_project/project-cake-add.jsp").forward(request, response);//跳转
		
	}
	
}

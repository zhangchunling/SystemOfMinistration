package com.zrgk.task.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @function: 任务管理servlet层对参考位置的jquery异步——JqueryServlet.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public class JqueryServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置request、response的编码格式 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		PrintWriter out=response.getWriter();//得到流的对象 
		
		//task_add.jsp页面的参考位置第一级下拉框——调用基本信息表
		List<Basicer> list=new ArrayList<Basicer>();		
		//获得数据库所有信息，并赋进request
		BasicerServiceInter basic=new BasicerServiceImpl();
		list=basic.queryAllBasicer(null);		
			
		//1,XXXX项目;2,XXXX需求分析;3,账户管理模块4,添加账户功能
		StringBuffer sb=new StringBuffer("");
		for(Basicer b:list){

			sb.append(b.getPid()+","+b.getProjectName()+";");
		}
		System.out.println(sb.toString());
		out.print(sb.toString());
		out.close();
	}		
}
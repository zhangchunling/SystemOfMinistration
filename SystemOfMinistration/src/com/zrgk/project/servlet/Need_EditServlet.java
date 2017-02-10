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
 * @function: 基本信息管理-->编辑的servlet,主要是值的回写
 * @author: 张春玲
 * @time: 2015-6-7
 *
 */
public class Need_EditServlet extends HttpServlet{
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
		
		int id=Integer.parseInt((request.getParameter("id")));		//获取点编辑时传来的id		
		NeederServiceInter needService=new NeederServiceImpl();		//实例化对象
		Needer needer=new Needer();									//实例化Needer对象
		needer=needService.queryNeederById(id);						//通过接受的id查回数据
		int proId=needer.getProject_id();							//取出项目名称的id
		Basicer basicer=new Basicer();								//实例化Basicer
		BasicerServiceInter baser=new BasicerServiceImpl();			//实例化调用方法对象
		basicer=baser.queryBasicerById(proId);						//通过项目名称的id查回数据		
		request.setAttribute("needer", needer);						//将查回的数据放进request，用以回写
		request.setAttribute("basicer", basicer);
		request.getRequestDispatcher("jsp/jsp_project/project-need-edit.jsp").forward(request, response);//跳转到编辑页面
	}
}

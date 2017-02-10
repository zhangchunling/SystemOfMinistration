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
 * @function: 基本信息管理-->编辑的servlet,主要是值的回写
 * @author: 张春玲
 * @time: 2015-6-7
 *
 */
public class Basic_EditServlet extends HttpServlet{
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
		BasicerServiceInter basicService=new BasicerServiceImpl();	//实例化对象
		Basicer bas=basicService.queryBasicerById(id);				//通过id查回数据		
		request.setAttribute("basicer", bas);						//将查回的数据放进request，用以回写
		
		request.getRequestDispatcher("jsp/jsp_project/project-base-edit.jsp").forward(request, response);//跳转到编辑页面
	}
}

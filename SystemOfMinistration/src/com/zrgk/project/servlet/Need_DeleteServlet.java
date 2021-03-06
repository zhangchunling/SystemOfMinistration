package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.NeederServiceImpl;
/**
 * 
 * @function: 基本信息管理——>删除的servlet
 * @author: 张春玲
 * @time: 2015-6-9
 *
 */
public class Need_DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String string=request.getParameter("heidder");//得到页面隐藏域存的value的拼接字符串
		NeederServiceInter bs=new NeederServiceImpl();
		String[] ss=string.split(",");
		//循环解析，并删除
		if(ss!=null){
			for(String s:ss){
				int id=Integer.parseInt(s);
				bs.deleteNeeder(id);
			}
		}
		request.getRequestDispatcher("/needServlet.action").forward(request, response);
	}

}

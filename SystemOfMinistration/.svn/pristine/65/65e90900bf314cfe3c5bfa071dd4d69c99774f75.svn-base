package com.zrgk.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Needer;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;
/**
 * 
 * @function: 需求分析管理——>添加时获取项目名称的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Need_ChoiceServlet extends HttpServlet{

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
		
		//得到项目名称和id
		List<Basicer> list=new ArrayList<Basicer>();
		Basicer ba=new Basicer();
		BasicerServiceInter bass=new BasicerServiceImpl();
		
		list=bass.queryAllBasicer(null);
				
		//存进request
		request.setAttribute("list",list);
		request.getRequestDispatcher("/jsp/jsp_project/project-need-add.jsp").forward(request, response);//跳转
		
	}
	
}

package com.zrgk.project.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.myinfo.model.Employee;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.NeederServiceImpl;
/**
 * 
 * @function: 基本信息管理-->编辑后更新的servlet
 * @author: 张春玲
 * @time: 2015-6-7
 *
 */
public class Need_UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NeederServiceInter needService=new NeederServiceImpl();
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		//获取页面传来的参数
		String id = request.getParameter("sendid");
		String title  = request.getParameter("title");		
	 	String simple = request.getParameter("simple");
		String detail = request.getParameter("detail");
		String comment = request.getParameter("comment");
		
		//建立session，获得更新用户名		
		HttpSession session=request.getSession();
		Employee em=new Employee();
		em=(Employee) session.getAttribute("emplInfo");
		String updatePeople =em.getName();			
		//更新时间为当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String updateTime=sdf.format(new Date());
		
		//将页传来的参数组装进javabean实例对象
		Needer n=new Needer();
		n.setPid(Integer.parseInt(id));
		n.setPtitle(title);
		n.setSimpleStatement(simple);
		n.setDetail(detail);
		n.setComment(comment);
		n.setUpdatePeople(updatePeople);
		n.setUpdateTime(updateTime);
		//传参并调用插入方法		
		boolean flag=needService.updateNeeder(n);
		request.setAttribute("flag",flag);
		request.getRequestDispatcher("/needServlet.action").forward(request, response);
	}
}

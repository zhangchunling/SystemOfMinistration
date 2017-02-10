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
 * @function: 基本信息管理-->添加新项目的servlet
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class Need_InsertServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取从页面传来的参数，都是字符串
		String choice=request.getParameter("projectChoice");//select直接获得value值
		String title = request.getParameter("title");
		String simple  = request.getParameter("simple");		
		String detail = request.getParameter("detail");	
		String comment = request.getParameter("comment");	
		
		//建立session获取登录时存session里的用户名;添加时，添加人与更新人一致
		HttpSession session=request.getSession();
		Employee employee=new Employee();
		employee = (Employee) session.getAttribute("emplInfo");
		String updatePeople = employee.getName();
		String addPeople = updatePeople;		
		
		//获取当前时间; 添加项目时，更新时间与添加时间一致	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String addTime=sdf.format(new Date());
		String updateTime=addTime;
		
		//将页传来的参数组装进javabean实例对象
		Needer bas=new Needer();		
		bas.setPtitle(title);
		bas.setProject_id(Integer.parseInt(choice));//
		bas.setCreateTime(addTime);
		bas.setUpdateTime(updateTime);
		bas.setSimpleStatement(simple);
		bas.setDetail(detail);
		bas.setComment(comment);
		bas.setUpdatePeople(updatePeople);
		bas.setAddPeople(addPeople);
		//传参并调用插入方法
		NeederServiceInter needService=new NeederServiceImpl();
		boolean flag = needService.insertNeeder(bas);
		
		//保存后跳回主页面,并提醒是否添加成功
		request.setAttribute("flag", flag);		
		request.getRequestDispatcher("/needServlet.action").forward(request, response);
	}
}

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
import com.zrgk.project.model.Basicer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
/**
 * 
 * @function: 基本信息管理-->编辑后更新的servlet
 * @author: 张春玲
 * @time: 2015-6-7
 *
 */
public class Basic_UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicerServiceInter basicService=new BasicerServiceImpl();
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		//获取页面传来的参数
		int id=Integer.parseInt(request.getParameter("name"));
		String projectName  = request.getParameter("projectName");		
	 	String customerName = request.getParameter("customerName");
		String personInCharge = request.getParameter("personInCharge");
		String manager = request.getParameter("manager");
		String persons = request.getParameter("persons");
		String startTime = request.getParameter("startTime");
		String relstartTime = request.getParameter("relstartTime");
		String cost = request.getParameter("cost");
		String level = request.getParameter("level");
		String completeTime = request.getParameter("completeTime");
		String comment = request.getParameter("comment");
		
		//建立session获取用户名
		HttpSession session=request.getSession();
		Employee em=new Employee();
		em=(Employee) session.getAttribute("emplInfo");
		String updatePeople =em.getName();
		//获取当前时间，赋给更新时间	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");				
		String updateTime=sdf.format(new Date());	
		System.out.println(updatePeople+"..");
		
		//将页传来的参数组装进javabean实例对象
		Basicer ba=new Basicer();
		ba.setPid(id);		
		ba.setProjectName(projectName);
		ba.setCustomerName(customerName);
		ba.setPersonInCharge(personInCharge);
		ba.setManager(manager);
		ba.setPersons(Integer.parseInt(persons));		
		ba.setStartTime(startTime);
		ba.setRelstartTime(relstartTime);
		ba.setCost(Double.parseDouble(cost));
		ba.setLevel(Integer.parseInt(level));		
		ba.setCompleteTime(completeTime);
		ba.setComment(comment);
		ba.setUpdatePeople(updatePeople);		
		ba.setUpdateTime(updateTime);
		
		//传参并调用插入方法		
		boolean flag=basicService.updateBasicer(ba);
		
		//flag用于后面提醒是否成功用
		request.setAttribute("flag",flag);
		request.getRequestDispatcher("/basicServlet.action").forward(request, response);
		
	}
}

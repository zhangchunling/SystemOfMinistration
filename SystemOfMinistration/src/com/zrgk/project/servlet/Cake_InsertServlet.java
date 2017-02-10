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
import com.zrgk.project.model.Caker;
import com.zrgk.project.service.CakeServiceInter;
import com.zrgk.project.service.impl.CakerServiceImpl;
/**
 * 
 * @function: 基本信息管理-->添加新项目的servlet
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class Cake_InsertServlet extends HttpServlet{
	
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
		String need_id=request.getParameter("needName");		//需求id
		String cakeName = request.getParameter("cakeName");		//模块名称
		String priority=request.getParameter("priority");		//优先级
		String simple  = request.getParameter("simple");		//简单描述
		String detail = request.getParameter("detail");			//详细描述
		String comment = request.getParameter("comment");		//备注
		
		//建立session获取用户名，添加模块时，添加人与修改人为一个人
		HttpSession session = request.getSession();
		Employee em=new Employee();
		em=(Employee) session.getAttribute("emplInfo");
		String updatePeople = em.getName();
		String addPeople = updatePeople;		
		
		//获取当前时间;添加项目时，更新时间与添加时间一致	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String addTime=sdf.format(new Date());
		String updateTime=addTime;
		
		//将页传来的参数组装进javabean实例对象
		Caker bas=new Caker();		
		bas.setCakeName(cakeName);
		if(need_id!=null){
			bas.setNeed_id(Integer.parseInt(need_id));
		}
		if(priority!=null){
			bas.setPriority(Integer.parseInt(priority));
		}		
		bas.setCreateTime(addTime);
		bas.setUpdateTime(updateTime);
		bas.setSimpleStatement(simple);
		bas.setDetail(detail);
		bas.setComment(comment);
		bas.setUpdatePeople(updatePeople);
		bas.setAddPeople(addPeople);
		//传参并调用插入方法
		CakeServiceInter needService=new CakerServiceImpl();
		boolean flag = needService.insertCaker(bas);
		//保存后跳回主页面,并提醒是否添加成功
		request.setAttribute("flag", flag);		
		request.getRequestDispatcher("/cakeServlet.action").forward(request, response);
	}
}
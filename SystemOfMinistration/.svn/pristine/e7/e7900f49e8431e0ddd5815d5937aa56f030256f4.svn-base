package com.zrgk.clientinfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.clientinfo.model.Customers;
import com.zrgk.clientinfo.service.UsersServiceInter;
import com.zrgk.clientinfo.service.impl.UsersServiceImpl;


/**
 * 查询用户的servlet
 * @author Simone
 * 2015-06-07
 */ 
public class QueryUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 2835541138658115543L;
	
	UsersServiceInter usersService=new UsersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置request的编码格式 
		response.setContentType("text/html;charset=utf-8");//设置response的编码格式 
		Customers u=new Customers();
		HttpSession session=request.getSession();
		
		String fla=request.getParameter("fla");
		String type=request.getParameter("type");
		String keyWord=request.getParameter("keyword");
		String addTime=request.getParameter("time");//获得时间排序的类
		
		if(fla!=null&&"1".equals(fla)){
			session.setAttribute("type", type);
			session.setAttribute("keyWord", keyWord);
			session.setAttribute("addTime", addTime);
		}
		if(session.getAttribute("type")!=null){
			String ty=(String)session.getAttribute("type");
			String ke=(String)session.getAttribute("keyWord");
				if(session.getAttribute("keyWord")!=null&&"1".equals(ty))
					u.setCompanyName(ke);
				if(session.getAttribute("keyWord")!=null&&"2".equals(ty))
					u.setCustomerName(ke);
		}
	
		if(u!=null){
			if(session.getAttribute("addTime")!=null){
				u.setAddTime((String)session.getAttribute("addTime"));
			}
		}
		
		
		
		//分页要用到的信息 得到jsp页传过来的当前页  
		String currentPage=request.getParameter("currentPage");
		if(currentPage!=null&&!"".equals(currentPage.trim())){
			u.setCurrentPage(Integer.parseInt(currentPage));
		}
		if(u!=null){
			u.setTotalSize(usersService.totalSize(u));
			request.setAttribute("user", u);
		}
		request.setAttribute("list", usersService.queryUsers(u));
		request.getRequestDispatcher("jsp/jsp_clientinfo/customer.jsp").forward(request, response);
	}
}

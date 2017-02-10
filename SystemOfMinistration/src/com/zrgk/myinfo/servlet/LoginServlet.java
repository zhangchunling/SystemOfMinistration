package com.zrgk.myinfo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.myinfo.model.Employee;
import com.zrgk.myinfo.service.LoginServiceInter;
import com.zrgk.myinfo.service.impl.LoginServiceImpl;
import com.zrgk.purview.model.Menu;
/**
 * 用户登录的servlet
 * @author samson
 * 2015-06-08
 */
//通过继承HttpServlet将这个普通类变成servlet类
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = -5298352424319351232L;
	//实例化service
	LoginServiceInter pro=new LoginServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//设置request的编码格式
				request.setCharacterEncoding("utf-8");
				//设置response编码格式
				response.setContentType("text/html;charset=utf-8");
				
				String username=request.getParameter("username");//用户名
				String password=request.getParameter("password");//密码
				String getkey=request.getParameter("key");//得到用户输入的验证码
				String currentKey=String.valueOf(request.getSession().getAttribute("randomString"));
				//校验用户输入的验证码是否正确 不区分大小写
				if(!currentKey.equalsIgnoreCase(getkey)){
					request.setAttribute("msg", "验证码不正确！");
					request.getRequestDispatcher("jsp/else/login.jsp").forward(request, response);
				}else{
					
				Employee emp=new Employee();
				emp.setUsername(username);
				emp.setPassword(password);
				Employee empl=pro.login(emp);
				if(empl==null){
					request.setAttribute("msg", "用户名或密码错误！");
					request.getRequestDispatcher("jsp/else/login.jsp").forward(request, response);
				}else{
				request.setAttribute("msg", "登录成功！");
				//用session来存用户相关信息
				//得到session  实例化session
				HttpSession session=request.getSession();
				//使用session
				session.setAttribute("emplInfo", empl);
				
				//根据eid查询menu菜单表
				List<Menu> list=new ArrayList<Menu>();
				list=pro.listMenuByEid(empl.getEid());
				session.setAttribute("menulist", list);
				
				
				
				//session.setAttribute("menuList", list);
				request.getRequestDispatcher("jsp/else/index.jsp").forward(request, response);
				}
			}
	
	}
	
}

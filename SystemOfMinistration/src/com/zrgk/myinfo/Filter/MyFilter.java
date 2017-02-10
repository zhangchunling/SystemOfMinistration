package com.zrgk.myinfo.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zrgk.myinfo.model.Employee;

/**
 * 我的过滤器 实现的是非法登录
 * @author samson
 * 2015-06-09
 */
public class MyFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//把ServletRequest转成HttpServletRequst以方便使用
		HttpServletRequest req=(HttpServletRequest)request;
		req.setCharacterEncoding("utf-8");//处理request请求的编码格式
		String path=req.getContextPath();
		
		//实现非法登陆
		HttpSession session=req.getSession();
		Employee empl=(Employee)session.getAttribute("emplInfo");//得到用户登录后session里存的用户信息
		if(empl==null){
			//如果额empl是空就跳转到登录页面去
			req.getRequestDispatcher("jsp/else/login.jsp").forward(request, response);
		}else{
			//过滤器放行到servlet的方法
			chain.doFilter(request, response);	
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}

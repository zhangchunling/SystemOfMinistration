package com.zrgk.task.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JqueryServlet4 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置request、response的编码格式 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		PrintWriter out=response.getWriter();//得到流的对象 								
		
		/*//task_add.jsp页面的参考位置第四级下拉框——调用功能表
		List<functioner> list3=new ArrayList<functioner>();
		//获得数据库所有信息，并赋进request
		functionerServiceInter function=new functionerServiceImpl();
		list3=function.queryAllFunction();	*/
		
		//1,XXXX项目;2,XXXX需求分析;3,账户管理模块4,添加账户功能
		StringBuffer sb=new StringBuffer("");
		
	/*	for(functioner f:list3){
		//组装取到的数据					
		sb.append(+f.getFid()+","+f.getFunctionName()+";");
		
		}
				
		System.out.println(sb.toString());
		out.print(sb.toString());
		out.close();*/
	}
}
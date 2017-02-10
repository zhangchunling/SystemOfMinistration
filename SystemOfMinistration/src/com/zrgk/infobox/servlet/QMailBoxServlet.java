package com.zrgk.infobox.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.infobox.model.MailBox;
import com.zrgk.infobox.service.MailBoxServiceInter;
import com.zrgk.infobox.service.impl.MailBoxServiceImpl;

/**
 *查询数据库表里收件箱的所有的内容servlet 查询类(分页)
 * @author 樊丙富
 *2015-06-06
 */
public class QMailBoxServlet extends HttpServlet {

			MailBoxServiceInter mailBoxservice=new MailBoxServiceImpl();	//实例化
		
		@Override//doget方法
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request ,response);//必须经过doPost这个方法

		}

		@Override//dopost方法
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
			
					request.setCharacterEncoding("utf-8");//返回值代码处理 (页面显示代码处理和数据库写入代码处理)
					response.setContentType("text/html;charset=utf-8");
			
			String title=request.getParameter("title");//传递按照要求查询
			
			if(title!=null&&title!=""){//处理模糊查询的时候回写的乱码问题
				title=new String(title.getBytes("iso8859-1"),"utf-8");	
			}
			MailBox   mailBox=new  MailBox();
			//判断数据的几种情况
			if(title!=null&&!"".equals(title.trim())){
			mailBox.setTitle(title);//判断不为空 不为“”不为空格继续
				//request.setAttribute("title", title);//根据条件查询的
			}
			
			String time=request.getParameter("time");//获得时间排序的类
			mailBox.setTime(time);
			
			//System.out.println(time);
			//分页用到的信息  得到jsp传过来的当前页
			String currentPage=request.getParameter("currentPage");
			if(currentPage!=null&&!"".equals(currentPage.trim())){
				mailBox.setCurrentPage(Integer.parseInt(currentPage));
		}
		
			//request.setAttribute("currentPage", u.getCurrentPage());
					//request.setAttribute("totalSize", usersService.totalSize(u));
			mailBox.setTotalSize(mailBoxservice.totalSize(mailBox));
			request.setAttribute("mailBox",mailBox);
			
			mailBox.setAdressee(67);
			
			request.setAttribute("list", mailBoxservice.queryMailBox(mailBox));//传输调用值
			
			request.getRequestDispatcher("jsp/jsp_mailbox/message_give.jsp").forward(request, response);
			}
		
			}



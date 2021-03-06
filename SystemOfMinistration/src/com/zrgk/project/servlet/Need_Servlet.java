package com.zrgk.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.project.model.Needer;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.NeederServiceImpl;

/**
 * 
 * @function: 需求信息管理-->主页面的查询的servlet
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public class Need_Servlet extends HttpServlet{
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
		
		//实例化
		NeederServiceInter basic=new NeederServiceImpl();
		Needer needer=new Needer();
				
		//得到页面点搜索时提交表单的参数（查询条件、关键字、排序）
		String condition=request.getParameter("needConditon");
		String keyword=request.getParameter("keyword");
		String orderby=request.getParameter("orderby");
		
		//【获取标记】，该标记用于判断空是否从提交搜索表单传来
		String keyhid=request.getParameter("keyhid");
		
		//建立session
		HttpSession session=request.getSession();
		
		//点搜索时走的if：当页面有参数传来时，	赋进session	
		if(keyword!=null&&!"".equals(keyword.trim())){					
			session.setAttribute("key", keyword);	//session没值的时侯赋				
		}
		//当点搜索时，传来的关键字为空时，去掉session里的值
		if(keyhid!=null&&Integer.parseInt(keyhid)==1&&"".equals(keyword.trim())){
			session.removeAttribute("key");
		}
		
		//点搜索时，如果传来参数为0,说明没有给定搜索条件，那么将不用给项目名称赋值
		if(condition!=null&&Integer.parseInt(condition)==0){
			session.setAttribute("needConditon",  Integer.parseInt(condition));
		}
		//为1时是项目名称属性赋值
		if(condition!=null&&Integer.parseInt(condition)==1){			
			needer.setProName(keyword);		
			session.setAttribute("needConditon",  Integer.parseInt(condition));			
		}	
		//为2时是标题属性赋值
		if(condition!=null&&Integer.parseInt(condition)==2){			
			needer.setPtitle(keyword);		
			session.setAttribute("needConditon",  Integer.parseInt(condition));			
		}
		
		//点搜索时，如果排序值为0,则不需要给javabean的排序属性赋值
		if(orderby!=null&&Integer.parseInt(orderby)==0){	
			session.setAttribute("order",  Integer.parseInt(orderby));	//session没值的时侯赋值			
		}
		//点搜索时，如果排序不为0，则需要给javabean的排序属性赋值
		if(orderby!=null&&Integer.parseInt(orderby)!=0){			
			needer.setOrder(Integer.parseInt(orderby));		
			session.setAttribute("order",  Integer.parseInt(orderby));			
		}			
		
		//获取点击分页时传来的参数：那里的参数只有在搜索之后传的，如果没有搜索，只为空,完后也要回写
		String condi=request.getParameter("acon");
		String key=request.getParameter("akey");
		String ord=request.getParameter("aorder");
		
		//点分页走的if:得到链接传来的参数（查询条件），用于按参数查询
		if(key!=null&&!"".equals(key.trim())){
			key=new String(key.getBytes("iso8859-1"),"utf-8");			//处理页面链接传来的参数乱码的问题 
		}
		if(condi!=null&&""!=condi.trim()&&Integer.parseInt(condi)==1){	//有值时，才赋javabean及回写
			needer.setProName(key);										//项目名称关键字
		}
		if(condi!=null&&""!=condi.trim()&&Integer.parseInt(condi)==2){
			needer.setPtitle(key);										//标题关键字	
		}
		if(ord!=null&&""!=ord.trim()){
			needer.setOrder(Integer.parseInt(ord));
		}
		
		//分页信息 
		String currentPage=request.getParameter("currentPage");			//得到jsp页传过来的当前页数
		if(currentPage!=null&&!"".equals(currentPage.trim())){
			needer.setCurrentPage(Integer.parseInt(currentPage));		//将得到的当前页数封装到对象u里
		}		
		needer.setTotalSize(basic.totalSize(needer));	//调用返回总数据条数方法，并封装到u对象里，只有一封装，就会在Page类里计算出总页数，调用查询方法时再用
		request.setAttribute("needer", needer);			//将封装有总页数、当前页数的user赋给request，当跳到jsp查询页面时，可取当前页数等等		
		
		request.setAttribute("list", basic.queryAllNeeder(needer));		//查回所有数据

		request.getRequestDispatcher("/jsp/jsp_project/project-need.jsp").forward(request, response);
	}

}

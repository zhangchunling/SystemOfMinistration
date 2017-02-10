package com.zrgk.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;

/**
 * 
 * @function: 异步获得点添加时后，添加页面下拉框应出现的选项;
 * @author: 张春玲
 * @time: 2015-6-14
 *
 */
public class Cake_JaxaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("parentId");//得到页面传来的参数
		if(id!=null&&!"".equals(id)&&Integer.parseInt(id)==0){//得回第一级数据
			//得到项目名称和id
			List<Basicer> listbasicer=new ArrayList<Basicer>();
			BasicerServiceInter bass=new BasicerServiceImpl();		
			listbasicer=bass.queryAllBasicer(null);//获得所有基本信息数据
			
			//按逗分拼接成一维字符串，用分号拼接成二维字符串。之所以要拼接字符串，是因为异步时得到的只能是字符串
			StringBuffer sb=new StringBuffer("");
			for(Basicer b:listbasicer){
				sb.append(b.getPid()+","+b.getProjectName()+";");
			}
			PrintWriter out=response.getWriter();
			out.print(sb.toString());
			out.close();//一定要关闭
			
		}else{
			//得到jsp页面的异步里的data后面的参数（id值），通过传来的id去查回数据								
			List<Needer> list=new ArrayList<Needer>();					
			NeederServiceInter neederService=new NeederServiceImpl();	
			if(id!=null&&!"".equals(id.trim())){
				list=neederService.queryByPojectId(Integer.parseInt(id));//通过父id查回数据，该方法在Needer的实现类里
			}
			
			//按逗号拼接成一维字符串，按分号拼接成二维字符串
			StringBuffer sb=new StringBuffer("");
			for(Needer needer:list){
				sb.append(needer.getPid()+","+ needer.getPtitle()+";");
			}
			
			//得到流对象，并将上面的拼接字符串放入输出流，异步时获取
			PrintWriter out=response.getWriter();
			out.print(sb.toString());
			out.close();//一定要关闭
			
		}		
		
	}
}
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
import com.zrgk.project.model.Caker;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.CakeServiceInter;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.project.service.impl.CakerServiceImpl;
import com.zrgk.project.service.impl.NeederServiceImpl;

public class Cake_AjaxEditServlet extends HttpServlet{
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
		
		//2.处理异步
		String str=request.getParameter("parentId");//得到编辑页面传来的参数
		if(str!=null&&!"".equals(str)&&Integer.parseInt(str)==0){
			//得到项目名称和id
			List<Basicer> listbasicer=new ArrayList<Basicer>();
			BasicerServiceInter bass=new BasicerServiceImpl();		
			listbasicer=bass.queryAllBasicer(null);//获得所有基本信息数据
			
			//按逗号拼接成一维字符串，用分号拼接成二维字符串。之所以要拼接字符串，是因为异步时得到的只能是字符串
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
			if(str!=null&&!"".equals(str.trim())){
				list=neederService.queryByPojectId(Integer.parseInt(str));
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

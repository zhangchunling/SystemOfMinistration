package com.zrgk.project.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Needer;
import com.zrgk.project.service.NeederServiceInter;
import com.zrgk.project.service.impl.NeederServiceImpl;
import com.zrgk.utils.ExportExcel;
/**
 * 
 * @function: 导出无图片的Excel的servlet，注意的是：重写的是service方法
 * @author: 张春玲
 * @time: 2015-6-12
 *
 */

public class Need_ExportExcelServlet extends javax.servlet.http.HttpServlet {
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	NeederServiceInter needService=new NeederServiceImpl();//创建service层的对象，后面调用方法
    	
    	 //1. 设置消息头：设置了才会有下载弹出框选择存储导出的Excel存储位置
    	response.setContentType("text/html;charset=utf-8");
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition", "attachment;filename=need.xls");
        
        //2.实例化导excel共用类（该类在util包里，可当成工具类）
        ExportExcel<Needer> ex = new ExportExcel<Needer>();
        //声明一个数组  里面数据是设置导出的excel头部分（列名）
        String[] headers = { "序号", "项目id", "添加时间","更新时间","标题",
        		"简单描述","详细描述","备注","创建人","更新人","项目名称","排序条件"};
    	
        
        //3.声明一个list用来装从数据库查询来的所有商品信息
        NeederServiceInter neederService=new NeederServiceImpl();
        List<Needer> dataset = new ArrayList<Needer>();
        String str=request.getParameter("sign");
        if(str!=null&&!"".equals(str)){
        	String[] ArrayOne=str.split(",");
        	if(ArrayOne!=null){
        		for(String s:ArrayOne){
        			int id=Integer.parseInt(s);
        			Needer needer=new Needer();
        			needer=neederService.queryNeederById(id);
        			dataset.add(needer);
        		}
        	}
        }
        
        OutputStream out = response.getOutputStream();//将response里的响应的内容放进输出流
        ex.exportExcel(headers, dataset, out);//将头部分，信息集合,输出流都导进表里
        out.close();
    	
   }
}

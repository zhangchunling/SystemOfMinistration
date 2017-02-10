package com.zrgk.clientinfo.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.clientinfo.model.Customers;
import com.zrgk.clientinfo.service.UsersServiceInter;
import com.zrgk.clientinfo.service.impl.UsersServiceImpl;
import com.zrgk.utils.ExportExcel;

/**
 * 导出Excel
 * @author Simone
 *
 */
public class ExcelServlet extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 7433376226866905100L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersServiceInter usersService=new UsersServiceImpl();
    	 
		// 设置消息头
    	response.setContentType("text/html;charset=utf-8");
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition", "attachment;filename=customers.xls");//设置Excel
        ExportExcel<Customers> cu = new ExportExcel<Customers>();//实例化导excel的公用类
        //声明一个数组  里面数据是设置导出的excel头部分
        String[] headers = { "序号", "联系人姓名", "公司名称", "添加时间", "联系电话","公司地址", "座机", "公司简介","备注" };
       
        //声明一个list用来装从数据库查询来的商品信息
        List<Customers> li= new ArrayList<Customers>();
       // dataset=usersService.queryCustomers(null);//调用数据的查询
        
        String hidd=request.getParameter("hidd");
		String[] Array=hidd.split(",");
		
		for (int i = 0; i < Array.length; i++) {
			int e=Integer.parseInt(Array[i]);
			Customers user=usersService.queryUsersByCid(e);
			li.add(user);
		}
        OutputStream out = response.getOutputStream();//以流的形式输出
        cu.exportExcel(headers, li, out);
        out.close();
    }
	
}

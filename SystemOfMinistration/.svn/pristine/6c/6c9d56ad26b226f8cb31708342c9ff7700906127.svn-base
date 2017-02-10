package com.zrgk.task.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.task.service.impl.TaskServiceImpl;
import com.zrgk.utils.ExportExcel;

/**
 * 
 * @function: 导出任务表Excel的servlet（注意的是：重写的是service方法）
 * @author:   刘淼
 * @time:     2015-6-13
 *
 */
public class TaskExcelServlet extends javax.servlet.http.HttpServlet {
	
	 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
	    	TaskServiceInter taskService=new TaskServiceImpl();//创建service层的对象，后面调用方法
	    	
	    	 //1. 设置消息头：设置了才会有下载弹出框选择存储导出的Excel存储位置
	    	response.setContentType("text/html;charset=utf-8");
	        response.setContentType("octets/stream");
	        response.addHeader("Content-Disposition", "attachment;filename=task.xls");
	        
	        //2.实例化导excel共用类（该类在util包里，可当成工具类）
	        ExportExcel<Task> ex = new ExportExcel<Task>();
	        
	        //声明一个数组  里面数据是设置导出的excel头部分（列名）
	        String[] headers = { "序号", "参考位置","任务标题", "执行者", "状态", "优先级","开始时间","结束时间","详细说明"};
	    	
	        
	        //3.声明一个list用来装从数据库查询来的所有商品信息
	        List<Task> dataset = new ArrayList<Task>();
	        dataset=taskService.queryAllTasks(null);//调用数据的查询       
	        
	        OutputStream out = response.getOutputStream();//将response里的响应的内容放进输出流
	        ex.exportExcel(headers, dataset, out);//将头部分，信息集合,输出流都导进表里
	        out.close();
	        System.out.println("excel导出成功！");
	   }
}
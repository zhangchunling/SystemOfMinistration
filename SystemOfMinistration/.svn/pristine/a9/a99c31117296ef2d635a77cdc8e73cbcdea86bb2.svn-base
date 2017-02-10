package com.zrgk.project.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.service.BasicerServiceInter;
import com.zrgk.project.service.impl.BasicerServiceImpl;
import com.zrgk.utils.ExportExcel;
/**
 * 
 * @function: 导出无图片的Excel的servlet，注意的是：重写的是service方法
 * @author: 张春玲
 * @time: 2015-6-9
 *
 */

public class Basic_ExportExcelServlet extends javax.servlet.http.HttpServlet {
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	BasicerServiceInter productService=new BasicerServiceImpl();//创建service层的对象，后面调用方法
    	
    	 //1. 设置消息头：设置了才会有下载弹出框选择存储导出的Excel存储位置
    	response.setContentType("text/html;charset=utf-8");
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition", "attachment;filename=product.xls");
        
        //2.实例化导excel共用类（该类在util包里，可当成工具类）
        ExportExcel<Basicer> ex = new ExportExcel<Basicer>();
        //声明一个数组  里面数据是设置导出的excel头部分（列名）
        String[] headers = { "序号", "项目名称", "客户公司名称", "客户方负责人", "项目经理","开发人数","立项时间","更新时间","计划完成时间",
        		"状态","级别","预估成本","开始时间","修改人","创建人","创建时间","排序条件","备注"};
    	
        String string=request.getParameter("sign");			//得到页面的value的拼接字符串
        BasicerServiceInter bs=new BasicerServiceImpl();	
    	List<Basicer> dataset = new ArrayList<Basicer>();	
        if(string!=null&&!"".equals(string)){
        	String[] ss=string.split(",");					//拆出id拼接成的字符串
        	if(ss!=null){
    			for(String s:ss){							//遍历
    				int id=Integer.parseInt(s);				//将拆除的id解析成数字
    				Basicer basicer=new Basicer();
    				basicer=bs.queryBasicerById(id);		//通过id查回一条数据
    				dataset.add(basicer);					//添加进集合
    			}
    		}
        }			
       
        OutputStream out = response.getOutputStream();		//将response里的响应的内容放进输出流
        ex.exportExcel(headers, dataset, out);				//将头部分，信息集合,输出流都导进表里
        out.close();
    	
   }
}

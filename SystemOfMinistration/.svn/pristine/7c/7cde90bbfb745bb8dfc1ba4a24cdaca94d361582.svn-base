package com.zrgk.infobox.servlet;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zrgk.infobox.model.MailBox;
import com.zrgk.infobox.service.MailBoxServiceInter;
import com.zrgk.infobox.service.impl.MailBoxServiceImpl;
import com.zrgk.utils.ExportExcel;

/**
 *发件箱导出excel的servlet类
 * @author 樊丙富
 *2015-06-07
 */
public class SendExcelServlet extends javax.servlet.http.HttpServlet {
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    MailBoxServiceInter productService=new MailBoxServiceImpl();
    	 // 设置消息头
    	response.setContentType("text/html;charset=utf-8");//导出数据的格式
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition",
                "attachment;filename=product.xls");
        ExportExcel<MailBox> ex = new ExportExcel<MailBox>();//实例化导excel共用类
        //声明一个数组  里面数据是设置导出的excel头部分
        String[] headers = {"","标题","内容","","发件人","时间","","",""};
        //声明一个list用来装从数据库查询来的商品信息
        List<MailBox> dataset = new ArrayList<MailBox>();
        dataset=productService.queryMailBox(new MailBox());//调用数据的查询
        OutputStream out = response.getOutputStream();//流的形式输出
        ex.exportExcel(headers, dataset, out);
      
        out.close();
    	
    	
    }
}
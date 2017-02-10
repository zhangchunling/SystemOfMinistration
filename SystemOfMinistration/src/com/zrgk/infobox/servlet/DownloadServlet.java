package com.zrgk.infobox.servlet;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    private String enc = "utf-8";
 
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//get提交的时候的乱码处理
		String username=new String(request.getParameter("fileName").getBytes("iso8859-1"),"utf-8");
		//post提交时候的乱码处理
		//String username=URLDecoder.decode(request.getParameter("fileName"), "utf-8");
		System.out.println(username);
		String fileName = username;
		// String fileName = "超人.jpg";
		ServletContext sc = this.getServletContext();//Sevlet上下文对象
		String folderPath = sc.getRealPath("/upload");// 文件夹的路径
		InputStream is = new FileInputStream(folderPath + "/" + fileName);// 读进来is.read,再写出去
		response.setContentType("bin");// 以二进制的方式产生一个响应，向响应的头部去添加信息
		// 向响应的头部去添加信息，只有添加信息才能出现一个对话框：response.addHeader
		String str = request.getHeader("User-Agent");// 获取浏览器
		if (str.indexOf("Firefox") != -1) {
			response.addHeader("Content-Disposition", "attachment;filename=\""
					+ new String(fileName.getBytes("utf-8"), "iso8859-1")
					+ "\"");// 做转义 \"做转义
		} else {
			response.addHeader("Content-Disposition", "attachment;filename=\""
					+ URLEncoder.encode(fileName, "utf-8") + "\"");// 做转义 \"做转义
		}
		// response.addHeader("Content-Disposition",
		// "attachment;filename=\""+URLEncoder.encode(fileName,"utf-8")+"\"");//做转义
		// \"做转义
		// 出现乱码，形成框的时候fileName形成乱码
		// response.addHeader("Content-Disposition","attachment;filename=\""+new
		// String(fileName.getBytes("utf-8"),"iso8859-1")+"\"");//做转义 \"做转义
		// 输出得到输出流
		OutputStream os = response.getOutputStream();// 字节型响应
		byte[] b = new byte[2048];
		int len = 0;
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		is.close();
		os.close();
	}


}

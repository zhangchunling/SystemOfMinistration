package com.zrgk.purview.servlet.employee;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.service.EmployeeServiceImpl;
import com.zrgk.purview.service.EmployeeServiceInter;
import com.zrgk.utils.ExportExcel;

public class ExportEmployeetServlet extends HttpServlet {

	EmployeeServiceInter employeeService = new EmployeeServiceImpl();

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		response.addHeader("Content-Disposition",
				"attachment;filename=employee.xls");
		
		
		
		ExportExcel<Employee> ex = new ExportExcel<Employee>();

		 String[] headers = { "用户编号", "姓名", "职业", "性别", "年龄","电话","入职时间" ,"身份证号","角色","备注","状态","密码","用户名","增加时间","修改时间"};
	        
		 List<Employee> dataSet=new ArrayList<Employee>();
		
		 
		 dataSet= employeeService.ExportQueryAll();
		 
		/* if(dataSet!=null&&!"".equals(dataSet.trim())){
			 dataSet=new String(dataSet.getBytes("iso8859-1"),"utf-8");	
		 
		 }*/

		 OutputStream out = response.getOutputStream();
         ex.exportExcel(headers, dataSet, out);
         out.close();
         System.out.println("excel导出成功！");
	} 

}

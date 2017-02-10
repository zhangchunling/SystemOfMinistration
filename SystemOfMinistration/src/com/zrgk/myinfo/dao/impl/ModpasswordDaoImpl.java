package com.zrgk.myinfo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zrgk.myinfo.dao.ModpasswordDaoInter;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.utils.JdbcUtil;
/**
 * 
 * @function: dao层增删改查的实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class ModpasswordDaoImpl extends JdbcUtil implements ModpasswordDaoInter {

	public void options(String sql) {
		this.doPst(null, sql);		
	}
	

	public ResultSet query(String sql) {
		ResultSet rs=this.queryByPst(null, sql);
		this.closeAll();
		return rs;
	}
 

	public Employee queryemployeeByUsername(String username) {
		Employee emp=null;
		String sql="select * from employee where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		//调用查询数据库的方法
		ResultSet rs=this.queryByPst(params, sql);
		
		try {
			if(rs!=null){
					while(rs.next()){
						emp=new Employee();
						emp.setEid(rs.getInt("eid"));
						emp.setName(rs.getString("name"));
						emp.setPosition(rs.getString("position"));
						emp.setSex(rs.getInt("sex"));
						emp.setAge(rs.getInt("age"));
						emp.setTel(rs.getString("tel"));
						emp.setEntryTime(rs.getString("entryTime"));
						emp.setCardNum(rs.getString("cardNum"));
						emp.setState(rs.getString("state"));
						emp.setRemark(rs.getString("remark"));
						emp.setUsername(rs.getString("username"));
						emp.setPassword(rs.getString("password"));
					}
			}
		} catch (SQLException e) {			
					e.printStackTrace();
				 }finally{
					this.closeAll(); 
				 }
		return emp;
	}



	public void updatePassword(Employee employee) {
		String sql="update employee set username=? password=? where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(employee.getPassword());
		this.doPst(params, sql);
	}



	
	
}



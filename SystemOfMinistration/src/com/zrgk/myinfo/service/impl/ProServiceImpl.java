package com.zrgk.myinfo.service.impl;

import java.sql.ResultSet;
import java.util.List;

import com.zrgk.myinfo.dao.ProDaoInter;
import com.zrgk.myinfo.dao.impl.ProDaoImpl;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.myinfo.service.ProServiceInter;
/**
 * 
 * @function: service层的增删改查实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class ProServiceImpl implements ProServiceInter{
	
	ProDaoInter pro=new ProDaoImpl();

	public void options(String sql) {
		// TODO Auto-generated method stub
		
	}

	public ResultSet query(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	//查询人员信息
	public List<Employee> queryEmployees(Employee employee) {
		return pro.queryEmployees(employee);
	}


	

}
package com.zrgk.myinfo.dao;

import java.util.List;

import com.zrgk.myinfo.model.Employee;



/**
 * 
 * @function: dao层的增删改查接口
 * @author: samson
 * @time: 2015-6-12
 *
 */
public interface ProDaoInter {
	
	List<Employee> queryEmployees(Employee employee);//查询人员信息
	
}


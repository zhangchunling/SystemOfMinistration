package com.zrgk.purview.dao;

import java.util.List;

import com.zrgk.purview.model.EidAndRid;
import com.zrgk.purview.model.Employee;

 

/**
 * 
 * 人员表的增删该查的实现类
 * @author wfh
 *2015-06-04
 */
public interface EmployeeDaoInter {
//	查询全部的employee表的内容的方法
	List<Employee> QueryAll(Employee empl);
	
	void insertEmployee(Employee empl);
	
	void deleteEmployee(Employee empl);
	
	Employee QueryByEid(Employee empl);
	
	void UpdateEmployee(Employee empl);
	
	void CancelUpdateEmployee(Employee empl);
	
	 int totalSize(Employee empl);

	List<Employee> ExportQueryAll();

	int QueryByRoleEid(Employee em);

	void addEidAndRid(EidAndRid er);

	int QueryByRole(Employee em);

	void deleteByRidAndMid(EidAndRid er);
		
	
}

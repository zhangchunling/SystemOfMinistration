package com.zrgk.purview.service;

import java.util.List;

import com.zrgk.purview.model.EidAndRid;
import com.zrgk.purview.model.Employee;
import com.zrgk.purview.model.Role;

/**
 * 
 * 业务层的实现类
 * 
 * @author wfh
 * 
 *         2015-06-04
 */
public interface EmployeeServiceInter {

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

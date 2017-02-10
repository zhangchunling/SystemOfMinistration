package com.zrgk.purview.service;

import java.util.List;

import com.zrgk.purview.dao.EmployeeDaoInter;
import com.zrgk.purview.dao.Impl.EmployeeDaoImpl;
import com.zrgk.purview.model.EidAndRid;
import com.zrgk.purview.model.Employee;




public  class EmployeeServiceImpl implements EmployeeServiceInter {

	EmployeeDaoInter employeeDao  = new EmployeeDaoImpl();
	public List<Employee> QueryAll(Employee empl) {
		 
		return employeeDao.QueryAll(empl);
	}
	public void insertEmployee(Employee empl) {
	 
		employeeDao.insertEmployee(empl);
	}
	public void deleteEmployee(Employee empl) {
		employeeDao.deleteEmployee(empl);
		
	}
	public Employee QueryByEid(Employee empl) {
		 
		return employeeDao.QueryByEid(empl);
	}
	public void UpdateEmployee(Employee empl) {
		employeeDao.UpdateEmployee(empl);
		
	}
	public void CancelUpdateEmployee(Employee empl) {
		employeeDao.CancelUpdateEmployee(empl);
		
	}
	public int totalSize(Employee empl) {
		 
		return employeeDao.totalSize(empl);
	}
	public List<Employee> ExportQueryAll() {
		
		return employeeDao.ExportQueryAll();
	}
	public int QueryByRoleEid(Employee em) {
		 
		return employeeDao.QueryByRoleEid(em) ;
	}
	public void addEidAndRid(EidAndRid er) {
		
		employeeDao.addEidAndRid(er);
		
	}
	public int QueryByRole(Employee em) {
		 
		return employeeDao.QueryByRole(em);
	}
	public void deleteByRidAndMid(EidAndRid er) {
		 
		employeeDao.deleteByRidAndMid(er);
	}
	 

}

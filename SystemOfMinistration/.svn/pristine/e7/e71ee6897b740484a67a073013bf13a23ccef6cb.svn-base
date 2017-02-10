package com.zrgk.purview.service;

import java.util.List;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.model.Menu;
import com.zrgk.purview.model.RidAndMid;
import com.zrgk.purview.model.Role;

/**
 * 
 * 业务层的实现类
 * 
 * @author wfh
 * 
 *         2015-06-04
 */
public interface RoleServiceInter {

	List<Role> QueryAll(Role role);

	void deleteRole(Role role);

	Role QueryByRid(Role role);

	void insertRole(Role role);

	void CancelUpdateRole(Role role);

	void UpdateRole(Role role);
	
	int totalSize(Role role);
	
	int QueryByMenus(Role role);
	
	 void deleteByRidAndMid(RidAndMid rm);

	List<Role> QueryAllEmployee(Role role);
	
}

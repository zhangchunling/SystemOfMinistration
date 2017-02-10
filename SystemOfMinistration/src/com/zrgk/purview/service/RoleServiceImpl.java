package com.zrgk.purview.service;

import java.util.List;

import com.zrgk.purview.dao.RoleDaoInter;
import com.zrgk.purview.dao.Impl.RoleDaoImpl;
import com.zrgk.purview.model.Menu;
import com.zrgk.purview.model.RidAndMid;
import com.zrgk.purview.model.Role;

public class RoleServiceImpl implements RoleServiceInter {

	RoleDaoInter roleDao = new RoleDaoImpl();

	public List<Role> QueryAll(Role role) {
		
		
		return roleDao.QueryAll(role);
		 
	}

	public void deleteRole(Role role) {
		 
		roleDao.deleteRole(role);
	}

	public Role QueryByRid(Role role) {
		 
		return  roleDao.QueryByRid(role); 
	}

	public void insertRole(Role role) {
		
		roleDao.insertRole(role);
		
	}

	public void CancelUpdateRole(Role role) {
		 
		roleDao.CancelUpdateRole(role);
		
	}

	public void UpdateRole(Role role) {
		roleDao.UpdateRole(role);
	}

	public int totalSize(Role role) {
		 
		return roleDao.totalSize(role);
	}

 
	public int QueryByMenus(Role role) {
		 
		return roleDao.QueryByMenus(role);
	}

	public void addRidAndMid(RidAndMid rm) {
		roleDao.addRidAndMid(rm);
		
	}

	public void deleteByRidAndMid(RidAndMid rm) {
		roleDao.deleteByRidAndMid(rm);
		
	}

	public List<Role> QueryAllEmployee(Role role) {
		 
		return  roleDao.QueryAllEmployee(role);
	}


}

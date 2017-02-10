package com.zrgk.myinfo.service.impl;






import com.zrgk.myinfo.dao.ModpasswordDaoInter;
import com.zrgk.myinfo.dao.impl.ModpasswordDaoImpl;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.myinfo.service.ModpasswordServiceInter;

/**
 * 
 * @function: service层的增删改查实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class ModpasswordServiceImpl implements ModpasswordServiceInter{
	
	ModpasswordDaoInter pro=new ModpasswordDaoImpl();
	
	
	public Employee queryemployeeByUsername(String username) {
		
		return pro.queryemployeeByUsername(username);
	}

	public void updatePassword(Employee employee) {
		
		pro.updatePassword(employee);
	}
	


}

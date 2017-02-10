package com.zrgk.myinfo.service.impl;





import java.util.List;

import com.zrgk.myinfo.dao.LoginDaoInter;
import com.zrgk.myinfo.dao.impl.LoginDaoImpl;
import com.zrgk.myinfo.model.Employee;
import com.zrgk.myinfo.service.LoginServiceInter;
import com.zrgk.purview.model.Menu;
/**
 * 
 * @function: service层的增删改查实现
 * @author: samson
 * @time: 2015-6-12
 *
 */
public class LoginServiceImpl implements LoginServiceInter{
	
	LoginDaoInter pro=new LoginDaoImpl();

	public Employee login(Employee employee) {
	
		return pro.login(employee);
	}

	public List<Menu> listMenuByEid(int eid) {
		return pro.listMenuByEid(eid);
	}
	

}

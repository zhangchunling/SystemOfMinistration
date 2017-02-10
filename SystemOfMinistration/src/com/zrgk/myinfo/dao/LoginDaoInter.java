package com.zrgk.myinfo.dao;




import java.util.List;

import com.zrgk.myinfo.model.Employee;
import com.zrgk.purview.model.Menu;



/**
 * 
 * @function: dao层的增删改查接口
 * @author: samson
 * @time: 2015-6-12
 *
 */
public interface LoginDaoInter {
	
	//登录方法
	Employee login(Employee employee);
	//根据用户表主键取菜单信息
	List<Menu> listMenuByEid(int eid);
	
}


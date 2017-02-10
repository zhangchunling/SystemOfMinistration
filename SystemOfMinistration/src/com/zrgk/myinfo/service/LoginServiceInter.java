 package com.zrgk.myinfo.service;



import java.util.List;

import com.zrgk.myinfo.model.Employee;
import com.zrgk.purview.model.Menu;
/**
 * 
 * @function: service层的增删改查接口
 * @author: samson
 * @time: 2015-6-12
 *
 */
public interface LoginServiceInter {
	
	Employee login(Employee employee);//登录方法
	//根据用户表主键取菜单信息
	List<Menu> listMenuByEid(int eid);
	}

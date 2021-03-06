package com.zrgk.purview.service;

import java.util.List;

import com.zrgk.purview.model.Employee;
import com.zrgk.purview.model.Menu;

/**
 * 
 * 业务层的实现类
 * 
 * @author wfh
 * 
 *         2015-06-04
 */
public interface MenuServiceInter {

	List<Menu> QueryAll(Menu menu);

	void CancelUpdateMenu(Menu menu);

	void deleteMenu(Menu menu);

	void insertMenu(Menu menu);

	List<Menu> QueryByMid(Menu menu);

	void UpdateMenu(Menu menu);

	 int totalSize(Menu menu);

	List<Menu> addQueryAll(Menu menu);
 

	 

	 
	
	
	
}

package com.zrgk.purview.service;

import java.util.ArrayList;
import java.util.List;

import com.zrgk.purview.dao.MenuDaoInter;
import com.zrgk.purview.dao.Impl.MenuDaoImpl;
import com.zrgk.purview.model.Menu;

public class MenuServiceImpl implements MenuServiceInter {

	MenuDaoInter menuDao = new MenuDaoImpl();

	public List<Menu> QueryAll(Menu menu) {

		return menuDao.QueryAll(menu);

	}

	public void CancelUpdateMenu(Menu menu) {

		menuDao.CancelUpdateMenu(menu);

	}

	public void deleteMenu(Menu menu) {

		menuDao.deleteMenu(menu);
	}

	public void insertMenu(Menu menu) {

		menuDao.insertMenu(menu);
	}

	public List<Menu> QueryByMid(Menu menu) {

		return   menuDao.QueryByMid(menu);
	}

	public void UpdateMenu(Menu menu) {
		menuDao.UpdateMenu(menu);

	}

	public int totalSize(Menu menu) {
		 
		return menuDao.totalSize(menu);
	}

	public List<Menu> addQueryAll(Menu menu) {
		 List<Menu> list=menuDao.addQueryAll( menu);
		 List<Menu> newlist=new ArrayList<Menu>();
		 
		 if(list!=null&&list.size()>0){
			 for(Menu m:list){
				 
				 if(m.getParentId()==0){
					 newlist.add(m);
					 for(Menu m1:list){
						 if(m1.getParentId()==m.getMid()){
							 newlist.add(m1);
						 }
					 }
				 }
			 }
		 }
		 
		return newlist;
	}

}

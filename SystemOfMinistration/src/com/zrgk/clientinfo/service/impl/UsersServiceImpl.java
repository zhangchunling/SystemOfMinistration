package com.zrgk.clientinfo.service.impl;

import java.util.List;

import com.zrgk.clientinfo.dao.UsersDaoInter;
import com.zrgk.clientinfo.dao.impl.UsersDaoImpl;
import com.zrgk.clientinfo.model.Customers;
import com.zrgk.clientinfo.service.UsersServiceInter;



/**
 * 客户信息dao层实现 类
 * @author Simone
 * 2015-06-07
 */
public class UsersServiceImpl implements UsersServiceInter  {
	UsersDaoInter usersDao=new UsersDaoImpl();

	
	//添加
	public void insertUser(Customers user) {
		//调用dao的方法
		usersDao.insertUser(user);
	}

	//查询
	public List<Customers> queryUsers(Customers user) {
		return usersDao.queryUsers(user);
	}
	
	//分页 总条数
	public int totalSize(Customers user) {
		return usersDao.totalSize(user);
	}
	
	//编辑 
	public Customers queryUsersByCid(int cid) {
		return usersDao.queryUsersByCid(cid);
	}
	public void updateUser(Customers user) {
		usersDao.updateUser(user);
		
	}

	//删除
	public void deleteUser(int cid) {
		usersDao.deleteUser(cid);
	}
	
	//
	public List<Customers> queryCustomers(Customers user) {
		return usersDao.queryCustomers(user);
	}

}

package com.zrgk.clientinfo.dao;

import java.util.List;

import com.zrgk.clientinfo.model.Customers;


public interface UsersDaoInter {
	void insertUser(Customers user);//新增客户的方法
	List<Customers> queryUsers(Customers user);//查询用户信息
	void deleteUser(int cid);//删除 用户的方法
	Customers queryUsersByCid(int cid);//根据用户表主键查询用户信息
	void updateUser(Customers user);//修改用户信息
	List<Customers> queryCustomers(Customers cus);//根据父id来查询子类
	int totalSize(Customers user);//总条数（分页用到的）
}

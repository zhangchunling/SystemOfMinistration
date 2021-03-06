package com.zrgk.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zrgk.project.dao.CakeDaoInter;
import com.zrgk.project.dao.impl.CakerDaoImpl;
import com.zrgk.project.model.Caker;
import com.zrgk.project.service.CakeServiceInter;
/**
 * 
 * @function: service层，增删改查实现类
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class CakerServiceImpl implements CakeServiceInter{

	CakeDaoInter cakerDao=new CakerDaoImpl();
	
	
	//插入方法
	public boolean insertCaker(Caker caker) {
		boolean flag=cakerDao.insertCaker(caker);
		return flag;
	}

	public void deleteCaker(int pid) {
		// TODO Auto-generated method stub
		
	}

	//更新方法
	public boolean updateCaker(Caker caker) {
		boolean flag=cakerDao.updateCaker(caker);
		return flag;		
	}

	//查询所有方法
	public List<Caker> queryAllCaker(Caker caker) {
		List<Caker> list=new ArrayList<Caker>();
		list=cakerDao.queryAllCaker(caker);		
		return list;
	}

	//通过id查询
	public Caker queryCakerById(int pid) {
		Caker bas=cakerDao.queryCakerById(pid);
		return bas;
	}

	//通过caker查总的数据条数：分页用
	public int totalSize(Caker caker) {
		int num=cakerDao.totalSize(caker);
		return num;
	}

}

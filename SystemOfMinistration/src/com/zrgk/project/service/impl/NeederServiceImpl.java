package com.zrgk.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zrgk.project.dao.NeedDaoInter;
import com.zrgk.project.dao.impl.NeederDaoImpl;
import com.zrgk.project.model.Needer;
import com.zrgk.project.service.NeederServiceInter;
/**
 * 
 * @function: service层，增删改查实现类
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class NeederServiceImpl implements NeederServiceInter{

	NeedDaoInter needDao=new NeederDaoImpl();
	
	
	//插入方法
	public boolean insertNeeder(Needer needer) {
		boolean flag=needDao.insertNeeder(needer);
		return flag;
	}

	public void deleteNeeder(int pid) {
		// TODO Auto-generated method stub
		needDao.deleteNeeder(pid);
	}

	//更新方法
	public boolean updateNeeder(Needer needer) {
		boolean flag=needDao.updateNeeder(needer);
		return flag;		
	}

	//查询所有方法
	public List<Needer> queryAllNeeder(Needer needer) {
		List<Needer> list=new ArrayList<Needer>();
		list=needDao.queryAllNeeder(needer);		
		return list;
	}

	//通过id查询
	public Needer queryNeederById(int pid) {
		Needer bas=needDao.queryNeederById(pid);
		return bas;
	}

	//查询分页时的总数据条数
	public int totalSize(Needer needer) {
		int i = needDao.totalSize(needer);
		return i;
	}

	//通过project_id查询数据
	public List<Needer> queryByPojectId(int id) {
		List<Needer> list=new ArrayList<Needer>();
		list=needDao.queryByPojectId(id);
		return list;
	}

}
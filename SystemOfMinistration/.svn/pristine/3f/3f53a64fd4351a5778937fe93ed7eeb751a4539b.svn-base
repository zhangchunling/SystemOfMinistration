package com.zrgk.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zrgk.project.dao.BasicerDaoInter;
import com.zrgk.project.dao.impl.BasicerDaoImpl;
import com.zrgk.project.model.Basicer;
import com.zrgk.project.service.BasicerServiceInter;
/**
 * 
 * @function: service层，增删改查实现类
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public class BasicerServiceImpl implements BasicerServiceInter{

	BasicerDaoInter basicDao=new BasicerDaoImpl();
	
	
	//插入方法
	public boolean insertBasicer(Basicer basicer) {
		boolean flag=basicDao.insertBasicer(basicer);
		return flag;
	}

	//删除方法
	public void deleteBasicer(int pid) {
		basicDao.deleteBasicer(pid);		
	}

	//更新方法
	public boolean updateBasicer(Basicer basicer) {
		boolean flag=basicDao.updateBasicer(basicer);
		return flag;		
	}

	//查询所有方法
	public List<Basicer> queryAllBasicer(Basicer basicer) {
		List<Basicer> list=new ArrayList<Basicer>();
		list=basicDao.queryAllBasicer(basicer);		
		return list;
	}

	//通过id查询
	public Basicer queryBasicerById(int pid) {
		Basicer bas=basicDao.queryBasicerById(pid);
		return bas;
	}

	//查询总数据条数
	public int totalSize(Basicer basicer) {
		int num=basicDao.totalSize(basicer);
		return num;
	}

}

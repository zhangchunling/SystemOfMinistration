package com.zrgk.project.dao;

import java.util.List;

import com.zrgk.project.model.Basicer;
/**
 * 
 * @function: dao层，增删改查接口
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public interface BasicerDaoInter {
	
	boolean insertBasicer(Basicer basicer);			//增	
	void deleteBasicer(int pid);					//删
	boolean updateBasicer(Basicer basicer);			//改
	List<Basicer> queryAllBasicer(Basicer basicer);	//查询所有
	Basicer queryBasicerById(int pid);				//按id查
	int totalSize(Basicer basicer);					//查询总数据条数
}

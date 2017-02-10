package com.zrgk.project.service;

import java.util.List;

import com.zrgk.project.model.Caker;
/**
 * 
 * @function: dao层，增删改查接口
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public interface CakeServiceInter {
	
	boolean insertCaker(Caker caker);		//增	
	void deleteCaker(int pid);				//删
	boolean updateCaker(Caker caker);		//改
	List<Caker> queryAllCaker(Caker caker);	//查询所有
	Caker queryCakerById(int pid);			//按id查
	int totalSize(Caker caker);				//查询总数据条数

}

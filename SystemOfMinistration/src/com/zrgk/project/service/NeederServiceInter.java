package com.zrgk.project.service;

import java.util.List;

import com.zrgk.project.model.Needer;
/**
 * 
 * @function: service层，增删改查接口
 * @author: 张春玲
 * @time: 2015-6-4
 *
 */
public interface NeederServiceInter {
	
	boolean insertNeeder(Needer needer);		//增	
	void deleteNeeder(int pid);					//删
	boolean updateNeeder(Needer needer);		//改
	List<Needer> queryAllNeeder(Needer needer);	//查询所有
	Needer queryNeederById(int pid);			//按id查
	int totalSize(Needer needer);				//查询总数据条数
	List<Needer> queryByPojectId(int id);		//通过project_id查数据，联动用
}

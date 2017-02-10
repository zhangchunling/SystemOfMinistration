package com.zrgk.project.dao;

import java.util.List;

import com.zrgk.project.model.Basicer;
import com.zrgk.project.model.Needer;
/**
 * 
 * @function: dao层，增删改查接口
 * @author: 张春玲
 * @time: 2015-6-8
 *
 */
public interface NeedDaoInter {
	
	boolean insertNeeder(Needer needer);		//增	
	void deleteNeeder(int pid);					//删
	boolean updateNeeder(Needer needer);		//改
	List<Needer> queryAllNeeder(Needer needer);	//查询所有
	Needer queryNeederById(int pid);			//按id查
	int totalSize(Needer needer);				//查询总数据条数
	List<Needer> queryByPojectId(int id);		//通过project_id查数据，联动用
}

package com.zrgk.task.dao;

import java.util.List;

import com.zrgk.project.model.Basicer;
import com.zrgk.task.model.Basic_Info;

/**
 * @function: 任务管理dao层的接口类——BasicDaoInter.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public interface BasicDaoInter {
	
	List<Basic_Info> queryAllBasic(Basic_Info basic);	//查询所有
	
}

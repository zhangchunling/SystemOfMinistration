package com.zrgk.task.dao;

import java.util.List;
import com.zrgk.task.model.Function_sheet;

/**
 * @function: 任务管理dao层的接口类——FunctionDaoInter.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public interface FunctionDaoInter {
	
	List<Function_sheet> queryAllFunction(Function_sheet function);		//查询所有

}

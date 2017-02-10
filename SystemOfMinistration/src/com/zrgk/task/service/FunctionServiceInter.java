package com.zrgk.task.service;

import java.util.List;
import com.zrgk.task.model.Basic_Info;
import com.zrgk.task.model.Function_sheet;

/**
 * @function: 任务管理Service层的接口类——FunctionServiceInter.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public interface FunctionServiceInter {
	
	List<Function_sheet> queryAllFunction(Function_sheet function);		//查询所有
}

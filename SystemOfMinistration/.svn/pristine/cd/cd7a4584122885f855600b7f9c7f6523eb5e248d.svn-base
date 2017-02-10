package com.zrgk.task.service.impl;
import java.util.List;
import java.util.ArrayList;
import com.zrgk.utils.JdbcUtil;
import com.zrgk.task.dao.FunctionDaoInter;
import com.zrgk.task.dao.impl.FunctionDaoImpl;
import com.zrgk.task.model.Function_sheet;
import com.zrgk.task.service.FunctionServiceInter;
/**
 * @function: 任务管理service层实现类——FunctionServiceImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class FunctionServiceImpl extends JdbcUtil implements FunctionServiceInter{
	
	//调用dao包中接口中的实现类
	FunctionDaoInter functionDao=new FunctionDaoImpl();	
	
	public List<Function_sheet> queryAllFunction(Function_sheet function) {
		List<Function_sheet> list=new ArrayList<Function_sheet>();
		list=functionDao.queryAllFunction(function);
		return list;
	}	
}
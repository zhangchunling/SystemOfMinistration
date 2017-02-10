package com.zrgk.task.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.zrgk.utils.JdbcUtil;
import com.zrgk.task.model.Need_sheet;
import com.zrgk.task.dao.NeedDaoInter;
import com.zrgk.task.dao.impl.NeedDaoImpl;
import com.zrgk.task.service.NeedServiceInter;
/**
 * @function: 任务管理service层实现类——NeedServiceImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class NeedServiceImpl extends JdbcUtil implements NeedServiceInter{
	
	//调用dao包中接口中的实现类
	NeedDaoInter needDao=new NeedDaoImpl();
	
	public List<Need_sheet> queryAllNeed(Need_sheet need) {
		
		List<Need_sheet> list=new ArrayList<Need_sheet>();
		list=needDao.queryAllNeed(need);
		return list;
	}	
}
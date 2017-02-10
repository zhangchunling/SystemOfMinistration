package com.zrgk.task.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.zrgk.task.dao.CakerDaoInter;
import com.zrgk.task.dao.impl.CakerDaoImpl;
import com.zrgk.task.model.Caker_sheet;
import com.zrgk.task.service.CakerServiceInter;
import com.zrgk.utils.JdbcUtil;
/**
 * @function: 任务管理service层实现类——BasicServiceImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class CakerServiceImpl extends JdbcUtil implements CakerServiceInter{
	
	//调用dao包中接口中的实现类
	CakerDaoInter cakerDao=new CakerDaoImpl();

	public List<Caker_sheet> queryAllCaker(Caker_sheet caker) {
		
		List<Caker_sheet> list=new ArrayList<Caker_sheet>();
		list=cakerDao.queryAllCaker(caker);
		return list;
	}
}
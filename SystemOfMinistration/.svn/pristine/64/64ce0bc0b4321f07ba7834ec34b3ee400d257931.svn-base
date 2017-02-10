package com.zrgk.task.service.impl;

import java.util.List;
import com.zrgk.task.dao.BasicDaoInter;
import com.zrgk.task.dao.impl.BasicDaoImpl;
import com.zrgk.task.model.Basic_Info;
import com.zrgk.task.service.BasicServiceInter;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理service层实现类——BasicServiceImpl.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public class BasicServiceImpl extends JdbcUtil implements BasicServiceInter{
	
	//调用dao包中接口中的实现类
	BasicDaoInter basicDao=new BasicDaoImpl();
	Basic_Info basic=new Basic_Info();

	public List<Basic_Info> queryAllBasic(Basic_Info basic) {

		return basicDao.queryAllBasic(basic);
	}
	
}
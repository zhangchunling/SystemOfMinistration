package com.zrgk.task.dao;

import java.util.List;
import com.zrgk.task.model.Caker_sheet;
/**
 * @function: 任务管理dao层的接口类——CakerDaoInter.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public interface CakerDaoInter {
	
	List<Caker_sheet> queryAllCaker(Caker_sheet caker);		//查询所有

}

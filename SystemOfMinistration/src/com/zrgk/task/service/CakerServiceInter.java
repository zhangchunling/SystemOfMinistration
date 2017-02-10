package com.zrgk.task.service;

import java.util.List;
import com.zrgk.task.model.Basic_Info;
import com.zrgk.task.model.Caker_sheet;

/**
 * @function: 任务管理Service层的接口类——CakerServiceInter.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public interface CakerServiceInter {
	
	List<Caker_sheet> queryAllCaker(Caker_sheet caker);		//查询所有
}

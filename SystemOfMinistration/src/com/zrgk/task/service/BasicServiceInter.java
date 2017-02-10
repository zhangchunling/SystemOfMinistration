package com.zrgk.task.service;

import java.util.List;
import com.zrgk.task.model.Basic_Info;

/**
 * @function: 任务管理Service层的接口类——BasicServiceInter.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public interface BasicServiceInter {
	
	List<Basic_Info> queryAllBasic(Basic_Info basic);		//查询所有
}

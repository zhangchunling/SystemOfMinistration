package com.zrgk.task.dao;

import java.util.List;
import com.zrgk.task.model.Need_sheet;

/**
 * @function: 任务管理dao层的接口类——NeedDaoInter.java
 * @author: 刘淼
 * @time: 2015-6-11
 * */
public interface NeedDaoInter {
	
	List<Need_sheet> queryAllNeed(Need_sheet need);		//查询所有

}

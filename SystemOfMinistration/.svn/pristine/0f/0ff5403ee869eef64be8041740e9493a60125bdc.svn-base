package com.zrgk.task.service.impl;

import java.util.List;

import com.zrgk.task.dao.TaskDaoInter;
import com.zrgk.task.dao.impl.TaskDaoImpl;
import com.zrgk.task.model.Employee;
import com.zrgk.task.model.Task;
import com.zrgk.task.service.TaskServiceInter;
import com.zrgk.utils.JdbcUtil;

/**
 * @function: 任务管理service层实现类——TaskDaoImpl.java
 * @author: 刘淼
 * @time: 2015-6-4
 * */
public class TaskServiceImpl extends JdbcUtil implements TaskServiceInter{

	TaskDaoInter taskDao=new TaskDaoImpl();
	
//	添加任务信息
	public void insertTask(Task task) {
		
		taskDao.insertTask(task);
	}

//	查询所有任务信息
	public List<Task> queryAllTasks(Task task) {
		
		return taskDao.queryAllTasks(task);
	}	

//	查询除参考位置的任务表信息
	public List<Task> queryTasks(Task task) {
		
		return taskDao.queryTasks(task);
	}
	
//	按id查询任务信息
	public List<Task> queryByIdTask(int tid) {
		
		return taskDao.queryByIdTask(tid);
	}	
	
//	按执行者查询
	public Task queryExecutorTask(int executor) {
		
		return taskDao.queryExecutorTask(executor);
	}

//	按查询任务标题查询
	public Task queryplanOptionTask(String planOption) {
		
		return taskDao.queryplanOptionTask(planOption);
	}
	
//	删除任务——按id删除任务
	public void deleteTask(int tid) {
		
		taskDao.deleteTask(tid);
	}	

//	更新任务信息
	public void updateTask(Task task) {
		
		taskDao.updateTask(task);
	}

//	总条数
	public int totalSize(Task task) {

		int number=taskDao.totalSize(task);
		return number;
	}

	public void updateStartTask(Task task) {
		taskDao.updateStartTask(task);
		
	}

	public void updateEndTask(Task task) {
		taskDao.updateEndTask(task);
		
		
	}

	public void deleteTask(Task task) {
		taskDao.deleteTask(task);
	}

	public List<Employee> queryAllEmployee() {
		 
		return taskDao.queryAllEmployee();
	}

	 
}